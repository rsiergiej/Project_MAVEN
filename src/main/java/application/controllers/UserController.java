package application.controllers;


import application.Repositories.UserRepository;
import application.model.User;
import application.security.AES;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{login}")
    public ResponseEntity<User> getUserLogin (@PathVariable(value="login") String login )
    {

        User user = userRepository.findByLogin(login);

        if(user == null)
        {
            return ResponseEntity.badRequest().build();
        }

       AES aesDecrypt = new AES();

        try {
            user.setPassword(aesDecrypt.decrypt(user.getPassword()));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }


        return ResponseEntity.ok().body(user);
    }




}
