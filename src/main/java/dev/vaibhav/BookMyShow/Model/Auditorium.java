package dev.vaibhav.BookMyShow.Model;

import dev.vaibhav.BookMyShow.Model.Constants.AuditoriumFeatures;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Auditorium")
public class Auditorium extends BaseClass{
    private String name;
    private int capacity;
    @OneToMany
    private List<Seat> seats;
    @OneToMany
    private List<Show> shows;
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<AuditoriumFeatures> auditoriumFeatures;
}
