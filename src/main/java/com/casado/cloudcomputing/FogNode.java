package com.casado.cloudcomputing;

public class FogNode {
    private final CloudServer CLOUDSERVER;
    private int alertCount;

    public FogNode (CloudServer cloudServer){
        this.CLOUDSERVER = cloudServer;
    }

    public void processData(SensorData data){
        
        System.out.println("[FOG] Dato recibido: " + data);

        if(data.getTEMPERATURE()>20){
            alertCount++;
            System.out.println("[FOG] ALERTA: temperatura alta");
        } else
            System.out.println("[FOG] Temperatura normal");

            CLOUDSERVER.saveData(data);
    } 


    public int getAlertCount(){
        return alertCount;
    }

}
