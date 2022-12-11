package com.example.demo;

import com.example.demo.service.ConverterService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void validateInputTemperatureNegativeTest() {
		String validation = ConverterService.validateInputTemperature("error");
        Assertions.assertEquals("Invalid temperature format", validation);
	}

	@Test
	void validateInputTemperaturePositiveTest() {
		String validation = ConverterService.validateInputTemperature("6.7");
		Assertions.assertNull(validation);
	}

	@Test
	void convertCelciumToFarenheitTest() {
		String temperature = ConverterService.convertToFarenheit("6.7");
		Assertions.assertEquals("44.06", temperature);
	}

	@Test
	void convertCelciumToCelciumTest() {
		String temperature = ConverterService.convertToCelcium("44.06");
		Assertions.assertEquals("6.700000000000001", temperature);
	}

}
