package dev.vaibhav.BookMyShow.Service;

import dev.vaibhav.BookMyShow.Model.Auditorium;
import dev.vaibhav.BookMyShow.Model.Constants.AuditoriumFeatures;
import dev.vaibhav.BookMyShow.Model.Seat;
import dev.vaibhav.BookMyShow.Model.Show;
import dev.vaibhav.BookMyShow.Model.Theatre;
import dev.vaibhav.BookMyShow.Repository.AuditoriumRepository;
import dev.vaibhav.BookMyShow.Repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
// List<Seat> seats, List<Show> shows, List<AuditoriumFeatures> auditoriumFeatures,
//     auditorium.setSeats(seats);
//             auditorium.setShows(shows);
//             auditorium.setAuditoriumFeatures(auditoriumFeatures);
@Service
public class AuditoriumService {
    @Autowired
    private AuditoriumRepository auditoriumRepository;

    @Autowired
    private TheatreService theatreService;

    public Auditorium createAuditorium(String audiName, int audiCapacity, int theatreId){
        Auditorium savedAuditorium = new Auditorium();
        savedAuditorium.setName(audiName);
        savedAuditorium.setCapacity(audiCapacity);
        auditoriumRepository.save(savedAuditorium);

        Theatre theatre = theatreService.getTheatreById(theatreId);
        List<Auditorium> auditoriumList = theatre.getAuditoriums();
        auditoriumList.add(savedAuditorium);
        theatre.setAuditoriums(auditoriumList);
        theatreService.saveTheatre(theatre);
        return savedAuditorium;
    }
}
