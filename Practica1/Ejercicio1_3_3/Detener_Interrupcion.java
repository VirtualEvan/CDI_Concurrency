/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio1_3_3;
/**
 * @brief Thread que se detiene tras una señal del usuario, con diferentes acciones en función del tiempo transcurrido
 * @author Nara, Javier, Esteban
 */
 public class Detener_Interrupcion implements Runnable {
     int n;
     boolean detener;
     Detener_Interrupcion(int n) {
         this.n = n;
         this.detener = false;
     }

     /**
*@brief Función run para iniciar el thread
*
*/
@Override
     public void run() {
         int i = 0;
         System.out.println("Hello, I'm thread number " + n);
         while(!detener && i < 10){

            try {
                System.out.print("Thread "+this.n + ": ");
                System.out.println(i);
                Thread.sleep(1000);
                i++;
            }catch (InterruptedException ex) {}

         }
         if(detener == true) {
             if(i <= 5) {
                 System.out.println(this.n+": Thread interrumpido en menos de 5 segundos, tiempo restante: "+ (10-i)+ " segundos");
                 try {
                     Thread.sleep((10-i)*1000);
                     System.out.println(this.n+": Thread terminado");
                 }catch (InterruptedException ex2) {}
             } else {
                 System.out.println(this.n+": Thread interrumpido después de 5 segundos, TERMINADO");
             }
         } else {
             System.out.println(this.n+": Thread terminado");
         }
     }
     public void setdetener(){
         detener = true;
     }
     /**
     *@brief Función main del ejercicio
     *
     */


     /**
*@brief Función main del ejercicio
*
*/


public static void main (String[] args) {

        Detener_Interrupcion t = new Detener_Interrupcion(1);
	Thread hilo = new Thread(t);
        hilo.start();
         try
        {
            System.in.read();
            hilo.interrupt();
            if(hilo.isInterrupted())
            {
                t.setdetener();
            }

        }
        catch(Exception e)
        {

        }



    }

 }
