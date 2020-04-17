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

    @RequestMapping("/resultSpecifiedMonth")
    public List<Data> getMonth(@RequestParam(value = "driverId", required = false, defaultValue = "-1") int driverId,
                               @RequestParam(value = "month") String month) {
        return JsonResponse.getDataSpecifiedByMonth(driverId, month, fuelService);
    }

    @RequestMapping("/resultMoney")
    public List<Total> getMonth(@RequestParam(value = "driverId", required = false, defaultValue = "-1") int driverId) {
        return JsonResponse.getTotalMoneyGotten(driverId, fuelService);
    }

    @RequestMapping("/resultFuel")
    public List<Fuel> resultFuel(
            @RequestParam(value = "driverId", required = false, defaultValue = "-1") int driverId,
            @RequestParam(value = "fuelType") String fuelType) {
        return JsonResponse.getDataBasedOnFuelType(driverId, fuelType, fuelService);
    }
}
