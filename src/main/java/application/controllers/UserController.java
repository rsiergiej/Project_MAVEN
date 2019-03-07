package application.controllers;


import application.model.Person;
import application.Repositories.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Field;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.domain.Sort.Direction.ASC;


@RestController
@RequestMapping("/users")
public class UserController {

    /*
    Pobranie listy produktów
Pobranie szczegółów produktu
Dodanie produktu
Usunięcie produkt
Sortowanie listy
paginacja
logowanie
formularze


jak wykona się poprawnie to zwarcam 200
jezeli wyjatek to 500



thymeleafem  lub JSP  - frontend
     */


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










//        if(column.equals("id") || column.equals("name") || column.equals("description"))
//        {
//            List<Person> list =  personRepository.findAll(Sort.by(dir, column));
//            return ResponseEntity.ok().body(list);
//        }else
//        {
//            return ResponseEntity.badRequest().build();
//        }





    @GetMapping("/person/page")
    public Page<Person> getPersonPage(
            @RequestParam (value = "page") int page,
            @RequestParam(value = "size") int size
    )
    {
// https://www.logicbig.com/tutorials/spring-framework/spring-data/sorting-and-pagination.html


       // Pageable pp = new PageRequest.of(page, size);
       // Page<Person> pagePesron = personRepository.findAll(pp);



        // http://www.bswen.com/2018/06/springboot-springboot-2-with-JPA-pagination-example.html
        //Pageable pageable = PageRequest.of(0,page);
        //Page<Person> students = personRepository.findAll(pageable);
        //assertEquals(students.getSize(),page);



            return null;




    }






    // THYMELEAF views https://www.logicbig.com/tutorials/spring-framework/spring-data/sorting-and-pagination.html


}
