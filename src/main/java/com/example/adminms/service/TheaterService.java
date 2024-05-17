package com.example.adminms.service;

import com.example.adminms.entity.Theater;
import org.springframework.http.ResponseEntity;

public interface TheaterService {
    ResponseEntity fetchTheatersByLocation(Integer locationID);

    ResponseEntity addTheater(Theater theater);

    ResponseEntity updateTheater(Theater theater, Integer theaterID);

    ResponseEntity deleteTheater(Integer theaterID);

    ResponseEntity fetchTheaterById(Integer theaterID);
}
