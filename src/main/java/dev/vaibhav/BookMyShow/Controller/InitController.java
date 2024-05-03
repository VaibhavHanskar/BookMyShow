package dev.vaibhav.BookMyShow.Controller;

import dev.vaibhav.BookMyShow.Service.InitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InitController {
    @Autowired
    private InitService initService;

    @GetMapping("/init")
    public ResponseEntity inti(){
        boolean initialise = initService.initialise();
        return ResponseEntity.ok(initialise);
    }
}
