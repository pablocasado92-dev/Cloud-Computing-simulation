package com.casado.cloudcomputing;

public class Main {
    public static void main(String[] args) {
        CloudServer cloudServer = new CloudServer();
        FogNode fogNode = new FogNode(cloudServer);
        EdgeNode edgeNode = new EdgeNode(fogNode);

        System.out.println(" ==== SIMULACION CLOUD - FOG - EDGE ====\n ");

        edgeNode.sendData(5);

        cloudServer.showData();
        System.out.println("Alertas detectadas en FOG: "+ fogNode.getAlertCount());
    }
}