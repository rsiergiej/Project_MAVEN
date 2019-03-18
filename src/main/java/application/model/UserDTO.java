package application.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

// DATA TRANSFER OBJECT
@Entity
@Table(name="USER")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
}
