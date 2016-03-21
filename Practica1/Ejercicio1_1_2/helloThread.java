/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio1_1_2;

/**
 * @brief Creación de hilos usando la clase Thread
 * @author Nara, Javier, Esteban
 */
public class helloThread extends Thread {
    /**
*@brief Función run para iniciar el thread
*
*/
@Override
    public void run()
    {
        System.out.println("Hello World, I'm a Java thread.");

        System.out.println("Program of excercise 1.1.2 has terminated");
    }
    /**
*@brief Función main del ejercicio
*
*/


public static void main (String[] args)
    {
        System.out.println("Mensaje con la Clase Thread");
        (new helloThread()).start();
    }
}
