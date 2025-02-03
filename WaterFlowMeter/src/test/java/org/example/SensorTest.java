package org.example;

import org.junit.Assert;
import org.junit.Test;

public class SensorTest {

    @Test
    public void refreshTest(){
        String name = "name";
        int factor = 1;
        int rangeLow = 1;
        int rangeHigh = 200;
        String unit = "jedinica";

        Sensor sensor = new Sensor(name, factor, rangeLow, rangeHigh, unit);

        float randomNumber = sensor.getValue();
        sensor.refresh();
        float secondRandomNumber = sensor.getValue();

        Assert.assertNotEquals(randomNumber, secondRandomNumber);
        Assert.assertEquals(sensor.getName(), name);
        Assert.assertEquals(sensor.getUnit(), unit);
        Assert.assertEquals(sensor.getRangeLow(), rangeLow);
        Assert.assertEquals(sensor.getRangeHigh(), rangeHigh);
    }

}