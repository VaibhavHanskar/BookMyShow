package dev.vaibhav.BookMyShow.Service;

import dev.vaibhav.BookMyShow.Exception.ShowSeatNotAvailableException;
import dev.vaibhav.BookMyShow.Exception.UserNotFoundException;
import dev.vaibhav.BookMyShow.Model.*;
import dev.vaibhav.BookMyShow.Model.Constants.ShowSeatStatus;
import dev.vaibhav.BookMyShow.Model.Constants.TicketStatus;
import dev.vaibhav.BookMyShow.Repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private ShowSeatService showSeatService;
    public Ticket bookTicket(List<Integer> showSeatIds, int userId){
        checkAndLockSeats(showSeatIds);
        startPayment(showSeatIds);
        User user = userService.findUserById(userId);
        if(user == null){
            throw new UserNotFoundException("User not found");
        }
        List<ShowSeat> savedShowSeats = new ArrayList<>();
        for(int i=1;i<=showSeatIds.size();i++){
            ShowSeat s = new ShowSeat();
            savedShowSeats.add(s);
        }
        Ticket savedTicket = new Ticket(LocalDateTime.now(),showSeatService.getShowSeat(showSeatIds.get(0)).getPrice(),showSeatService.getShowSeat(showSeatIds.get(0)).getShow(),savedShowSeats, TicketStatus.BOOKED);
        List<Ticket> tickets = user.getTickets();
        if(tickets == null){
            tickets = new ArrayList<>();
        }
        tickets.add(savedTicket);
        user.setTickets(tickets);
        return ticketRepository.save(savedTicket);
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void checkAndLockSeats(List<Integer> showSeatIds){
        for(int showSeatId : showSeatIds){
            ShowSeat seat = showSeatService.getShowSeat(showSeatId);
            if(!seat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)){
                throw new ShowSeatNotAvailableException("Seat not available");
            }
        }

        for(int showSeatId : showSeatIds){
            ShowSeat seat = showSeatService.getShowSeat(showSeatId);
            seat.setShowSeatStatus(ShowSeatStatus.LOCKED);
            showSeatService.saveShowSeat(seat);
        }
    }

    public boolean startPayment(List<Integer> showSeatIds){
        return true;
    }
    public String greet(){
        return "Hello World";
    }
}
