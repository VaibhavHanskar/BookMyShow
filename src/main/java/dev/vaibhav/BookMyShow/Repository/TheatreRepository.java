package dev.vaibhav.BookMyShow.Repository;

import dev.vaibhav.BookMyShow.Model.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Integer> {
    Theatre findTheatreByName(String theatreName);
}
