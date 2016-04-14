/*
 * (c) copyleft 2015 Universidade de Vigo.
 * lgvceleiro@gmail.com
 */
package Practica4;

import java.util.Scanner;

/**
  \file
  \brief Practica 4

*/
public class Arbitro {
  public static void main (String[] args){

    // Ejercicio 4.3
    int duracion = 1;            //Tiempo maximo de juego en segundos
    int jugadores = 2;           //Numero de hilos que juegan el partido
    int jugadorInicial = 0;      //Jugador que empieza
    int turnos = 200;            //Numero maximo de jugadas permitidas
    int modoJuego = 0;           //Tipo de juego: 0 por tiempo, 1 por numero de jugadas

    long comienzo = 0;
    long finalizacion = 0;

    Scanner escaner = new Scanner(System.in);

    do {
        System.out.print("Introduzca el numero de jugadores del partido: ");
        jugadores = escaner.nextInt();
    } while (jugadores < 0);

		do {
        System.out.print("Introduzca el numero del jugador que comienza: ");
        jugadorInicial = escaner.nextInt();
    } while ((jugadorInicial < 0) || (jugadorInicial > jugadores));

    do {
        System.out.print("Introduzca el modo de juego. [0 partido por tiempo | 1 partido por turnos]: ");
        modoJuego = escaner.nextInt();
    } while ((modoJuego < 0) || (modoJuego > 1));


		if(modoJuego == 0){
        do {
            System.out.print("Introduzca el número de segundos del partido [tiempo > 1]: ");
            duracion = escaner.nextInt();
        } while (duracion <= 0);
		} else {
        do {
          System.out.print("Introduzca cuántos turnos se jugarán: [turnos >= 2]");
          turnos = escaner.nextInt();
        } while (turnos < 2);
		}

		  Pelota pelota = new Pelota(jugadorInicial, jugadores, turnos, modoJuego);

      Thread[] jugadoresPingPong = new Thread[jugadores];
      Jugador[] players = new Jugador[jugadores];

      for(int i = 0; i < jugadores; i++) {
          jugadoresPingPong[i] = new Thread(players[i] = new Jugador(i, pelota));
      }

      int tiempoMilis = duracion*1000;
      comienzo = System.currentTimeMillis();

		try {
                    for(int i = 0; i < jugadores; i++) {
                        jugadoresPingPong[i].start();
                    }

                    if(modoJuego == 0) {
                        Thread.sleep(tiempoMilis);
                        System.out.print("Fin del partido!");
                        pelota.setEstado(false);
                    } else {
                        for(int i = 0; i < jugadores; i++) {
                            //jugadoresPingPong[i].notifyAll();
                            jugadoresPingPong[i].join();
                        }
                    }


      } catch(Exception ex){ pelota.setEstado(false);}

		finalizacion = System.currentTimeMillis();

		System.out.println("\nTurnos jugados: "+pelota.getJugadas());
		System.out.println("Practica4 has terminated in " +(finalizacion-comienzo)+ " ms");

    }
}
