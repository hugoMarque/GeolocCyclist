/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stema.managedbeans;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 *
 * @author Hugo Marque //
 */
@Named
@RequestScoped
public class MqttManagedBean {

    //attribut pour les messages
    private String txt;

    MqttClient client;

    /**
     * Creates a new instance of MqttManagedBean
     */
    public MqttManagedBean() {
    }

    @PostConstruct
    public void init() {
        try {
            System.out.println("DANS INIT MQTTManagedBean");

            client = new MqttClient("tcp://localhost:1883", MqttClient.generateClientId(), new MemoryPersistence());

            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            connOpts.setConnectionTimeout(300);
            connOpts.setKeepAliveInterval(30);
            connOpts.setMqttVersion(MqttConnectOptions.MQTT_VERSION_3_1_1);
            client.connect(connOpts);

            //je m'abonne Ã  ce topic 
            client.subscribe("topic/essaiCyclist");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    
    
    //publier un message MQTT sur le topic
    public void publishMessage() {
        try {

            MqttMessage message = new MqttMessage(txt.getBytes());
            client.publish("topic/essaiCyclist", message);

            txt = "";
        } catch (MqttException e) {
            e.printStackTrace();
        }

    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

}
