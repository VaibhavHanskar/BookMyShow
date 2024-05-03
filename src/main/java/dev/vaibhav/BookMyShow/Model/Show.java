package dev.vaibhav.BookMyShow.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "TheatreShow")
public class Show extends BaseClass{
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    @ManyToOne
    private Auditorium auditorium;
    @ManyToOne
    private Movie movie;
    @OneToMany
    private List<ShowSeat> showSeat;
}
