package com.example.adminms.controller;


import com.example.adminms.entity.Location;
import com.example.adminms.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin-mapper")
public class LocationController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/addLocation")
    public ResponseEntity addLocation(@RequestBody Location location){
          return adminService.addLocation(location);
    }

    @GetMapping("/fetch/all/locations")
    public ResponseEntity getAllLocations(){
        return adminService.getAllLocations();
    }

    @PostMapping("/update/location/{id}")
    public ResponseEntity updateLocation(@RequestBody Location location,@PathVariable("id") Integer locationID){
        return adminService.updateLocation(location,locationID);
    }

    @PostMapping("/delete/location/{id}")
    public ResponseEntity deleteLocation(@PathVariable("id") Integer locationID){
        return adminService.deleteLocation(locationID);
    }
}
