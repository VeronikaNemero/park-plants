package com.epam.training.vnemero.calculator;

import com.epam.training.vnemero.data.Plant;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class ParkCalculator {

    private List<Plant> allPlants;

    public ParkCalculator() {
        allPlants = new ArrayList<>();
    }

    public void addPlants(List<? extends Plant> plants) {
        allPlants.addAll(plants);
    }

    public int getPlantCount() {
        return allPlants.size();
    }

    public double getCommonHeight() {
        double result = 0;
        for (Plant plant : allPlants) {
            result += plant.getHeight();
        }

        BigDecimal decimal = BigDecimal.valueOf(result);
        decimal = decimal.setScale(2, RoundingMode.HALF_UP);
        result =  decimal.doubleValue();

        return result;
    }
}
