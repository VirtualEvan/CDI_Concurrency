/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio1_1_4;

/**
 * @brief Creación de hilos usando la clase Runnable y usando los metodos activeCount y currentThread para postrar el numero de hilos y el hilo actual
 * @author Nara, Javier, Esteban
 */
public class Runnable_Activo implements Runnable {
    /**
*@brief Función run para iniciar el thread
*
*/
@Override
    public void run(){
        System.out.println("Numero total de hilos: " + Thread.activeCount());
        System.out.println("Hilos activos: " + Thread.currentThread());
        System.out.println("Program of excercise 1.1.4 has terminated");
    }

    /**
*@brief Función main del ejercicio
*
*/


public static void main (String[] args){
        System.out.println("Hilos activos Interfaz Runnable");
        (new Thread(new Runnable_Activo())).start();
    }

}
