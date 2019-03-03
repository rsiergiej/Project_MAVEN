package com.Controllers;


import com.Entity.Person;
import com.Repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
     */


    @Autowired
    private PersonRepository personRepository;
    private String someArgument ="test";


    @GetMapping("/status/check")
    public String status()
    {
        return "working";
    }

    @GetMapping ("getallperson")
    public List<Person> getAllPerson()
    {
        return personRepository.findAll();
    }


    // The @RequestBody annotation is used to bind the request body with a method parameter.
    // The @Valid annotation makes sure that the request body is valid. Remember, we had marked Note’s title and content with @NotBlank annotation in the Note model?
    @PostMapping("addperson")
    public Person createPerson(@Valid @RequestBody Person person)
    {
        return personRepository.save(person);
    }





    @GetMapping("/personID/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable(value = "id") Long id) {
        Optional<Person> person = personRepository.findById(id);
        return ResponseEntity.ok().body(person.orElseThrow(() -> new RuntimeException("Unknown IDPerson")));
    }



    @GetMapping("/personNAME/{name}")
    public ResponseEntity<Person> getByName(@PathVariable(value = "name") String name) {
        Person person = personRepository.findByName(name);
        if(person == null) {
            System.err.println("tutaj");

            return ResponseEntity.badRequest().body(person);
           // return ResponseEntity.notFound().build("Brak");
        }
        return ResponseEntity.ok().body(person);
    }








//    @RequestMapping
//    public String showUsers(Person model, Pageable pageable)
//    {
//
//
//        return "users";
//    }


}
