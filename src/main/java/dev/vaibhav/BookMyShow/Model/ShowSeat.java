package dev.vaibhav.BookMyShow.Model;

import dev.vaibhav.BookMyShow.Model.Constants.ShowSeatStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ShowSeat")
public class ShowSeat extends BaseClass{
    private double price;
    @ManyToOne
    private Show show;
    @ManyToOne
    private Seat seat;
    @Enumerated(EnumType.STRING)
    private ShowSeatStatus showSeatStatus;

    public ShowSeat() {
    }

    public ShowSeat(double price, Show show, Seat seat, ShowSeatStatus showSeatStatus) {
        this.price = price;
        this.show = show;
        this.seat = seat;
        this.showSeatStatus = showSeatStatus;
    }
}
