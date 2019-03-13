package application.controllers;


import application.model.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {



    @RequestMapping(value = "/register.html", method = RequestMethod.GET)
    public String register(Model model)
    {
        UserDTO userDto = new UserDTO();

        model.addAttribute("user", userDto);


        System.out.println(userDto.getFirstName());
        return "register.html";
    }

}
