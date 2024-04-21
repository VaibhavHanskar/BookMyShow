package dev.vaibhav.BookMyShow.Repository;

import dev.vaibhav.BookMyShow.Model.Theatre;
import dev.vaibhav.BookMyShow.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
