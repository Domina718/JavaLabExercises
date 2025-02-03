package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import java.util.List;

@Data
public class MqttPublisher {
    private String url;
    private String topic;
    private List<Sensor> sensors;

    /*public MqttPublisher(){
        this.url = "tcp://localhost:1883";
        this.topic = "sensor_data";
        this.sensors = new ArrayList<>();
        createMessage();
    }*/

    /*private void createMessage() {
        sensors.add(new Sensor("Trenutna temperatura vode", 10, -32668, 32668,"C"));
        sensors.add(new Sensor("Trenutni tlak vode", 1000, 0, 65336,"Bar"));
        sensors.add(new Sensor("Potrosnja u zadnjih 1 min, 10 min, 1 sat, 1 dan", 0, 0, 65336,"litra"));
        sensors.add(new Sensor("Potrosnja u zadnjih 1 tjedan, 1 mjesec, 1 godinu", 10, 0, 65336,"m3"));
    }*/


    public String serializeMessage (Sensor sensor) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        //mapper.enable(SerializationFeature.INDENT_OUTPUT);
        return mapper.writeValueAsString(sensor.toString()) + System.lineSeparator();
    }

    public void publish() throws MqttException, InterruptedException, JsonProcessingException {
        MqttClient client = new MqttClient(url, MqttClient.generateClientId());

        MqttMessage message = new MqttMessage();

        while(true){
            sendMessage(client, message);
        }
    }

    public void sendMessage(MqttClient client, MqttMessage message) throws MqttException, InterruptedException, JsonProcessingException {
        client.connect();
        //create message

        for (var sensor : sensors) {
            String temp = serializeMessage(sensor.refresh());
            message.setPayload(temp.getBytes());
            client.publish(topic, message);
            Thread.sleep(1000L);
        }
        client.disconnect();
    }
}