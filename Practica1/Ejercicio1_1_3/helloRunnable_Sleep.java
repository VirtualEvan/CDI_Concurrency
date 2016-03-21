/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio1_1_3;

/**
 * @brief Creación de hilos usando la clase Runnable y usando el método sleep para crear el delay de 1 segundo
 * @author Nara, Javier, Esteban
 */
public class helloRunnable_Sleep implements Runnable{
    /**
*@brief Función run para iniciar el thread
*
*/
@Override
    public void run(){
        try{
        Thread.sleep(1000);
        System.out.println("Hello World, I'm a Java Thread.");
        }catch (Exception exc){};

        System.out.println("Program of excercise 1.1.3 has terminated");
    }

    public static void main (String [] args){
        System.out.println("Mensaje con un retardo de 1 seg con la Interfaz Runnable");
        new Thread((new helloRunnable_Sleep())).start();
    }
}
