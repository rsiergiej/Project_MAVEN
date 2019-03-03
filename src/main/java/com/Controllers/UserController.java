package com.Controllers;


import com.Entity.Person;
import com.Repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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


jak wykona się poprawnie to zwarcam 200
jezeli wyjatek to 500
     */


    @Autowired
    private PersonRepository personRepository;



    // ZOBACZ https://spring.io/guides/tutorials/bookmarks/
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
    public Person addPerson(@Valid @RequestBody Person person)
    {
        return personRepository.save(person);
    }





    @GetMapping("/personID/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable(value = "id") Long id) {
        Optional<Person> person = personRepository.findById(id);
        return ResponseEntity.ok().body(person.orElseThrow(() -> new RuntimeException("Unknown ID Person")));
    }



    @GetMapping("/personNAME/{name}")
    public ResponseEntity<Person> getByName(@PathVariable(value = "name") String name) {
        Person person = personRepository.findByName(name);
        if(person == null) {
            return ResponseEntity.badRequest().body(person);
        }
        return ResponseEntity.ok().body(person);
    }





    @DeleteMapping("/persondelete/{id}") //DONE; ok -> 200, error ->not found 404
    public ResponseEntity deleteNote(@PathVariable(value="id") Long personId)
    {
        Optional<Person> peronDelete = personRepository.findById(personId);
        if(peronDelete.isPresent())
        {
            personRepository.deleteById(personId);
            return ResponseEntity.ok().header("Delete Person").body(peronDelete);
        }else
        {
            return ResponseEntity.notFound().build();
        }
    }





}
