package com.example.adminms.service;

import com.example.adminms.entity.Location;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AdminService {
    ResponseEntity<List<Location>> getAllLocations();

    ResponseEntity addLocation(Location location);

    ResponseEntity updateLocation(Location location, Integer locationID);

    ResponseEntity deleteLocation(Integer locationID);
}
