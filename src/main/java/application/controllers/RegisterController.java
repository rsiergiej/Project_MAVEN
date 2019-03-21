package application.controllers;


import application.Repositories.UserRepository;
import application.model.User;
import application.security.AES;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;


@Controller
public class RegisterController {


    @Autowired
    private UserRepository userRepository;





    @RequestMapping(value = "/register.html", method = RequestMethod.GET)
    public String registerForm(Model model)
    {
        User userDto = new User();

        userDto.setLogin("login");
        userDto.setFirstName("name");
        userDto.setEmail("ww@gmail.com");
        userDto.setPassword("test123");
        model.addAttribute("user", userDto);

        return "register.html";
    }


    @PostMapping("/register.html")
    public String registerSubmit(@Valid User user, BindingResult bindingResult)
    {
//  https://hellokoding.com/registration-and-login-example-with-spring-xml-configuration-maven-jsp-and-mysql/
// http://websystique.com/spring-security/spring-security-4-password-encoder-bcrypt-example-with-hibernate/


        if(userRepository.findByLogin(user.getLogin()) != null)
        {
            bindingResult.rejectValue("login", "login.missing","Duplicate login");
           // bindingResult.reject("login", "login");

            System.out.println(bindingResult.hasErrors());
        }

        AES passwordAes = new AES();
        try {
            user.setPassword(passwordAes.encrypt(user.getPassword()));
        } catch (Exception e) {
            bindingResult.rejectValue("password", "login.password","Bad password");
            e.printStackTrace();
        }


        if (bindingResult.hasErrors()) {
            return "register.html";
        }

        userRepository.save(user);
        System.out.println(user.toString());
        return "doneregister.html";
    }
}
