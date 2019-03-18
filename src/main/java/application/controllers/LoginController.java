package application.controllers;


import application.Repositories.UserRepository;
import application.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {


    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/register.html", method = RequestMethod.GET)
    public String register(Model model)
    {
        UserDTO userDto = new UserDTO();

        userDto.setLogin("login");
        userDto.setFirstName("name");
        userDto.setEmail("ww@gmail.com");
        model.addAttribute("user", userDto);

        System.out.println(userDto.getFirstName());
        return "register.html";
    }


    @PostMapping("/register.html")
    public String registerPOST(@ModelAttribute(value="user") UserDTO userDTO)
    {

        userRepository.save(userDTO);
        System.out.println(userDTO.getLogin());
        return "register.html";
    }
}
