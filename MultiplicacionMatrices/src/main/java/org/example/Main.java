package org.example;

import org.example.channel.Canal;
import org.example.consumer.Consumidor;
import org.example.consumer.DisMemory;
import org.example.consumer.ShaMemory;
import org.example.message.Mensaje;
import org.example.producer.Productor;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        int size  = 3;
        int[][] A  = new int[size][size];
        int[][] B  = new int[size][size];
        ArrayList<int[][]> lista = new ArrayList<>();
        iniciarMatriz(A);
        System.out.println();
        iniciarMatriz(B);
        System.out.println();
        lista.add(A);
        lista.add(B);
        Canal canal = new Canal();

        Productor productor = new Productor(canal) {
            @Override
            public void publicar(Mensaje mensaje) {
                super.publicar(mensaje);
            }
        };

        canal.registrarConsumidor(new DisMemory());
        canal.registrarConsumidor(new ShaMemory());

        Mensaje<ArrayList> msg2 = new Mensaje<>(lista);
        productor.publicar(msg2);
    }
    public static void iniciarMatriz(int[][] matriz){
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = (int) (Math.random() * 10);
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}