package dev.vaibhav.BookMyShow.Controller;

import dev.vaibhav.BookMyShow.DataTransferObject.AuditoriumDTO;
import dev.vaibhav.BookMyShow.DataTransferObject.TheatreRequestDTO;
import dev.vaibhav.BookMyShow.Model.Theatre;
import dev.vaibhav.BookMyShow.Service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TheatreController {
    @Autowired
    private TheatreService theatreService;

    @GetMapping("/theatre/{id}")
    public ResponseEntity getTheatre(@PathVariable("id") int theatreId){
        Theatre theatre  =theatreService.getTheatreById(theatreId);
        return ResponseEntity.ok(theatre);
    }

    @PostMapping("/theatre")
    public ResponseEntity createTheatre(@RequestBody TheatreRequestDTO theatreRequestDto){
        return ResponseEntity.ok
                    (theatreService.saveTheatre
                            (
                             theatreRequestDto.getName(),
                             theatreRequestDto.getAddress(),
                             theatreRequestDto.getCityId()
                            )
                    );
    }

}
