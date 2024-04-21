package dev.vaibhav.BookMyShow.Controller;

import dev.vaibhav.BookMyShow.DataTransferObject.CityRequestDTO;
import dev.vaibhav.BookMyShow.Exception.CityNotFoundException;
import dev.vaibhav.BookMyShow.Model.City;
import dev.vaibhav.BookMyShow.Service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CityController {
    @Autowired
    private CityService cityService;

    @GetMapping("/city/{name}")
    public ResponseEntity getCityByName(@PathVariable("name") String cityName){
        City city = cityService.getCityByName(cityName);
        return ResponseEntity.ok(city);
    }

    @GetMapping("/city/{id}")
    public ResponseEntity getCityById(@PathVariable("id") int cityId){
        City city = cityService.getCityById(cityId);
        return ResponseEntity.ok(city);
    }

    @PostMapping("/city")
    public ResponseEntity createCity(@RequestBody CityRequestDTO cityRequestDto){
            String cityName = cityRequestDto.getName();
            if(cityName.isBlank() || cityName.isEmpty() || cityName == null) {
                throw new CityNotFoundException("City Not found");
            }
            City savedCity = cityService.saveCity(cityName);
            return ResponseEntity.ok(savedCity);
    }

    @DeleteMapping("/city/{id}")
    public ResponseEntity deleteCity(@PathVariable("id") int cityId){
        boolean isDeleted = cityService.deleteCity(cityId);
        return ResponseEntity.ok(isDeleted);
    }
}
