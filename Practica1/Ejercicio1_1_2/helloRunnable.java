/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio1_1_2;

/**
 * @brief Creación de hilos usando la clase Runnable
 * @author Nara, Javier, Esteban
 */
public class helloRunnable implements Runnable {
    /**
*@brief Función run para iniciar el thread
*
*/
@Override
    public void run()
    {
        System.out.println("Hello World, I'm a Java Thread.");

        System.out.println("Program of excercise 1.1.2 has terminated");
    }


    /**
*@brief Función main del ejercicio
*
*/


public static void main (String[] args)
    {
        //El método start crea los recuros del sistema necesarios para que el subproceso se ejecute
        //y llama al método run.
        System.out.println("Mensaje con la Interfaz Runnable");
        (new Thread(new helloRunnable())).start();
    }
}
