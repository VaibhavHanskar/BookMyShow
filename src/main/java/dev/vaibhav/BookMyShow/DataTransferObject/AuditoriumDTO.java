package dev.vaibhav.BookMyShow.DataTransferObject;

import dev.vaibhav.BookMyShow.Model.Constants.AuditoriumFeatures;
import dev.vaibhav.BookMyShow.Model.Seat;
import dev.vaibhav.BookMyShow.Model.Show;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AuditoriumDTO {
    private String name;
    private int capacity;
    private int theatreId;
}

//    private List<Seat> seats;
//    private List<Show> shows;
//    private List<AuditoriumFeatures> auditoriumFeatures;