package dev.vaibhav.BookMyShow.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "User")
public class User extends BaseClass{
    private String name;
    @Column(unique = true)
    private String email;
    private String password;
    @OneToMany
    private List<Ticket> tickets;

}
