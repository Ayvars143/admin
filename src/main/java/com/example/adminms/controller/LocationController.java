package com.example.adminms.controller;


import com.example.adminms.entity.Location;
import com.example.adminms.service.LocationService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin-mapper")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @PostMapping("/addLocation")
    public ResponseEntity addLocation(@RequestBody Location location){
          return locationService.addLocation(location);
    }

    @GetMapping("/fetch/all/locations")
    public ResponseEntity<List<Location>> getAllLocations(){
        return locationService.getAllLocations();
    }

    @PostMapping("/update/location/{id}")
    public ResponseEntity updateLocation(@RequestBody Location location,@PathVariable("id") Integer locationID){
        return locationService.updateLocation(location,locationID);
    }

    @PostMapping("/delete/location/{id}")
    public ResponseEntity deleteLocation(@PathVariable("id") Integer locationID){
        return locationService.deleteLocation(locationID);
    }
}
