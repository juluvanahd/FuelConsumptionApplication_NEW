package com.homework.FuelConsumptionApplication;

public class Data {
    private int driverId;
    private String fuelType;
    private double price;
    private double liters;
    private String date;
    private double totalPrice;

    public Data() {  }

    public Data(int driverID, String fuelType, double price, double liters, String date, double totalPrice) {
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

    public double getPrice() { return price; }

    public void setPrice(double price) { this.price = price; }

    public double getLiters() { return liters; }

    public void setLiters(double liters) { this.liters = liters; }

    public String getDate() { return date; }

    public void setDate(String date) { this.date = date; }

    public double getTotalPrice() { return totalPrice; }

    public void setTotalPrice(double totalPrice) { this.totalPrice = totalPrice; }
}
