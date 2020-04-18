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

    public List<Data> getDataSpecifiedByMonth(int driverId, String month, IFuelService fuelService) {
        List<Data> data = callAndCheckRequest(driverId, fuelService);

        return data.stream()
                .filter(d -> d.getDate().split("-")[1].equals(month))
                .map(d -> new Data(d.getDriverId(), d.getFuelType(), d.getPrice(), d.getLiters(), d.getDate(), d.getTotalPrice()))
                .collect(Collectors.toList());
    }

    public List<Total> getTotalMoneyReceived(int driverId, IFuelService fuelService) {
        List<Data> data = callAndCheckRequest(driverId, fuelService);

        return IntStream.rangeClosed(1, 12)
                .mapToObj(i -> new Total(MONTHS[i - 1], getDataEqualToMonth(data, i).mapToDouble(Data::getTotalPrice).sum()))
                .collect(Collectors.toList());
    }

    public List<Fuel> getDataBasedOnFuelType(int driverId, String fuelType, IFuelService fuelService) {

        List<Data> data = callAndCheckRequest(driverId, fuelService);

        return IntStream.rangeClosed(1, 12).mapToObj(i -> new Fuel(MONTHS[i - 1], fuelType,
                getDataEqualToMonthAndFuelType(data, i, fuelType).mapToDouble(Data::getLiters).sum(),
                getDataEqualToMonthAndFuelType(data, i, fuelType).mapToDouble(Data::getTotalPrice).sum() / getDataEqualToMonthAndFuelType(data, i, fuelType).count(),
                getDataEqualToMonthAndFuelType(data, i, fuelType).mapToDouble(Data::getTotalPrice).sum())).collect(Collectors.toList());
    }

    public List<Data> getData(IFuelService fuelService) {
        return fuelService.findAll();
    }

    public Data insertNewDriver(int driverId, String fuelType, double price, double liters, String date, IFuelService fuelService) {
        return fuelService.insertNewDriver(driverId, fuelType, price, liters, date);
    }

    private Stream<Data> getDataEqualToMonth(List<Data> data, int i) {
        return data.stream().filter(d -> d.getDate().split("-")[1].equals(i <= 9 ? "0" + (i) : Integer.toString(i)));
    }

    private Stream<Data> getDataEqualToMonthAndFuelType(List<Data> data, int i, String fuelType) {
        return getDataEqualToMonth(data, i).filter(d -> fuelType.equals(d.getFuelType()));
    }

    private List<Data> callAndCheckRequest(int driverId, IFuelService fuelService)
    {
        return driverId != -1 ? fuelService.findDriverById(driverId) : fuelService.findAll();
    }
}
