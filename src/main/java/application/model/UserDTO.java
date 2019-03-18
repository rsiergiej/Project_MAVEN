package application.model;


import lombok.*;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

// DATA TRANSFER OBJECT
@Entity
@Table(name="USER")

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Valid
public class UserDTO {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @NotEmpty
    @NotNull
    private String login;
    @NotEmpty
    @NotNull
    private String firstName;
    @NotEmpty
    @NotNull
    private String password;
    @NotEmpty
    @NotNull
    @Email
    private String email;


    public UserDTO(String login, String firstName, String password, String email) {
        this.login = login;
        this.firstName = firstName;
        this.password = password;
        this.email =email;

    }

//
//    public void validate(Errors errors) {
//
//
//        if (this.login.length() < 4 || this.login.length() > 32) {
//            errors.rejectValue("login", "Size.userForm.login");
//        }
//        if (this.findByUsername(user.getUsername()) != null) {
//            errors.rejectValue("username", "Duplicate.userForm.username");
//        }
//
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
//        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
//            errors.rejectValue("password", "Size.userForm.password");
//        }
//
//        if (!user.getPasswordConfirm().equals(user.getPassword())) {
//            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
//        }
//    }
}
