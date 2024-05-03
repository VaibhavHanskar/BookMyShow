package dev.vaibhav.BookMyShow.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Actor")
public class Actor extends BaseClass{
    private String name;
    @ManyToMany
    private List<Movie> movies;
}
