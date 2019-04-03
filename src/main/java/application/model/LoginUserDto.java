package application.model;


import lombok.*;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;




@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Valid
public class LoginUserDto {




    @Email
    @NotEmpty
    private String email;

    @Size(min=2, max=32)
    private String password;
}
