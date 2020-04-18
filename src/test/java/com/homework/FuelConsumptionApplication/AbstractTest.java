package com.homework.FuelConsumptionApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AbstractTest {

    JsonResponse jsonResponse = new JsonResponse();

    public void assertResponseBasedOnFuelType(int driverId, double expectedTotal, double expectedAverage, String fuelType, int month, IFuelService fuelService) {
        List<Fuel> response = jsonResponse.getDataBasedOnFuelType(driverId, fuelType, fuelService);

        assertEquals(12, response.size());
        assertEquals(expectedTotal, response.get(month).getTotalPrice());
        assertEquals(expectedAverage, response.get(month).getAveragePrice());
        if(driverId > -1) { IntStream.range(0, response.size() - 1).forEach(i -> assertEquals(fuelType, response.get(i).getFuelType())); }
    }

    public void assertResponseForSpecifiedMonth(int driverId, int expectedSize, String month, IFuelService fuelService) {
        List<Data> response = jsonResponse.getDataSpecifiedByMonth(driverId, month, fuelService);

        assertEquals(expectedSize, response.size());
        assertEquals(month, response.get(new Random().nextInt(response.size())).getDate().split("-")[1]);
        if(driverId > -1) { IntStream.range(0, response.size() - 1).forEach(i -> assertEquals(driverId, response.get(i).getDriverId())); }
    }

    public void assertResponseForMoneyReceived(int driverId, double expectedTotal, String monthName, int month, IFuelService fuelService) {
        List<Total> response = jsonResponse.getTotalMoneyReceived(driverId, fuelService);

        assertEquals(12, response.size());
        assertEquals(expectedTotal, response.get(month).getTotal());
        assertEquals(monthName, response.get(month).getMonth());
    }

    public List<Data> makeDriver() {
        List<Data> makeDriver = new ArrayList<>();

        makeDriver.add(new Data(1, "D", 0.5, 10.5, "2020-03-10", 0.5 * 10.5));
        makeDriver.add(new Data(1, "95", 0.5, 11.5, "2020-04-11", 0.5 * 11.5));
        makeDriver.add(new Data(1, "95", 1.5, 12.5, "2020-04-12", 1.5 * 12.5));
        makeDriver.add(new Data(2, "95", 1.5, 13.5, "2020-04-13", 1.5 * 13.5));
        makeDriver.add(new Data(2, "98", 0.5, 14.5, "2020-04-14", 0.5 * 14.5));

        return makeDriver;
    }
}
