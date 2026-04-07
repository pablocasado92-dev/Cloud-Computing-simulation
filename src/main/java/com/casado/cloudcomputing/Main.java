package com.casado.cloudcomputing;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numLecturas;
        CloudServer cloudServer = new CloudServer();
        FogNode fogNode = new FogNode(cloudServer);
        EdgeNode edgeNode = new EdgeNode(fogNode);

        System.out.println(" ==== SIMULACION CLOUD - FOG - EDGE ====\n ");
        System.out.println("Introduce el número de lecturas de temperatura a realizar: ");
        numLecturas = sc.nextInt();

        edgeNode.sendData(numLecturas);

        cloudServer.showData();
        System.out.println("Alertas detectadas en FOG: "+ fogNode.getAlertCount());
        sc.close();
    }
}