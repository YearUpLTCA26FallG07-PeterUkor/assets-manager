package com.pluralsight;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Locale;

public class Vehicle extends Asset{
    private String makeModel;
    private int year;
    private int odometer;

    public Vehicle(String description, String dateAcquired, BigDecimal originalCost, String makeModel, int year, int odometer) {
        super(description, dateAcquired, originalCost);
        this.makeModel = makeModel;
        this.year = year;
        this.odometer = odometer;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    // A car's value is determined as
    @Override
    public BigDecimal getValue() {
        int age = LocalDate.now().getYear() - year;
        BigDecimal value = super.getValue();

        // 0-3 years old - 3% reduced value of cost per year
        if (age <= 3) {
            value = value.subtract(value.multiply(BigDecimal.valueOf(0.03 * age)));
            // 4-6 years old - 6% reduced value of cost per yea
        } else if (age <= 6) {
            value = value.subtract(value.multiply(BigDecimal.valueOf(0.06 * age)));
            // 7-10 years old - 8% reduced value of cost per year
        } else if (age <= 10) {
            value = value.subtract(value.multiply(BigDecimal.valueOf(0.08 * age)));
            // over 10 years old - $1000.00
        } else {
            value = BigDecimal.valueOf(1000.00);
        }

        // MINUS reduce final value by 25% if over 100,000 mile
        // unless makeModel contains word Honda or Toyota
        if (!makeModel.toLowerCase().contains("toyota") &&
                !makeModel.toLowerCase().contains("honda") &&
                odometer > 100000) {

            value = value.subtract(value.multiply(BigDecimal.valueOf(0.25)));
        }

        return value;
    }
}
