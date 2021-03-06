package application.controllers;


import application.model.Person;
import application.Repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping("/person")
public class PersonController {




    @Autowired
    private PersonRepository personRepository;


// ZOBACZ html tutorial https://www.logicbig.com/tutorials/spring-framework/spring-data/sorting-and-pagination.html
    // ZOBACZ https://spring.io/guides/tutorials/bookmarks/
    @GetMapping("/status") // działa prawidłowo
    public String status()
    {
        return "working";
    }

    @GetMapping ("/getallperson") // działa prawidłowo
    public List<Person> getAllPerson()
    {
        return personRepository.findAll();
    }


    // The @RequestBody annotation is used to bind the request body with a method parameter.
    // The @Valid annotation makes sure that the request body is valid. Remember, we had marked Note’s title and content with @NotBlank annotation in the Note model?
    @PostMapping("/addperson")
    public Person addPerson(@Valid @RequestBody Person person) // działa prawidłowo i zwaraca tylko dodany obiekt
    {

        return personRepository.save(person);
    }





    @GetMapping("/personID/{id}") // działa prawidłowo
    public ResponseEntity<Person> getPersonById(@PathVariable(value = "id") Long id) {
        Optional<Person> person = personRepository.findById(id);

        if(person.isPresent())
        {
            return ResponseEntity.ok().body(person.get());
        }else
        {
            return ResponseEntity.badRequest().build();
        }

        //return ResponseEntity.ok().body(person.orElseThrow(() -> new RuntimeException("Unknown ID Person")));
    }



    @GetMapping("/personNAME/{name}") // działa prawidłowo, zwraca person lub bad request jezeli nie ma takiego person
    public ResponseEntity<Person> getByName(@PathVariable(value = "name") String name) {
        Person person = personRepository.findByName(name);
        if(person == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().body(person);
    }

    @PutMapping("/personedit/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable(value = "id") Long personId, @Valid @RequestBody Person personDetails)
    {
        Person person = personRepository.findByid(personId);
        if(person != null)
        {


            person.setName(personDetails.getName());
            person.setDescription(personDetails.getDescription());
            personRepository.save(person);
            return ResponseEntity.ok().build();
        }else
        {
            return ResponseEntity.badRequest().build();
        }
    }


    @DeleteMapping("/persondelete/{id}") // działa prawidłowo
    public ResponseEntity deleteNote(@PathVariable(value="id") Long personId)
    {
        Optional<Person> peronDelete = personRepository.findById(personId);
        Person personDelete = personRepository.findByid(personId);

        if(peronDelete.isPresent())
        {
            personRepository.deleteById(personId);
            return ResponseEntity.ok().build();
        }else
        {
            return ResponseEntity.badRequest().build();
        }
    }




/*
    @GetMapping("/getallpersonsort/{column}")
    public List getallpersonsort(@PathVariable(value="column") String column, @SortDefault(sort=column) Sort sort)
    {
        return personRepository.findAll(sort);
    }
 */

    //http://localhost:8080/users/search/person/?direction=DESC&column=id
    @GetMapping("/search/person")
        public ResponseEntity<List> getallpersonsort( // ASC - sortowanie rosnaco ; DESC - sortowanie malejąco
                @RequestParam (value="direction" , defaultValue = "ASC") Sort.Direction dir,
                @RequestParam (value="column", defaultValue = "id") String column)
    {

        /*
       COMMENT: metoda nie jest autoamtyczna ponieważ pobiera liste pól z klasy Person, a powinna pobierac listę kolumn z tabeli stworzonej na podstawie klasy Person

        Przykładowa implementacja:
           @GetMapping("/getallpersonsort/{column}")
           public List getallpersonsort(@PathVariable(value="column") String column, @SortDefault(sort=column) Sort sort)
            {
                return personRepository.findAll(sort);
            }
         */
        try {
            Class cls = Class.forName("com.Entity.Person");
            Field f[] = cls.getDeclaredFields();
            for (int i = 0; i < f.length; i++) {
				System.out.println(f[i]);
				if(column.equals(f[i].getName()))
                {
                    List<Person> list =  personRepository.findAll(Sort.by(dir, column));
                    return ResponseEntity.ok().body(list);
                }
			}
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return ResponseEntity.badRequest().build();
    }




//    @GetMapping("/person/page")
//    public Page<Person> getEmployees(@PageableDefault(size = 3, sort = "id") Pageable pageable,
//                               Model model) {
//        Page<Person> page = personRepository.findAll(pageable);
//        List<Sort.Order> sortOrders = page.getSort().stream().collect(Collectors.toList());
//        if (sortOrders.size() > 0) {
//            Sort.Order order = sortOrders.get(0);
//            model.addAttribute("sortProperty", order.getProperty());
//            model.addAttribute("sortDesc", order.getDirection() == Sort.Direction.DESC);
//        }
//        model.addAttribute("page", page);
//        return page;
//    }

    @GetMapping("/person/page")
    public Page<Person> getPersonPage(
            @RequestParam (value = "page") int page,
            @RequestParam(value = "size") int size
    )
    {
// https://www.logicbig.com/tutorials/spring-framework/spring-data/sorting-and-pagination.html

        Page<Person> pagePesron = personRepository.findAll(PageRequest.of(page, size));
            return pagePesron;
    }








}
