/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio1_2_1;

import java.util.Scanner;

/**
 * @brief Creación del número de hilos especificados por el usuario
 * @author Nara, Javier, Esteban
 */
public class Ejercicio1 extends Thread {
    //Crear una variable para conocer el numero de hilo

    private final int n;

    public Ejercicio1(int n) {
        this.n = n;
    }

    /**
*@brief Función run para iniciar el thread
*
*/
@Override
    public void run() {
        try{
            System.out.println("Hello, I'm thread number " + n);
            Thread.sleep(1000);
            System.out.println("Bye, this was thread number " + n);
        }catch (Exception exc){};
    }

    /**
*@brief Función main del ejercicio
*
*/


public static void main (String[] args){
         Scanner in = new Scanner(System.in);
         System.out.println("Ejercicio N hilos");
         System.out.println("Introduzca el número de hilos:");
        //args[0] - Número de hilos que se desean ejecutar.
        String in1 = in.nextLine();
        Ejercicio1 hilo=null;
        int n = Integer.parseInt(in1);

        try {
          for (int i = 0; i < n; i++) {
              hilo = new Ejercicio1(i);
              hilo.start();
          }
          hilo.join();
        } catch (InterruptedException exc) {
            System.err.println("ERROR");
        }
        System.out.println("Program of excercise 1.2.1 has terminated");
    }
}
