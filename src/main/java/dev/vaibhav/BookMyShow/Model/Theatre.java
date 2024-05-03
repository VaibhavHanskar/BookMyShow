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
@Table(name = "Thatre")
public class Theatre extends BaseClass{
    private String name;
    private String address;
    @OneToMany
    private List<Auditorium> auditoriums;

    public Theatre() {
    }

    public Theatre(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
