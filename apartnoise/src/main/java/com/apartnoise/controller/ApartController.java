package com.apartnoise.controller;

import com.apartnoise.model.Apart;
import com.apartnoise.service.ApartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ApartController {

    private final ApartService apartService;

    @GetMapping(value = "/apart")
    public List<Apart> getApart(@RequestParam(required = false, defaultValue = "") String name ){
        return apartService.getApartService( name );
    }

    @PostMapping(value = "/apart")
    public String createApart(@RequestBody Apart apart){
        return apartService.createApartService(apart);
    }

    @DeleteMapping(value = "/apart/{id}")
    public String deleteApart(@PathVariable Long id) {
        return apartService.deleteApartService(id);
    }

}