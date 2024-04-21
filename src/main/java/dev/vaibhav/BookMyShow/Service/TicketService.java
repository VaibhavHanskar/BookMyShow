package dev.vaibhav.BookMyShow.Service;

import dev.vaibhav.BookMyShow.Exception.ShowSeatNotAvailableException;
import dev.vaibhav.BookMyShow.Model.Constants.ShowSeatStatus;
import dev.vaibhav.BookMyShow.Model.Seat;
import dev.vaibhav.BookMyShow.Model.ShowSeat;
import dev.vaibhav.BookMyShow.Model.Ticket;
import dev.vaibhav.BookMyShow.Repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    private ShowSeatService showSeatService;

    public Ticket bookTicket(List<Integer> showSeatIds, int userId){
        checkAndLockSeats(showSeatIds);
        startPayment(showSeatIds);
        return new Ticket();
    }

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
