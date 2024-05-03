package dev.vaibhav.BookMyShow.Model;

import dev.vaibhav.BookMyShow.Model.Constants.SeatStatus;
import dev.vaibhav.BookMyShow.Model.Constants.SeatType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Seat")
public class Seat extends BaseClass{
    @Column(name = "SeatRow")
    private int row;
    @Column(name = "SeatCol")
    private int col;
    @Column(name = "SeatNumber")
    private String seatNumber;
    @Enumerated(EnumType.STRING)
    private SeatType seatType;
    @Enumerated(EnumType.STRING)
    private SeatStatus seatStatus;

    public Seat() {
    }

    public Seat(int row, int col, String seatNumber, SeatType seatType, SeatStatus seatStatus) {
        this.row = row;
        this.col = col;
        this.seatNumber = seatNumber;
        this.seatType = seatType;
        this.seatStatus = seatStatus;
    }
}
