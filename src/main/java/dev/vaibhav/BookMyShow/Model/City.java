package dev.vaibhav.BookMyShow.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "City")
public class City extends BaseClass{
    private String name;
    @OneToMany
    private List<Theatre> theatres;

    public City() {
    }

    public City(String name) {
        this.name = name;
    }
}
