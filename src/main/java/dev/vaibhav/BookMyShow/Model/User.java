package dev.vaibhav.BookMyShow.Model;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class User extends BaseClass{
    private String name;
    @Column(unique = true)
    private String email;
    private String password;
    @OneToMany
    private List<Ticket> tickets;

}
