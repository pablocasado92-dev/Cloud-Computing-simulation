package com.casado.cloudcomputing;

public class EdgeNode {
    private final FogNode fogNode;
    private int id;


    public EdgeNode(FogNode fogNode, int id){
        this.fogNode = fogNode;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void sendData(int totalReadings){
        for (int i=1;i<=totalReadings;i++){
            if (fogNode.getAlertCount()<20){
                double temperature = 20 + Math.random()*15+1;
                SensorData data = new SensorData("sensor-1", temperature);
                System.out.println("[EDGE] Enviando lectura: "+ i + ": " + data);
                fogNode.processData(data);
                System.out.println();
            }
            else
                break; 
        }
    }

}
