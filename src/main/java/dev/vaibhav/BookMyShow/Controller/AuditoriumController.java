package dev.vaibhav.BookMyShow.Controller;

import dev.vaibhav.BookMyShow.DataTransferObject.AuditoriumDTO;
import dev.vaibhav.BookMyShow.Model.Auditorium;
import dev.vaibhav.BookMyShow.Service.AuditoriumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuditoriumController {

    @Autowired
    private AuditoriumService auditoriumService;

    @PostMapping("/auditorium")
    public ResponseEntity createAuditorium(@RequestBody AuditoriumDTO auditoriumDTO){
        return ResponseEntity.ok(
                    auditoriumService.createAuditorium(
                            auditoriumDTO.getName(),
                            auditoriumDTO.getCapacity(),
                            auditoriumDTO.getTheatreId()
                    )
            );
    }

    @GetMapping("/auditorium/{id}")
    public ResponseEntity getAuditorium(@PathVariable("id") int audiId){
        Auditorium auditorium = auditoriumService.getAuditorium(audiId);
        return ResponseEntity.ok(auditorium);
    }
}
