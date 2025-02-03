package org.example;

import org.eclipse.paho.client.mqttv3.MqttException;

public class Main {
    public static void main(String[] args) throws MqttException, InterruptedException {
        MqttPublisher publisher = new MqttPublisher();
        publisher.publish();
    }
}