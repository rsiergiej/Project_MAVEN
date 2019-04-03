package application.controllers;


import application.Repositories.UserRepository;
import application.model.LoginUserDto;
import application.model.User;
import application.security.AES;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.validation.Valid;


@Controller
public class LoginController {


    @Autowired
    UserRepository userRepository;

    @RequestMapping(value="/loginPage.html", method = RequestMethod.GET)
    public String loginPage(Model model)
    {

        LoginUserDto loginUserDto = new LoginUserDto();

        loginUserDto.setEmail("login@wp.pl");
        //loginUserDto.setPassword("testpassword");
        model.addAttribute("loginUserDto", loginUserDto);



        return "loginPage.html";
    }



    @PostMapping("/loginPage.html")
    public String loginSumbit(Model model, @Valid LoginUserDto loginUserDto, BindingResult bindingResult)
    {
        String loginComment = "error";
        if(bindingResult.hasErrors()) return "loginPage.html";

        User user = userRepository.findByEmail(loginUserDto.getEmail());
        if(user == null)
        {
            loginComment = "bad email";
        }else
        {
            AES aes = new AES();
            String passwordEncrypted = "bad password";
            try {
                 passwordEncrypted = aes.encrypt(loginUserDto.getPassword());
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                if(passwordEncrypted.equals(user.getPassword()))
                {
                    loginComment = "SUCCES";
                }
            }
        }

        model.addAttribute("loginMessage", loginComment);
        return "loginDonePage.html";
    }






}
