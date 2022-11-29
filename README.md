# DegreesConverter
Service, that converts Celcium degrees to Farenheit.
Input value is number in Celcium degrees measurement, output value is a converted temperature in Farenheit measurement system.

## Convert from Farenheit to Celcium and vice versa
### Input temperature is a single double value passed through query param "temperature"

    GET localhost:8080/farenheitToCelcium?temperature=8.6

    The result is -12.999999999999998 with 200 status code

From Celcium to Farenheit

     GET localhost:8080/celciumToFarenheit?temperature=15.34

     The result is 59.612 with 200 status code

In case of wrong format temperature the corresponding validation results in message about wrong value with status code 400

    GET localhost:8080/celciumToFarenheit?temperature=error

    The result is message "Invalid temperature format" with status code 400

## Convert several temperatures passed as array

    GET localhost:8080/farenheitToCelcium/array with body  ["1.0","-2.432"]

    The result is [-17.22222222222222, -19.12888888888889] with status code 200
 
## There are sort options "asc" and "desc" in order to accept sorted temperatures after conversion

    GET localhost:8080/celciumToFarenheit/array?sort=desc

    The result is [2.3000000000000007,1.3999999999999986] with status code 200

## There is postman collection in order to test api

    src/main/resources/postman/DegreeConverter.postman_collection.json

## Docker

    docker build -t java_converter .
    docker run --it -p 8080:8080 java_converter
