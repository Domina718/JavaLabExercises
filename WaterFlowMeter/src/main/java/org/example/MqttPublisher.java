package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
public class MqttPublisher {
    private String url;
    private String topic;
    private List<Sensor> sensors;

    public MqttPublisher(){
        this.url = "tcp://localhost:1883";
        this.topic = "sensor_data";
        this.sensors = new ArrayList<>();
        createMessage();
    }

    private void createMessage() {
        sensors.add(new Sensor("Trenutna temperatura vode", 10, -32668, 32668,"C"));
        sensors.add(new Sensor("Trenutni tlak vode", 1000, 0, 65336,"Bar"));
        sensors.add(new Sensor("Potrosnja u zadnjih 1 min, 10 min, 1 sat, 1 dan", 0, 0, 65336,"litra"));
        sensors.add(new Sensor("Potrosnja u zadnjih 1 tjedan, 1 mjesec, 1 godinu", 10, 0, 65336,"m3"));
    }

    public void publish() throws MqttException, InterruptedException{
        MqttClient client = new MqttClient(url, MqttClient.generateClientId());

        MqttMessage message = new MqttMessage();

        while(true){
            sendMessage(client, message);
        }
    }

    public void sendMessage(MqttClient client, MqttMessage message) throws MqttException, InterruptedException {
        client.connect();
        //create message

        for (var sensor : sensors) {
            message.setPayload(sensor.refresh().toString().getBytes());
            client.publish(topic, message);
            Thread.sleep(1000L);
        }
        client.disconnect();
    }
}