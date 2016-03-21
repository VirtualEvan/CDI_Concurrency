/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio1_2_5;

import java.util.Scanner;
/**
 * @brief Muestra por separados los tiempos de inicialización de threads y los tiempos de ejecución de threads
 * @author Nara, Javier, Esteban
 */
 public class Ejercicio5 extends Thread {
     private final int n;

     public Ejercicio5 (int n){
         this.n=n;
     }

     /**
*@brief Función run para iniciar el thread
*
*/
@Override
     public void run(){
             System.out.println("Hello, I'm thread number " + n);
             System.out.println("Bye, this was thread number " + n);
     }

     public static void main(String[] args){
         try {
             System.out.println("Diferencia tiempo de Ejecución y tiempo de Creación");
             System.out.println("Introduzca número de hilos:");
             Scanner in = new Scanner(System.in);
             String in1 = in.nextLine();
             final int m = Integer.parseInt(in1);
             Ejercicio5[] hilos = new Ejercicio5[m];
             double startIni = (long)System.nanoTime();
             for(int i = 0; i < m; i++) {
                 hilos[i] = new Ejercicio5(i);
             }
             double finIni = (long)System.nanoTime();
             int j = m - 1;
             double startEj = (long)System.nanoTime();
             while(j >= 0) {
                 hilos[j].start();
                 j--;
             }
             j = m - 1;
             while(j >= 0) {
                 hilos[j].isAlive();
                 hilos[j].join();
                 j--;
             }
             double finEj = (long)System.nanoTime();
             double totalIni = (finIni-startIni)/1000000;
             double totalEj = (finEj-startEj)/1000000;
             System.out.println("El tiempo total de inicialización es: " + totalIni + " milisegundos");
             System.out.println("El tiempo total de ejecución es: " + totalEj + " milisegundos");
             System.out.println("Program of excercise 1.2.5 has terminated");
         } catch (InterruptedException exc) {
             System.out.println("ERROR");
         }
     }
 }
