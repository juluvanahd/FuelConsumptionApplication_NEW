package com.homework.FuelConsumptionApplication;

public class Fuel {
    private String month;
    private String fuelType;
    private double liters;
    private double totalPrice;
    private double averagePrice;

    public Fuel(String month, String fuelType, double liters, double averagePrice, double totalPrice)
    {
        this.setMonth(month);
        this.setFuelType(fuelType);
        this.setLiters(liters);
        this.setAveragePrice(averagePrice);
        this.setTotalPrice(totalPrice);
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) { this.month = month; }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) { this.fuelType = fuelType; }

    public double getLiters() {
        return liters;
    }

    public void setLiters(double liters) { this.liters = liters; }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) { this.totalPrice = totalPrice; }

    public double getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(double averagePrice) { this.averagePrice = averagePrice; }
}
