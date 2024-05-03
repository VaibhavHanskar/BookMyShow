package dev.vaibhav.BookMyShow.Service;

import dev.vaibhav.BookMyShow.Model.*;
import dev.vaibhav.BookMyShow.Model.Constants.AuditoriumFeatures;
import dev.vaibhav.BookMyShow.Model.Constants.SeatStatus;
import dev.vaibhav.BookMyShow.Model.Constants.SeatType;
import dev.vaibhav.BookMyShow.Model.Constants.ShowSeatStatus;
import dev.vaibhav.BookMyShow.Repository.*;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class InitService {
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private TheatreRepository theatreRepository;
    @Autowired
    private AuditoriumRepository auditoriumRepository;
    @Autowired
    private SeatRepository seatRepository;
    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private ShowSeatRepository showSeatRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private UserRepository userRepository;

    public boolean initialise(){
        City pune = new City("Pune");
        City mumbai = new City("Mumbai");
        City nagpur = new City("Nagpur");
        City delhi = new City("Delhi");

        cityRepository.save(pune);
        cityRepository.save(mumbai);
        cityRepository.save(nagpur);
        cityRepository.save(delhi);

        City savedPune = cityRepository.findCityByName("Pune");

        Theatre anandTheatre = new Theatre("AnandTheatre","Camp,Pune");
        Theatre venkateshScreens = new Theatre("VenkateshScreeens","Kotrud,Pune");

        theatreRepository.save(anandTheatre);
        theatreRepository.save(venkateshScreens);

        Theatre savedAnand = theatreRepository.findTheatreByName("AnandTheatre");
        Theatre savedVenky = theatreRepository.findTheatreByName("VenkateshScreeens");

        List<Theatre> theatreList = new ArrayList<>();
        theatreList.add(savedAnand);
        theatreList.add(savedVenky);
        savedPune.setTheatres(theatreList);
        cityRepository.save(savedPune);

        for(int i=1;i<=5;i++){
            Seat seat = new Seat();
            seat.setRow(i);
            seat.setCol(i);
            seat.setSeatNumber(i+" " + i);
            seat.setSeatType(SeatType.GOLD);
            seat.setSeatStatus(SeatStatus.AVAILABLE);
            seatRepository.save(seat);
        }

        List<Seat> savedSeats = seatRepository.findAll();

        Auditorium audi01 = new Auditorium();
        audi01.setName("Audi01");
        audi01.setCapacity(5);
        audi01.setSeats(savedSeats);
        audi01.setAuditoriumFeatures(new ArrayList<>(Arrays.asList(AuditoriumFeatures.DOLBY,AuditoriumFeatures.IMAX)));
        auditoriumRepository.save(audi01);

//        Auditorium audi02 = new Auditorium();
//        audi02.setName("Audi02");
//        audi02.setCapacity(5);
//        audi02.setSeats(savedSeats);
//        audi02.setAuditoriumFeatures(new ArrayList<>(Arrays.asList(AuditoriumFeatures.THREE_D,AuditoriumFeatures.DOLBY)));
//        auditoriumRepository.save(audi02);

        Auditorium savedAudi01 = auditoriumRepository.findAuditoriumByName("Audi01");
//        Auditorium savedAudi02 = auditoriumRepository.findAuditoriumByName("Audi02");

        Theatre savedTheatre = theatreRepository.findTheatreByName("AnandTheatre");
        List<Auditorium> auditoriumList = new ArrayList<>();
        auditoriumList.add(savedAudi01);
//        auditoriumList.add(savedAudi02);
        savedTheatre.setAuditoriums(auditoriumList);
        theatreRepository.save(savedTheatre);

        Movie ironMan = new Movie("IronMan","I am IronMan");
        movieRepository.save(ironMan);

        Show show01 = new Show();
        show01.setAuditorium(auditoriumRepository.findAuditoriumByName("Audi01"));
        show01.setStartTime(LocalDateTime.now());
        show01.setEndTime(LocalDateTime.now().plusMinutes(180));
        show01.setMovie(movieRepository.findMovieByName("IronMan"));
        showRepository.save(show01);

//        Movie spiderMan = new Movie("SpiderMan" , "Spider Man Homecoming");
//        movieRepository.save(spiderMan);

//        Show show02 = new Show();
//        show02.setAuditorium(auditoriumRepository.findAuditoriumByName("Audi02"));
//        show02.setStartTime(LocalDateTime.now());
//        show02.setEndTime(LocalDateTime.now().plusMinutes(160));
//        show02.setMovie(movieRepository.findMovieByName("SpiderMan"));
//        showRepository.save(show02);

        for(int i=1;i<=5;i++){
            ShowSeat s = new ShowSeat(1200,showRepository.findById(1).get(),seatRepository.findSeatBySeatNumber(i+" "+i), ShowSeatStatus.AVAILABLE);
            showSeatRepository.save(s);
        }

//        for(int i=1;i<=5;i++){
//            ShowSeat s = new ShowSeat(1100,showRepository.findById(2).get(),seatRepository.findSeatBySeatNumber(i+" "+i), ShowSeatStatus.AVAILABLE);
//            showSeatRepository.save(s);
//        }


        return true;
    }
}
