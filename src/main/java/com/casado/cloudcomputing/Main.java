package com.casado.cloudcomputing;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int NUM_NODES = 5;
        Scanner sc = new Scanner(System.in);
        int numLecturas;
        CloudServer cloudServer = new CloudServer();
        FogNode[] fogNodes = new FogNode[NUM_NODES];
        EdgeNode[][] edgeNodes = new EdgeNode[NUM_NODES][NUM_NODES];

        for(int i=0;i<NUM_NODES;i++){
            fogNodes[i] = new FogNode(cloudServer, i+1);
            for(int j=0;j<NUM_NODES;j++){
                edgeNodes[i][j] = new EdgeNode(fogNodes[i], j+1);
            }
        }
       

        System.out.println(" ==== SIMULACION CLOUD - FOG - EDGE ====\n ");
        System.out.println("Introduce el número de lecturas de temperatura a realizar: ");
        numLecturas = sc.nextInt();

       //edgeNodes[0].sendData(numLecturas);

        cloudServer.showData();
       // System.out.println("Alertas detectadas en FOG: "+ fogNodes[0].getAlertCount());
        sc.close();
    }
}