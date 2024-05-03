package dev.vaibhav.BookMyShow.Service;

import dev.vaibhav.BookMyShow.Exception.InvalidPasswordException;
import dev.vaibhav.BookMyShow.Exception.UserAlreadyExistException;
import dev.vaibhav.BookMyShow.Exception.UserNotFoundException;
import dev.vaibhav.BookMyShow.Model.User;
import dev.vaibhav.BookMyShow.Repository.UserRepository;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User logIn(String email, String password){
        User savedUser = userRepository.findUserByEmail(email);
        if(savedUser == null){
            throw new UserNotFoundException("User does not exist");
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if(encoder.matches(password,savedUser.getPassword())){
            return savedUser;
        }
        throw new InvalidPasswordException("Invalid Password");
    }

    public User signUp(String name, String email, String password){
        User savedUser = userRepository.findUserByEmail(email);
        if(savedUser != null){
            throw new UserAlreadyExistException("Email already exist");
        }

        User user = new User();
        user.setEmail(email);
        user.setName(name);
        BCryptPasswordEncoder encoder  = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(password));
        user.setTickets(new ArrayList<>());
        return userRepository.save(user);
    }

    public User findUserById(int userId){
        return userRepository.findById(userId).get();
    }
}
