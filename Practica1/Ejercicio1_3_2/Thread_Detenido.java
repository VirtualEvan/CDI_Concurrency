/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio1_3_2;

/**
 * @brief Crea un Thread y comprueba con isInterrupted() e interrupted() antes y después de interrumpirlo
 * @author Nara, Javier, Esteban
 */
public class Thread_Detenido extends Thread{

    private final int n;

    public Thread_Detenido(int n) {
        this.n = n;
    }

    /**
*@brief Función run para iniciar el thread
*
*/
@Override
    public void run()
    {
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


public static void main (String[] args)
    {
        System.out.println("Diferencia entre interrupted() y isInterrupted()");
        Thread_Detenido hilo = new Thread_Detenido(1);
        hilo.start();
        System.out.println("Antes de ejecutar interrupt() el hilo ha sido interrumpido.");
        System.out.println("isInterrupted(): " + hilo.isInterrupted());
        System.out.println("interrupted(): " + hilo.interrupted());
        hilo.interrupt();
        System.out.println("Una vez ejecutado interrupt() el hilo ha sido interrumpido.");
        System.out.println("isInterrupted(): " + hilo.isInterrupted());
        System.out.println("interrupted(): " + hilo.interrupted());
    }
}
