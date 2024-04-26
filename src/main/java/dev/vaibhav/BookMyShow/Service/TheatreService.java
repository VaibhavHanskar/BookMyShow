package dev.vaibhav.BookMyShow.Service;

import dev.vaibhav.BookMyShow.Model.City;
import dev.vaibhav.BookMyShow.Model.Theatre;
import dev.vaibhav.BookMyShow.Repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheatreService {
    @Autowired
    private TheatreRepository theatreRepository;

    @Autowired
    private CityService cityService;
    public Theatre saveTheatre(String name, String address, int cityId){
        Theatre savedTheatre = new Theatre();
        savedTheatre.setName(name);
        savedTheatre.setAddress(address);
        theatreRepository.save(savedTheatre);

        City city = cityService.getCityById(cityId);
        List<Theatre> theatres = city.getTheatres();
        theatres.add(savedTheatre);
        city.setTheatres(theatres);
        cityService.saveCity(city);
        return savedTheatre;
    }

    public Theatre saveTheatre(Theatre theatre){
        return theatreRepository.save(theatre);
    }
    public Theatre getTheatreById(int theatreId){
        return theatreRepository.findTheatreById(theatreId);
    }
}
