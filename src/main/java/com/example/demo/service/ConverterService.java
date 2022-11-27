package com.example.demo.service;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ConverterService {
    public static String processCelciumToFarenheit(String temperature, HttpServletResponse response) {
        String result;
        Pattern p = Pattern.compile("(-)?\\d.\\d");
        Matcher matcher = p.matcher(temperature);
        if (!matcher.matches()) {
            result = "Invalid temperature format";
            response.setStatus(400);
        } else result = String.valueOf((1.8 * Double.parseDouble(temperature)) + 32);
        return result;
    }

}
