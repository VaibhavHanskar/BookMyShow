package dev.vaibhav.BookMyShow.Repository;

import dev.vaibhav.BookMyShow.Model.Movie;
import dev.vaibhav.BookMyShow.Model.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    public Movie findMovieByName(String movieName);
}
