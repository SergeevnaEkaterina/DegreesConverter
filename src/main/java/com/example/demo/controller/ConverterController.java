package com.example.demo.controller;

import com.example.demo.service.ConverterService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ConverterController {


    @GetMapping("/celciumToFarenheit")
    public String convertCelciumToFarenheitTempetarure(@RequestParam("temperature") String temperature, HttpServletResponse response) {
        return ConverterService.processCelciumToFarenheit(temperature, response);
    }

    @GetMapping("/farenheitToCelcium")
    public String convertFarenheitToCelciumTempetarure(@RequestParam("temperature") String temperature, HttpServletResponse response) {
        return ConverterService.processFarenheitToCelcium(temperature, response);
    }

    @GetMapping("/farenheitToCelcium/array")
    public List<Double> convertFarenheitToCelciumTempetarureArray(@RequestParam(value = "sort", required = false) String sort, @RequestBody List<String> temperatures, HttpServletResponse response) {
        return ConverterService.processFarenheitToCelciumArray(sort, temperatures, response);
    }

    @GetMapping("/celciumToFarenheit/array")
    public List<Double> convertCelciumToFarenheitTempetarureArray(@RequestParam(value = "sort", required = false) String sort, @RequestBody List<String> temperatures, HttpServletResponse response) {
        return ConverterService.processCelciumToFarenheitArray(sort, temperatures, response);
    }


}
