/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio1_2_6;

import java.util.Scanner;
/**
 * @brief Al crear los threads, en caso de introducir el valor "1" se realiza una operación compleja, en caso contrario se procede a la identificación finalización de los threads
 * @author Nara, Javier, Esteban
 */
 public class Ejercicio6 extends Thread{
      /// Identifica el número de hilo
     private final int n;
     /// Identifica la operación a realizar
     private int op;

     public Ejercicio6 (int valor, int n)
     {
         this.n = n;
         op = valor;
     }

     /**
*@brief Función run para iniciar el thread
*
*/
@Override
     public void run()
     {
         if (op == 1) {
             double x = Math.random() * Math.random();
             double y = x * Math.random();
             double z = y * y * x * x * Math.random();
             System.out.println ("El resultado de la operacion es: " + z);
         } else {
             System.out.println("Soy un hilo de Java. Número " + n);
         }
     }


     /**
*@brief Función main del ejercicio
*
*/


public static void main (String[] args) throws InterruptedException
     {
         System.out.println("Comparar entre Math Mode y Screen Mode");
         System.out.println("Introduzca número de hilos:");
         Scanner in = new Scanner(System.in);
         String in1 = in.nextLine();
         int hilos = Integer.parseInt(in1);
         System.out.println("Introduzca un valor:(1 para que se realice la operación y otro valor cualquiera para devolver el número de hilo");
         Scanner n = new Scanner(System.in);
         String n1 = n.nextLine();
         int op = Integer.parseInt(n1);
         Ejercicio6 h[] = new Ejercicio6[hilos];
         double inicio = (long)System.nanoTime();
         if (op == 1)
             for (int i = 0; i < hilos; i++) {
                 h[i] = new Ejercicio6(op, i);
                 h[i].start();
             }
         else {
             for (int i = 0; i < hilos; i++) {
                 h[i] = new Ejercicio6(op, i);
                 h[i].start();
             }
         }
         int j = hilos - 1;
         while(j >= 0) {
             h[j].isAlive();
             h[j].join();
             j--;
         }
         double fin = (long)System.nanoTime();
         double total = (fin-inicio)/1000000;
         System.out.println("El tiempo total es: " + total + " milisegundos");
         System.out.println("Program of excercise 1.2.6 has terminated");
     }
 }
