# Fuel Consumption Application

[![N|Solid](https://pbs.twimg.com/profile_images/378800000380749081/7f53d4b20bb6a566ce4d4dda33b2e598.png)](https://www.java.com/en/download/)

## General Info!

  - App is working on Port: 8080
  - Using Java 1.8
  - Using Gradle
  - Using SQLite database
  - Default URL:
    ```sh 
    http://localhost:8080
    ```
    
## Requests (GET)
```sh 
/getData
- Returns all data in database
```
```sh 
/getDataSpecifiedByMonth
- Returns all drivers who bought gas on specific month

PARAMETERS:
- driverId (optional)
- month (required)
NB: Month is two digit number (example: 01, 05, 10)
```
```sh 
/getTotalMoneyReceived
- Returns how much money received in each month

PARAMETERS:
- driverId (optional)
```
```sh 
/getDataBasedOnFuelType
- Returns how much money received from specific fuel type

PARAMETERS:
- driverId (optional)
- fuelType (required)
NB: fuelType can only be "95, 98, D"
```
```sh 
/insertDriver
- Inserts new driver to the database

PARAMETERS:
- driverId (required)
- fuelType (required)
- price (required)
- liters (required)
- date (required)
```

## Examples
```sh 
1. http://localhost:8080/getData
2. http://localhost:8080/getDataSpecifiedByMonth?month=02&driverId=15
3. http://localhost:8080/getTotalMoneyReceived?driverId=16
4. http://localhost:8080/getDataBasedOnFuelType?fuelType=95&driverId=2
5. http://localhost:8080/insertDriver?driverId=0&fuelType=95&price=1.39&liters=10.4&date=2020-04-17
```

## For Your Information
```sh 
IF 'driverId' EQUALS '-1' THEN RETURN ALL DRIVERS :)
```

