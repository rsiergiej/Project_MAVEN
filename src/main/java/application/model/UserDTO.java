package application.model;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

// DATA TRANSFER OBJECT
@Getter
@Setter
public class UserDTO {

    @NotNull
    @NotEmpty
    private String login;
    @NotNull
    @NotEmpty
    private String firstName;
    @NotNull
    @NotEmpty
    private String password;
    @NotNull
    @NotEmpty
    private String email;


}
