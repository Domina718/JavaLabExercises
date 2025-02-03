package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.paho.client.mqttv3.MqttException;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws MqttException, InterruptedException, IOException {
        MqttPublisher publisher = new ObjectMapper().readValue(new File("sensor.json"), MqttPublisher.class);
        publisher.publish();
    }
}

//mosquitto_sub -h 127.0.0.1 -t sensor_data