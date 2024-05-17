package com.example.adminms.controller;

import com.example.adminms.entity.Theater;
import com.example.adminms.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin-mapper")
public class ThreaterController {

    @Autowired
    private TheaterService theaterService;

    @GetMapping("/fetch/theaterByLocation/{locationID}")
    public ResponseEntity fetchTheaterByLocation(@PathVariable("locationID") Integer locationID){
        return theaterService.fetchTheatersByLocation(locationID);
    }

    @PostMapping("/addTheater")
    public ResponseEntity addTheater(@RequestBody Theater theater){
        return theaterService.addTheater(theater);
    }

    @PostMapping("/update/theater/{theaterID}")
    public ResponseEntity updateTheater(@RequestBody Theater theater, @PathVariable("theaterID") Integer theaterID){
        return theaterService.updateTheater(theater,theaterID);
    }

    @PostMapping("/delete/theater/{theaterID}")
    public ResponseEntity deleteTheater(@PathVariable("theaterID") Integer theaterID){
        return theaterService.deleteTheater(theaterID);
    }

    @GetMapping("/fetch/theaterById/{theaterID}")
    public ResponseEntity fetchTheaterById(@PathVariable("theaterID") Integer theaterID){
        return theaterService.fetchTheaterById(theaterID);
    }
}
