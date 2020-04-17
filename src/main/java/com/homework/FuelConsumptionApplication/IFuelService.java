package com.homework.FuelConsumptionApplication;

import java.util.List;

public interface IFuelService {

    List<Data> findAll();
    List<Data> findDriverById(int driverId);
    Data insertNewDriver(int driverID, String fuelType, double price, double liters, String date);
}
