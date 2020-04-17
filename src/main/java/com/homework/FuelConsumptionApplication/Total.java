package com.homework.FuelConsumptionApplication;

public class Total {

    private String month;
    private Double total;

    public Total(String month, Double total)
    {
        this.setMonth(month);
        this.setTotal(total);
    }

    public void setMonth(String month) { this.month = month; }

    public String getMonth() { return month; }

    public void setTotal(Double total) { this.total = total; }

    public Double getTotal() { return total; }
}
