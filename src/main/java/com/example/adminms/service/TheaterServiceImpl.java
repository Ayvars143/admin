package com.example.adminms.service;

import com.example.adminms.entity.Theater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TheaterServiceImpl implements TheaterService{

    @Autowired
    private RestTemplate restTemplate;
    @Override
    public ResponseEntity fetchTheatersByLocation(Integer locationID) {
        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity entity=new HttpEntity(headers);

        ResponseEntity<String> response=restTemplate.exchange("http://localhost:8082/theater-ms/theater-mapper/get/theatersByLocation/"+locationID,
                HttpMethod.GET,entity,String.class);

        if(response.getStatusCode().value()==200){
            return response;
        }else{
            return ResponseEntity.ok("No theaters found for the Location..!");
        }
    }

    @Override
    public ResponseEntity addTheater(Theater theater) {
        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Theater> entity=new HttpEntity<>(theater, headers);

        //System.out.println("request Starts ========================");
        ResponseEntity<String> response=restTemplate.exchange("http://localhost:8082/theater-ms/theater-mapper/addtheater",
                HttpMethod.POST,entity,String.class);

        if(response.getStatusCode().value()==200){
            return response;
        }else{
            return ResponseEntity.ok("No theaters found for the Location..!");
        }
    }

    @Override
    public ResponseEntity updateTheater(Theater theater, Integer theaterID) {
        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Theater> entity=new HttpEntity<>(theater,headers);

        ResponseEntity<String> response=restTemplate.exchange("http://localhost:8082/theater-ms/theater-mapper/updatetheater/"+theaterID,
                HttpMethod.PUT,entity,String.class);
        if(response.getStatusCode().value()==200){
            return response;
        }else{
            return ResponseEntity.ok("Exception while updating theater..!");
        }
    }

    @Override
    public ResponseEntity deleteTheater(Integer theaterID) {
        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity entity=new HttpEntity(headers);

        ResponseEntity<String> response=restTemplate.exchange("http://localhost:8082/theater-ms/theater-mapper/deletetheater/"+theaterID,
                HttpMethod.DELETE,entity,String.class);
        if(response.getStatusCode().value()==200){
            return response;
        }else{
            return ResponseEntity.ok("Exception while deleting theater..!");
        }
    }

    @Override
    public ResponseEntity fetchTheaterById(Integer theaterID) {
        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity entity=new HttpEntity(headers);

        ResponseEntity<String> response=restTemplate.exchange("http://localhost:8082/theater-ms/theater-mapper/theater/"+theaterID,
                HttpMethod.GET,entity,String.class);
        if(response.getStatusCode().value()==200){
            return response;
        }else{
            return ResponseEntity.ok("Exception while fetching theater..!");
        }
    }
}
