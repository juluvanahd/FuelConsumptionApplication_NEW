package com.homework.FuelConsumptionApplication;

public class Data {
    private int driverId;
    private String fuelType;
    private Double price;
    private Double liters;
    private String date;
    private Double totalPrice;

    public Data() {  }

    public Data(int driverID, String fuelType, Double price, Double liters, String date, Double totalPrice) {
        this.setDriverId(driverID);
        this.setFuelType(fuelType);
        this.setPrice(price);
        this.setLiters(liters);
        this.setDate(date);
        this.setTotalPrice(totalPrice);
    }

    public int getDriverId() { return driverId; }

    public void setDriverId(int driverId) { this.driverId = driverId; }

    public String getFuelType() { return fuelType; }

    public void setFuelType(String fuelType) { this.fuelType = fuelType; }

    public Double getPrice() { return price; }

    public void setPrice(Double price) { this.price = price; }

    public Double getLiters() { return liters; }

    public void setLiters(Double liters) { this.liters = liters; }

    public String getDate() { return date; }

    public void setDate(String date) { this.date = date; }

    public Double getTotalPrice() { return totalPrice; }

    public void setTotalPrice(Double totalPrice) { this.totalPrice = totalPrice; }
}
