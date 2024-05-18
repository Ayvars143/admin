package com.example.adminms.service;

import com.example.adminms.entity.Location;
import com.example.adminms.entity.Screen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ScreenServiceImpl implements ScreenService {

    @Autowired
    private RestTemplate restTemplate;
    @Override
    public ResponseEntity addScreen(Screen screen) {
        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Screen> entity=new HttpEntity<>(screen,headers);

        ResponseEntity<Screen> response=restTemplate.exchange("http://localhost:8085/screen-ms/screen-mapper/addScreen",
                HttpMethod.POST,entity,Screen.class);

        if(response.getStatusCode().value()==200){
            return response;
        }else{
            return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity getScreensByTheaterId(Integer theaterId) {
        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity entity=new HttpEntity<>(headers);

        ResponseEntity<String> response=restTemplate.exchange("http://localhost:8085/screen-ms/screen-mapper/theaterId/"+theaterId,
                HttpMethod.GET,entity,String.class);
        if(response.getStatusCode().value()==200){
            return response;
        }else{
            return new ResponseEntity(response, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity updateScreen(Integer screenId, Screen screen) {
        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity entity=new HttpEntity<>(screen,headers);

        ResponseEntity<String> response=restTemplate.exchange("http://localhost:8085/screen-ms/screen-mapper/updateScreen/"+screenId,
                HttpMethod.PUT,entity,String.class);
        if(response.getStatusCode().value()==200){
            return response;
        }else{
            return new ResponseEntity(response, HttpStatus.NOT_FOUND);
        }
    }
}
