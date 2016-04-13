/*
 * (c) copyleft 2015 Universidade de Vigo.
 * lgvceleiro@gmail.com
 */
package Practica4;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

/**
  \file
  \brief Practica 4

*/
public class Main {
  public static void main (String[] args){

                // Ejercicio 4.3
                int duracion = 1;            //Tiempo maximo de juego en segundos
                int jugadores = 2;           //Numero de hilos que juegan el partido
                int jugadorInicial = 0;      //Jugador que empieza
                int numJugadas = 200;        //Numero maximo de jugadas permitidas
                int modalidad = 0;           //Tipo de juego: 0 por tiempo, 1 por numero de jugadas

                long comienzo = 0;
                long finalizacion = 0;

                Semaphore semaforo = new Semaphore(1);

		            Scanner escaner = new Scanner(System.in);

                do {
                    System.out.print("Introduzca el numero de jugadores que disputan el partido (Entero mayor de 0): ");
                    jugadores = escaner.nextInt();
                } while (jugadores < 0);

		do {
                    System.out.print("Introduzca el numero del jugador que saca o empieza el partido (El jugador tiene que existir): ");
                    jugadorInicial = escaner.nextInt();
                } while ((jugadorInicial < 0) || (jugadorInicial > jugadores));

                do {
                    System.out.print("Introduzca la modalidad del partido (0 por tiempo, 1 por numero de jugadas): ");
                    modalidad = escaner.nextInt();
                } while ((modalidad < 0) || (modalidad > 1));


		if(modalidad == 0){
                    do {
                        System.out.print("Introduzca la duracion del partido en segundos (minimo 1 segundo): ");
                        duracion = escaner.nextInt();
                    } while (duracion <= 0);
		} else {
                     do {
                        System.out.print("Introduzca el numero de jugadas del partido (minimo 2 jugadas): ");
                        numJugadas = escaner.nextInt();
                    } while (numJugadas < 2);
		}

		Pelota pelota = new Pelota(jugadorInicial, jugadores, numJugadas, modalidad);

                Thread[] jugadoresPingPong = new Thread[jugadores];
                Jugador[] gamers = new Jugador[jugadores];

                for(int i = 0; i < jugadores; i++) {
                    jugadoresPingPong[i] = new Thread(gamers[i] = new Jugador(i, pelota, semaforo));
                }

                int tiempoMilis = duracion*1000;
		comienzo = System.currentTimeMillis();

		try {
                    for(int i = 0; i < jugadores; i++) {
                        jugadoresPingPong[i].start();
                    }

                    if(modalidad == 0) {
			Thread.sleep(tiempoMilis);
                        System.out.print("Se acabo el tiempo!");
			pelota.setEstado(false);
                    } else {
                        for(int i = 0; i < jugadores; i++) {
                            jugadoresPingPong[i].join();
                        }
                    }
      } catch(Exception ex){ pelota.setEstado(false);}

		finalizacion = System.currentTimeMillis();

		System.out.println("\nNumero de jugadas del partido: "+pelota.getJugadas());
		System.out.println("Tiempo de ejecucion del programa: "+(finalizacion-comienzo)+" en milisegundos.");

    }
}
