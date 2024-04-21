package dev.vaibhav.BookMyShow.Service;

import dev.vaibhav.BookMyShow.Model.Seat;
import dev.vaibhav.BookMyShow.Model.ShowSeat;
import dev.vaibhav.BookMyShow.Repository.ShowSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShowSeatService {
    @Autowired
    private ShowSeatRepository showSeatRepository;
    public ShowSeat getShowSeat(int showSeatId){
        return showSeatRepository.findById(showSeatId).get();
    }

    public ShowSeat saveShowSeat(ShowSeat seat){
        return showSeatRepository.save(seat);
    }
}
