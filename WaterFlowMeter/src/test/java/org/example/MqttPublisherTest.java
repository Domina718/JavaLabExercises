package org.example;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.junit.Test;

import java.util.ArrayList;

public class MqttPublisherTest {
    MqttPublisher publisher = new MqttPublisher("tcp://localhost:1883", "random", new ArrayList<>());
    MqttClient client = new MqttClient(publisher.getUrl(), MqttClient.generateClientId());
    MqttMessage message = new MqttMessage();

    public MqttPublisherTest() throws MqttException {
    }


    @Test
    public void sendMessageTest() throws MqttException, InterruptedException {
        publisher.sendMessage(client, message);
    }
}