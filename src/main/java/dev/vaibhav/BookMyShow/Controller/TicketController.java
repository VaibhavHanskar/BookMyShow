package dev.vaibhav.BookMyShow.Controller;

import dev.vaibhav.BookMyShow.DataTransferObject.BookTicketRequestDTO;
import dev.vaibhav.BookMyShow.Exception.TicketNotBookedException;
import dev.vaibhav.BookMyShow.Model.Ticket;
import dev.vaibhav.BookMyShow.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @PostMapping("/ticket")
    public ResponseEntity bookTicket(@RequestBody BookTicketRequestDTO ticketRequestDto){
        List<Integer> showSeatIds  = ticketRequestDto.getShowSeatIds();
        int userId = ticketRequestDto.getUserId();
        if(userId == 0 || showSeatIds.size() == 0 || showSeatIds == null){
            throw new TicketNotBookedException("Ticket not booked");
        }
        Ticket ticket = ticketService.bookTicket(showSeatIds,userId);
        return ResponseEntity.ok(ticket);
    }

    @GetMapping("/hello")
    public ResponseEntity greet(){
        String greet = ticketService.greet();
        return ResponseEntity.ok(greet);
    }
}
