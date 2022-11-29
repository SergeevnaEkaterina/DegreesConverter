package com.example.demo.service;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ConverterService {
    public static String processCelciumToFarenheit(String temperature, HttpServletResponse response) {
        String result;
        String validation = validateInputTemperature(temperature);
        if (validation == null) {
            result = convertToFarenheit(temperature);
        } else {
            response.setStatus(400);
            result = validation;
        }
        return result;
    }

    public static String processFarenheitToCelcium(String temperature, HttpServletResponse response) {
        String result;
        String validation = validateInputTemperature(temperature);
        if (validation == null) {
            result = convertToCelcium(temperature);
        } else {
            response.setStatus(400);
            result = validation;
        }
        return result;
    }

    public static List<Double> processFarenheitToCelciumArray(String sort, List<String> temperatureArray, HttpServletResponse response) {
        List<String> convertedArray = new ArrayList<>();
        String validation = validateInputArrayTemperature(temperatureArray);
        if (validation == null) {
            temperatureArray.forEach(t -> convertedArray.add(convertToCelcium(t)));
        } else {
            response.setStatus(400);
            convertedArray.add(validation);
        }
        return sort(sort, convertedArray);
    }

    public static List<Double> processCelciumToFarenheitArray(String sort, List<String> temperatureArray, HttpServletResponse response) {
        List<String> convertedArray = new ArrayList<>();
        String validation = validateInputArrayTemperature(temperatureArray);
        if (validation == null) {
            temperatureArray.forEach(t -> convertedArray.add(convertToFarenheit(t)));
        } else {
            response.setStatus(400);
            convertedArray.add(validation);
        }
        return sort(sort, convertedArray);
    }


    public static String convertToFarenheit(String temperature) {
        return String.valueOf((1.8 * Double.parseDouble(temperature)) + 32);
    }

    public static String convertToCelcium(String temperature) {
        return String.valueOf((Double.parseDouble(temperature) - 32) / 1.8);
    }

    public static String validateInputTemperature(String temperature) {
        String result = null;
        Pattern p = Pattern.compile("(-)?\\d+.\\d+");
        Matcher matcher = p.matcher(temperature);
        if (!matcher.matches()) {
            result = "Invalid temperature format";
        }
        return result;
    }

    public static String validateInputArrayTemperature(List<String> temperatureArray) {
        String result = null;
        Pattern p = Pattern.compile("(-)?\\d+.\\d+");
        for (String elem : temperatureArray) {
            Matcher matcher = p.matcher(elem);
            if (!matcher.matches()) {
                result = "Invalid temperature format";
            }
        }
        return result;
    }

    public static List<Double> sort(String direction, List<String> array) {
        List<Double> castListElementsToDouble = new ArrayList<>(array.stream()
                .map(Double::parseDouble).toList());
        if (direction != null && !direction.isEmpty()) {
            if (Objects.equals(direction.toLowerCase(), "desc")) {
                castListElementsToDouble.sort(Collections.reverseOrder());
            } else if (Objects.equals(direction.toLowerCase(), "asc")) {
                Collections.sort(castListElementsToDouble);
            }
        }
        return castListElementsToDouble;
    }

}
