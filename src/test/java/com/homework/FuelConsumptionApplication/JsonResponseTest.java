package com.homework.FuelConsumptionApplication;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class JsonResponseTest extends AbstractTest {

    public static final int RANDOM_NUM = new Random().nextInt(12);

    @Mock
    private IFuelService fuelService;

    JsonResponse jsonResponse = new JsonResponse();

    @Test
    void getDataSpecifiedByMonthAllDriversTest() {
        when(fuelService.findAll()).thenReturn(makeDriver());
        assertResponseForSpecifiedMonth(-1, 4, "04", fuelService);
    }

    @Test
    void getDataSpecifiedByMonthSpecificDriverTest() {
        int driverId = 1;

        when(fuelService.findDriverById(driverId)).thenReturn(makeDriver().stream()
                .filter(d -> d.getDriverId() == driverId).collect(Collectors.toList()));

        assertResponseForSpecifiedMonth(driverId, 2, "04", fuelService);
    }

    @Test
    void getTotalMoneyReceivedAllDriversTest() {
        when(fuelService.findAll()).thenReturn(makeDriver());
        assertResponseForMoneyReceived(-1, 52.0, "April", 3, fuelService); // month starts from 0 not from 1
    }

    @Test
    void getTotalMoneyReceivedSpecificDriverTest() {
        int driverId = 1;

        when(fuelService.findDriverById(driverId)).thenReturn(makeDriver().stream()
                .filter(d -> d.getDriverId() == driverId).collect(Collectors.toList()));

        assertResponseForMoneyReceived(driverId, 24.5, "April", 3, fuelService); // month starts from 0 not from 1
    }

    @Test
    void getDataBasedOnFuelTypeAllDriversTest() {
        double expectedTotal = 44.75;

        when(fuelService.findAll()).thenReturn(makeDriver());

        assertResponseBasedOnFuelType(-1, expectedTotal, expectedTotal / 3, "95", 3, fuelService); // month starts from 0 not from 1
    }

    @Test
    void getDataBasedOnFuelTypeSpecificDriverTest() {
        int driverId = 1;
        double expectedTotal = 24.5;

        when(fuelService.findDriverById(driverId)).thenReturn(makeDriver().stream()
                .filter(d -> d.getDriverId() == driverId).collect(Collectors.toList()));

        assertResponseBasedOnFuelType(driverId, expectedTotal, expectedTotal / 2, "95", 3, fuelService); // month starts from 0 not from 1
    }

    @Test
    void responseNoDataTest() {
        when(fuelService.findAll()).thenReturn(new ArrayList<>());

        List<Data> responseGetDataSpecifiedByMonth = jsonResponse.getDataSpecifiedByMonth(-1, "04", fuelService);
        List<Total> responseGetTotalMoneyReceived = jsonResponse.getTotalMoneyReceived(-1, fuelService);
        List<Fuel> responseGetDataBasedOnFuelType = jsonResponse.getDataBasedOnFuelType(-1, "95", fuelService);

        assertEquals(new ArrayList<Data>(), responseGetDataSpecifiedByMonth);
        assertEquals(0.0, responseGetTotalMoneyReceived.get(RANDOM_NUM).getTotal()); // if no data then total money received should be 0.0 regardless of month
        assertEquals(0.0, responseGetDataBasedOnFuelType.get(RANDOM_NUM).getTotalPrice()); // if no data then total price should be 0.0 regardless of month
    }

    @Test
    void getDataTest() {
        when(fuelService.findAll()).thenReturn(makeDriver());

        List<Data> data = jsonResponse.getData(fuelService);

        assertEquals(5, data.size());
        assertEquals("2020-04-12", data.get(2).getDate());
    }

    @Test
    void insertNewDriverTest() {
        int driverId = 0;
        String fuelType = "95";
        double price = 0.5;
        double liters = 10.5;
        String date = "2020-04-19";
        double totalPrice = price * liters;

        when(fuelService.insertNewDriver(driverId, fuelType, price, liters, date))
                .thenReturn(new Data(driverId, fuelType, price, liters, date, totalPrice));

        Data data = jsonResponse.insertNewDriver(driverId, fuelType, price, liters, date, fuelService);

        assertEquals(0, data.getDriverId());
        assertEquals(5.25, data.getTotalPrice());
    }
}

