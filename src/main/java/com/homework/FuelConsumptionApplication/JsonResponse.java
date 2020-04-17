package com.homework.FuelConsumptionApplication;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JsonResponse {

    public static final String[] MONTHS = new String[]{"January", "February", "March",
            "April", "May", "June",
            "July,", "August", "September",
            "October", "November", "December"};

    public static List<Data> getDataSpecifiedByMonth(int driverId, String month, IFuelService fuelService) {
        List<Data> data = callAndCheckRequest(driverId, fuelService);

        return data.stream()
                .filter(d -> d.getDate().split("-")[1].equals(month))
                .map(d -> new Data(d.getDriverId(), d.getFuelType(), d.getPrice(), d.getLiters(), d.getDate(), d.getTotalPrice()))
                .collect(Collectors.toList());
    }

    public static List<Total> getTotalMoneyReceived(int driverId, IFuelService fuelService) {
        List<Data> data = callAndCheckRequest(driverId, fuelService);

        return IntStream.rangeClosed(1, 12)
                .mapToObj(i -> new Total(MONTHS[i - 1], getDataEqualToMonth(data, i).mapToDouble(Data::getTotalPrice).sum()))
                .collect(Collectors.toList());
    }

    public static List<Fuel> getDataBasedOnFuelType(int driverId, String fuelType, IFuelService fuelService) {

        List<Data> data = callAndCheckRequest(driverId, fuelService);

        return IntStream.rangeClosed(1, 12).mapToObj(i -> new Fuel(MONTHS[i - 1], fuelType,
                getDataEqualToMonth(data, i).mapToDouble(Data::getLiters).sum(),
                getDataEqualToMonth(data, i).mapToDouble(Data::getTotalPrice).sum() / getDataEqualToMonth(data, i).count(),
                getDataEqualToMonth(data, i).mapToDouble(Data::getTotalPrice).sum())).collect(Collectors.toList());

    }

    private static Stream<Data> getDataEqualToMonth(List<Data> data, int i) {
        return data.stream().filter(d -> d.getDate().split("-")[1].equals(i <= 9 ? "0" + (i) : Integer.toString(i)));
    }

    private static List<Data> callAndCheckRequest(int driverId, IFuelService fuelService)
    {
        return driverId != -1 ? fuelService.findDriverById(driverId) : fuelService.findAll();
    }
}
