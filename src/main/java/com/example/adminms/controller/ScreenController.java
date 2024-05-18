package com.example.adminms.controller;

import com.example.adminms.entity.Screen;
import com.example.adminms.service.ScreenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin-mapper")
public class ScreenController {

    @Autowired
    private ScreenService screenService;

    @PostMapping("/addScreen")
    public ResponseEntity addScreen(@RequestBody Screen screen){
      return screenService.addScreen(screen);
    }

    @GetMapping("/fetch/screenByTheaterId/{theaterId}")
    public ResponseEntity getScreens(@PathVariable("theaterId") Integer theaterId){
        return  screenService.getScreensByTheaterId(theaterId);
    }

    @PostMapping("/updateScreen/{screenId}")
    public ResponseEntity updateScreen(@PathVariable("screenId") Integer screenId,
                                       @RequestBody Screen screen){
        return screenService.updateScreen(screenId,screen);
    }
}
