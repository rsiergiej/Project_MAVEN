package application.controllers;


import application.model.Login;
import application.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;


@Controller
public class LoginController {



    @RequestMapping(value="/loginPage.html", method = RequestMethod.GET)
    public String loginPage(Model model)
    {


//        User userDto = new User();
//
//        userDto.setLogin("login");
//        userDto.setFirstName("name");
//        userDto.setEmail("ww@gmail.com");
//        userDto.setPassword("test123");
//        model.addAttribute("userLogin", userDto);


        return "loginPage.html";
    }



    @PostMapping("/loginPage.html")
    public String loginSumbit(Login userLogin, BindingResult bindingResult)
    {
        //User userLogin = new User();

        System.out.println(userLogin.getEmail() + " " + userLogin.getPassword());


        if (bindingResult.hasErrors()) {
            return "loginPage.html";
        }
        return "OK";
    }


}
