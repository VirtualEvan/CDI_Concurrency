/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio1_2_1;

import java.util.Scanner;

/**
 * @brief Creación del número de hilos especificados por el usuario y medición del tiempo de ejecucion de los hilos
 * @author Nara, Javier, Esteban
 */
public class Ejercicio2 extends Thread {
    //Crear una variable para conocer el numero de hilo

    private final int n;

    public Ejercicio2(int n) {
        this.n = n;
    }

    /**
*@brief Función run para iniciar el thread
*
*/
@Override
    public void run() {
            System.out.println("Hello, I'm thread number " + n);
            System.out.println("Bye, this was thread number " + n);
    }

    /**
*@brief Función main del ejercicio
*
*/


public static void main (String[] args){
        try {
            System.out.println("Ejercicio 2.2 - Calcula el tiempo de ejecución de N hilos");
            System.out.println("Introduzca número de hilos:");
            Ejercicio2 hilo = null;
            Scanner in = new Scanner(System.in);
            String in1 = in.nextLine();
            int valor = Integer.parseInt(in1);
            double start = (long)System.nanoTime();
            while (valor > 0) {
                hilo = new Ejercicio2(valor);
                hilo.start();
                valor--;
            }
            hilo.join();
            double fin = (long)System.nanoTime();
            System.out.println("El tiempo de ejecución es: " + (fin - start)/1000000000 + " segundos");
        } catch (InterruptedException exc) {
            System.err.println("ERROR");
        }
        System.out.println("Program of excercise 1.2.2 has terminated");
    }
}
