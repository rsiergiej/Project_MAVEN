package com.Controller;

import com.Entity.Person;
import com.Repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.awt.print.Pageable;


@Controller
@RequestMapping("/users")
public class UserController {


    @Autowired
    PersonRepository repository;

    @RequestMapping
    public String showUsers(Person model, Pageable pageable)
    {


        return "users";
    }


}
