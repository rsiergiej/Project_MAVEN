package application.controllers;


import application.Repositories.UserRepository;
import application.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class LoginController {


    @Autowired
    private UserRepository userRepository;



    @RequestMapping(value = "/register.html", method = RequestMethod.GET)
    public String registerForm(Model model)
    {
        UserDTO userDto = new UserDTO();

        userDto.setLogin("login");
        userDto.setFirstName("name");
        userDto.setEmail("ww@gmail.com");
        model.addAttribute("user", userDto);

       // System.out.println(userDto.getFirstName());
        return "register.html";
    }


    @PostMapping("/register.html")
    public String registerSubmit(@ModelAttribute(value="user") UserDTO userDTO, BindingResult bindingResult)
    {
//  https://hellokoding.com/registration-and-login-example-with-spring-xml-configuration-maven-jsp-and-mysql/
// http://websystique.com/spring-security/spring-security-4-password-encoder-bcrypt-example-with-hibernate/


//        try {
//            MessageDigest md = MessageDigest.getInstance("SHA-256");
//            byte[] hashInBytes = md.digest(userDTO.getPassword().getBytes(StandardCharsets.UTF_8));
//
//            StringBuilder sb = new StringBuilder();
//            for (byte b : hashInBytes) {
//                sb.append(String.format("%02x", b));
//            }
//            System.out.println("SZYFROWANIE: " + sb.toString());
//
//            String encoded = Base64.getEncoder().encodeToString(hashInBytes);
//                    System.out.println("ENCODE: " + encoded);
//
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }

        userRepository.save(userDTO);
        System.out.println(userDTO.toString());
        return "doneregister.html";
    }
}
