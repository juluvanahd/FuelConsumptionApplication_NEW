package com.homework.FuelConsumptionApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
public class FuelService implements IFuelService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Data> findAll() {

        String sql = "SELECT * FROM data";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Data.class));
    }

    @Override
    public List<Data> findDriverById(int driverId) {

        String sql = "SELECT * FROM data WHERE driverId = ?";

        return jdbcTemplate.query(sql, new Object[]{driverId},
                new BeanPropertyRowMapper<>(Data.class));
    }

    @Override
    public Data insertNewDriver(int driverID, String fuelType, double price, double liters, String date) {

        double totalPrice = price * liters;

        String sql = String.format("INSERT INTO data (driverId, fuelType, price, liters, date, totalPrice) VALUES (%d, '%s', %s, %s, '%s', %s)", driverID, fuelType, price, liters, date, totalPrice);

        jdbcTemplate.execute(sql);

        return new Data(driverID, fuelType, price, liters, date, totalPrice);
    }
}
