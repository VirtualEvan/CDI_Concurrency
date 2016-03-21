/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio1_2_4;

import java.util.Scanner;
/**
 * @brief Cada thread calcula su tiempo de ejecución, lo almacena en una variable publica y se calcula el tiempo total
 * @author Nara, Javier, Esteban
 */
 public class Ejercicio4 extends Thread {

     // Variable n�mero del hilo
     private final int n;
     // Variable tiempo que lleva completar un hilo
     public double tiempo;

     public Ejercicio4(int n) {
         this.n = n;
     }

     /**
*@brief Función run para iniciar el thread
*
*/
@Override
     public void run() {
         double start = (long) System.nanoTime();
         System.out.println("Hello, I'm thread number " + n);
         System.out.println("Bye, this was thread number " + n);
         double fin = (long) System.nanoTime();
         tiempo = fin - start;
     }

     /**
*@brief Función main del ejercicio
*
*/


public static void main (String[] args) {
         try {
             System.out.println("Sumar el tiempo de ejecución de cada hilo");
             System.out.println("Introduzca el número de hilos:");
             Scanner in = new Scanner(System.in);
             String in1 = in.nextLine();
             int n = Integer.parseInt(in1);
             Ejercicio4 hilo;
             double total = 0;
             for (int i = 0; i < n; i++) {
                 hilo = new Ejercicio4(i);
                 hilo.start();
                 hilo.join();
                 total += hilo.tiempo;
             }
             total = total / 1000000;
             System.out.println("El tiempo total de ejecución es: " + total + " milisegundos");
             System.out.println("Program of excercise 1.2.4 has terminated");
         } catch (InterruptedException e) {
             System.err.println("ERROR");
         }
     }
 }
