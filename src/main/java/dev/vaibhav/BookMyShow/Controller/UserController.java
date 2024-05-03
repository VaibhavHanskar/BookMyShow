package dev.vaibhav.BookMyShow.Controller;

import dev.vaibhav.BookMyShow.DataTransferObject.UserLoginDTO;
import dev.vaibhav.BookMyShow.DataTransferObject.UserSignupDTO;
import dev.vaibhav.BookMyShow.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserLoginDTO userLoginDTO){
        return ResponseEntity.ok(userService.logIn(userLoginDTO.getEmail(),userLoginDTO.getPassword()));
    }

    @PostMapping("/signup")
    public  ResponseEntity signup(@RequestBody UserSignupDTO userSignupDTO){
        return ResponseEntity.ok(userService.signUp(userSignupDTO.getName(),userSignupDTO.getEmail(),userSignupDTO.getPassword()));
    }
}
