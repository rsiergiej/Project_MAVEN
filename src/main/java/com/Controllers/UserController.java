package com.Controllers;


import com.Entity.Person;
import com.Repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


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
            return ResponseEntity.badRequest().body(person);
        }
        return ResponseEntity.ok().body(person);
    }




    @DeleteMapping("/persondelete/{id}") // działa prawidłowo
    public ResponseEntity deleteNote(@PathVariable(value="id") Long personId)
    {
        Optional<Person> peronDelete = personRepository.findById(personId);
        if(peronDelete.isPresent())
        {
            personRepository.deleteById(personId);
            return ResponseEntity.ok().build();
        }else
        {
            return ResponseEntity.badRequest().build();
        }
    }


//    @GetMapping("/getallpersonsort/{column}")
//    public List getallpersonsort(@PathVariable(value="column") String column)
//    {
//
//        if(column.equals("name"))
//        {
//            return personRepository.findAll(Sort.by("name"));
//        }else if (column.equals("description"))
//        {
//            return personRepository.findAll(Sort.by("description"));
//        }else if (column.equals("id"))
//        {
//            return personRepository.findAll(Sort.by("id"));
//        }else
//        {
//            return null;
//        }
//    }



//    @GetMapping("/getallpersonsort/{column}")
//    public List getallpersonsort(@PathVariable(value="column") String column, @SortDefault(sort=column) Sort sort)
//    {
//
//        return personRepository.findAll(sort);
//
//
//    }


    //g allPerson/nameStartWith?name=r&sort=name&name.dir=desc

    @GetMapping("/search/person")
        public List getallpersonsort(
                @RequestParam (value="direction") Sort.Direction dir,
                @RequestParam (value="column") String column)
    {
        List<Person> list =  personRepository.findAll(Sort.by(dir, column));
        return list;
    }



}
