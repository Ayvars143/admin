package com.example.adminms.service;

import com.example.adminms.entity.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService{

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ResponseEntity<List<Location>> getAllLocations() {
        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity entity=new HttpEntity(headers);

        ResponseEntity<List> response=restTemplate.exchange("http://localhost:8081/location-ms/location-mapper/fetch/all/locations",HttpMethod.GET,entity, List.class);
        List<Location> responseList = response.getBody();
        return new ResponseEntity<>(responseList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity addLocation(Location location) {
        HttpHeaders headrs= new HttpHeaders();
        headrs.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Location> entity=new HttpEntity<Location>(location,headrs);

        //System.out.println("start porcess==========================");
        ResponseEntity<Location> response=restTemplate.exchange("http://localhost:8081/location-ms/location-mapper/addlocations", HttpMethod.POST,entity,Location.class);
        //System.out.println(response);
        if(response != null && response.getStatusCode().value()==200) {
            return ResponseEntity.ok(response.getBody().getName() + " Location is added successfully..!");
        }else{
            return ResponseEntity.ok(location.getName()+ " Location is already exist..!");
        }
    }

    @Override
    public ResponseEntity updateLocation(Location location, Integer locationID) {
        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Location> entity=new HttpEntity<>(location,headers);

        ResponseEntity<Location> response=restTemplate.exchange("http://localhost:8081/location-ms/location-mapper/updatelocations/"+locationID,HttpMethod.PUT,entity,Location.class);

        if(response != null && response.getStatusCode().value()==200){
            return ResponseEntity.ok("Location updated to: "+response.getBody().getName());
        }else{
            return ResponseEntity.ok("Not able to update the location for the given ID: "+locationID);
        }
    }

    @Override
    public ResponseEntity deleteLocation(Integer locationID) {
        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity entity=new HttpEntity(headers);

        ResponseEntity<String> response=restTemplate.exchange("http://localhost:8081/location-ms/location-mapper/deletelocations/"+locationID,HttpMethod.DELETE,entity,String.class);

        if(response.getStatusCode().value()==200){
            return ResponseEntity.ok("Location deleted successfully..!");
        }else{
            return ResponseEntity.ok("Location not deleted..!");
        }
    }
}
