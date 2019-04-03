package application.model;


import lombok.*;
import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

// DATA TRANSFER OBJECT
@Entity
@Table(name="USER")

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Valid
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id")
    private Long id;


    @Size(min=3, max=32)
    private String login;

    @Size(min=3, max=32)
    private String firstName;

    @Size(min=2, max=32)
    private String password;

    @Email
    @NotEmpty
    private String email;


    public User(String login, String firstName, String password, String email) {
        this.login = login;
        this.firstName = firstName;
        this.password = password;
        this.email = email;

    }




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
