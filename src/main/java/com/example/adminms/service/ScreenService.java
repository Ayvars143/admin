package com.example.adminms.service;

import com.example.adminms.entity.Screen;
import org.springframework.http.ResponseEntity;

public interface ScreenService {
    ResponseEntity addScreen(Screen screen);

    ResponseEntity getScreensByTheaterId(Integer theaterId);

    ResponseEntity updateScreen(Integer screenId, Screen screen);
}
