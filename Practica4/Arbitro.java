/*
 * (c) copyleft 2015 Universidade de Vigo.
 * lgvceleiro@gmail.com
 */
package Practica4;

import java.util.Scanner;

/* @brief Clase main, que decide quién comienza jugando, cuántos turnos, modo de juego e inicia el juego
 * @author Nara, Javier, Esteban
 */
public class Arbitro {
  public static void main (String[] args){

    int duracion = 1;
    int jugadores = 2;
    int jugadorInicial = 0;
    int turnos = 200;
    int modoJuego = 0;

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
                jugadoresPingPong[i].join();
            }
        }


      } catch(Exception ex){ pelota.setEstado(false);}

		finalizacion = System.currentTimeMillis();

		System.out.println("\nTurnos jugados: "+pelota.getJugadas());
		System.out.println("Practica4 has terminated in " +(finalizacion-comienzo)+ " ms");

    }
}
