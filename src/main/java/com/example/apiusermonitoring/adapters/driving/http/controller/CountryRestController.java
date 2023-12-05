package com.example.apiusermonitoring.adapters.driving.http.controller;

import com.example.apiusermonitoring.adapters.driving.http.dto.response.CountryResponseDto;
import com.example.apiusermonitoring.adapters.driving.http.handler.ICountryHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api-test")
@RequiredArgsConstructor
public class CountryRestController {

    private final ICountryHandler countryHandler;

    @GetMapping("/countries")
    public ResponseEntity<List<CountryResponseDto>> getCountries(@RequestParam(defaultValue = "1") Integer page,
                                                             @RequestParam(defaultValue = "10") Integer size){
        return ResponseEntity.ok(countryHandler.getCountries(page, size));
    }

}
