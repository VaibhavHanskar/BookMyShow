package dev.vaibhav.BookMyShow.DataTransferObject;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSignupDTO {
    private String name;
    private String email;
    private String password;
}
