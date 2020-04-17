package com.homework.FuelConsumptionApplication;

public class Fuel {
    private String month;
    private String fuelType;
    private Double liters;
    private Double totalPrice;
    private Double averagePrice;

    public Fuel(String month, String fuelType, Double liters, Double averagePrice, Double totalPrice)
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

    public Double getLiters() {
        return liters;
    }

    public void setLiters(Double liters) { this.liters = liters; }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) { this.totalPrice = totalPrice; }

    public Double getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(Double averagePrice) { this.averagePrice = averagePrice; }
}
