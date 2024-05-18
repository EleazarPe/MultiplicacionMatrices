package org.example.consumer;

import org.example.message.Mensaje;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DisMemory extends Consumidor{
    @Override
    public void procesarMensaje(Mensaje mensaje) {
        if(mensaje.getContenido() instanceof ArrayList otra){
            int[][] A = (int[][]) otra.get(0);
            int[][] B = (int[][]) otra.get(1);
            int[][] C = new int[A.length][B.length];
            ExecutorService executor = Executors.newFixedThreadPool(2);
            System.out.println("Memeoria Distribuida: ");
            Runnable hilo1 = () -> {
                multiply(A,B,C, 0,A.length/2, "Hilo1");
            };
            Runnable hilo2 = () -> {
                multiply(A,B,C, A.length/2,A.length, "Hilo2");
            };
            executor.execute(hilo1);
            executor.execute(hilo2);

            executor.shutdown();
            try {
                if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                    executor.shutdownNow();
                }
            } catch (InterruptedException e) {
                executor.shutdownNow();
            }
            System.out.println("Resultado");

            imprimir(C);
        }

    }
public void imprimir(int[][] C){
        for (int i =0; i<C.length; i++){
            for (int j=0;j<C.length; j++ ){
                System.out.print(" "+C[i][j]+" ");
            }
            System.out.println();
        }
}
    public void multiply(int[][] A, int[][] B, int [][] C, int init, int finn, String letra){
        for (int i =init; i< finn; i++){
            for(int j =0; j<B.length; j++){
                for(int k=0; k<A.length; k++){
                    C[i][j] += A[i][k] * B[k][j];
                    System.out.print(A[i][k]+" * "+B[k][j]+" + ");
                }
                System.out.println(letra);
            }
        }
    }
}
