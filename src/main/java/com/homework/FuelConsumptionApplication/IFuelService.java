package com.homework.FuelConsumptionApplication;

import java.util.List;

public interface IFuelService {

    List<Data> findAll();
    List<Data> findDriverById(int driverId);
}
