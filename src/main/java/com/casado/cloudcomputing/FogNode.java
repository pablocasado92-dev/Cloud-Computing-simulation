package com.casado.cloudcomputing;

import java.util.ArrayList;
import java.util.List;

public class FogNode {
    private final CloudServer CLOUDSERVER;
    private int alertCount;
    private int id;
    private final List<SensorData> dataBuffer = new ArrayList<>();
    private int dataCount = 0;
    private static final int BUFFER_SIZE = 5;

    public FogNode(CloudServer cloudServer, int id) {
        this.CLOUDSERVER = cloudServer;
        this.id = id;
    }
    
    public int getId() {
        return id;
    }

    public void processData(SensorData data) {
        
        System.out.println("[FOG] Dato recibido: " + data);
        try {
            Thread.sleep(1000); // 2000 ms = 2 segundos
        } catch (InterruptedException e) {
                    e.printStackTrace();
        }
        if (data.getTEMPERATURE() > 30) {
            alertCount++;
            System.out.println("[FOG] ALERTA: temperatura alta");
        } else {
            System.out.println("[FOG] Temperatura normal");
        }

        // Agregar dato al buffer
        dataBuffer.add(data);
        dataCount++;

        // Enviar al cloud si se alcanza el límite de 5 datos o si alertCount llega a 20
        if (dataCount >= BUFFER_SIZE || alertCount >= 20) {
            sendDataToCloud();
            dataBuffer.clear();
        }
    }

    private void sendDataToCloud() {
        if (!dataBuffer.isEmpty()) {
            System.out.println("\n[FOG] Enviando " + dataBuffer.size() + " datos al cloud...");
            for (SensorData data : dataBuffer) {
                CLOUDSERVER.saveData(data);
            }
            dataBuffer.clear();
            dataCount = 0;
        }
    }

    public int getAlertCount() {
        return alertCount;
    }
}