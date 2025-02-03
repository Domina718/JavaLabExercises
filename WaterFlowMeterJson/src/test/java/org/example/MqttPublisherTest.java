package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class MqttPublisherTest {
    MqttPublisher publisher = new ObjectMapper().readValue(new File("sensor.json"), MqttPublisher.class);
    MqttClient client = new MqttClient(publisher.getUrl(), MqttClient.generateClientId());
    MqttMessage message = new MqttMessage();

    Sensor sensor = new Sensor("voda", 1,1,100, "°C");

    public MqttPublisherTest() throws IOException, MqttException {
    }


    @Test
    public void sendMessageTest() throws MqttException, InterruptedException, JsonProcessingException {
        publisher.sendMessage(client, message);
    }

    @Test
    public void serializeMessageTest() throws JsonProcessingException {
        System.out.println(publisher.serializeMessage(sensor));


    }
}