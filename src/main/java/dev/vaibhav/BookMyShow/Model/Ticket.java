package dev.vaibhav.BookMyShow.Model;

import dev.vaibhav.BookMyShow.Model.Constants.TicketStatus;
import jakarta.persistence.*;
import jakarta.websocket.server.ServerEndpoint;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Ticket")
public class Ticket extends BaseClass{
    private LocalDateTime bookingTime;
    private double amount;
    @ManyToOne
    private Show show;
    @OneToMany
    private List<ShowSeat> showSeats;
    @Enumerated(EnumType.STRING)
    private TicketStatus ticketStatus;

    public Ticket(LocalDateTime bookingTime, double amount, Show show, List<ShowSeat> showSeats, TicketStatus ticketStatus) {
        this.bookingTime = bookingTime;
        this.amount = amount;
        this.show = show;
        this.showSeats = showSeats;
        this.ticketStatus = ticketStatus;
    }
}
