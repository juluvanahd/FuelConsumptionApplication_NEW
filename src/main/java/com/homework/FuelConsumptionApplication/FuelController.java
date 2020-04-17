package com.homework.FuelConsumptionApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FuelController {

    @Autowired
    private IFuelService fuelService;

    @RequestMapping("getData")
    public List<Data> getData() {
        return fuelService.findAll();
    }

    @RequestMapping("/resultSpecifiedMonth")
    public List<Data> getDataSpecifiedByMonth(@RequestParam(value = "driverId", required = false, defaultValue = "-1") int driverId,
                               @RequestParam(value = "month") String month) {
        return JsonResponse.getDataSpecifiedByMonth(driverId, month, fuelService);
    }

    @RequestMapping("/resultMoney")
    public List<Total> getTotalMoneyGotten(@RequestParam(value = "driverId", required = false, defaultValue = "-1") int driverId) {
        return JsonResponse.getTotalMoneyGotten(driverId, fuelService);
    }

    @RequestMapping("/resultFuel")
    public List<Fuel> getDataBasedOnFuelType(
            @RequestParam(value = "driverId", required = false, defaultValue = "-1") int driverId,
            @RequestParam(value = "fuelType") String fuelType) {
        return JsonResponse.getDataBasedOnFuelType(driverId, fuelType, fuelService);
    }

    @RequestMapping("/insertDriver")
    public Data insertNewDriver(
            @RequestParam(value = "driverId") int driverId,
            @RequestParam(value = "fuelType") String fuelType,
            @RequestParam(value = "price") double price,
            @RequestParam(value = "liters") double liters,
            @RequestParam(value = "date") String date) {
        return fuelService.insertNewDriver(driverId, fuelType, price, liters, date);
    }
}
