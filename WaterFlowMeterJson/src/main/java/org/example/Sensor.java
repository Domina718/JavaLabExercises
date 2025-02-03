package org.example;

import lombok.Data;

import java.util.Random;


@Data
public class Sensor {
    private String name;
    private float value;
    private int factor;
    private int rangeLow;
    private int rangeHigh;
    private String unit;


    public Sensor(){
    }
    public Sensor(String name, int factor, int rangeLow, int rangeHigh, String unit){
        this.name = name;
        this.factor = factor;
        this.rangeLow = rangeLow;
        this.rangeHigh = rangeHigh;
        this.unit = unit;
        setSensor();
    }

    private void setSensor(){
        if (factor != 0){
            this.value = (float) getRandomNumber(rangeLow, rangeHigh) / factor;
        }
        else{
            this.value = (float) getRandomNumber(rangeLow, rangeHigh);
        }
    }

    public Sensor refresh() {
        setSensor();
        return this;
    }

    private int getRandomNumber(int min, int max) {
        Random randNum = new Random();
        return randNum.nextInt(max-min) + min;
    }

    @Override
    public String toString(){return name + " je " + value + " " + unit;}

}