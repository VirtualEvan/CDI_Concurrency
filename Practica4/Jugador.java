package Practica4;

import java.util.concurrent.Semaphore;

/* @brief Clase que implementa los threads del Ping Pong
 * @author Nara, Javier, Esteban
 */
public class Jugador implements Runnable  {
    private int numJugador;
    private Pelota pelota;
    private Semaphore semaforo;

    /** @brief Método constructor de la clase
     * @author Nara, Javier, Esteban
     * @arg int id : Número identificador del jugador a crear
     * @arg Pelota pelota : Objeto pelota con la cual se realizará el juego
     * @arg Semaphore semaforo : Objeto semáforo que
     */
    public Jugador(int id, Pelota pelota, Semaphore semaforo) {
    	this.numJugador = id;
    	this.pelota = pelota;
    	this.semaforo = semaforo;
    }

    @Override
    public void run() {
        while(pelota.getEstado()) {

            try {
                semaforo.acquire();
                if (pelota.getPosesion() == this.numJugador) {
                    if(pelota.getValor() && pelota.getEstado()) {
                        System.out.println("Jugador "+this.numJugador+": Ping!");
                        pelota.setValor(false);
                        pelota.incrementarJugada();
                    } else if(pelota.getEstado()) {
                        System.out.println("Jugador "+this.numJugador+": Pong!");
                        pelota.setValor(true);
                        pelota.incrementarJugada();
                    }

                    // Condicion de parada por numero de jugadas
                    if (pelota.getModalidad() !=0 && pelota.getJugadas() == pelota.getMaxJugadas()) {
                         pelota.setEstado(false);
                    }

                    if (this.numJugador < (pelota.getJugadores()-1)) {
                         pelota.setPosesion(this.numJugador+1);
                    } else {
                         pelota.setPosesion(0);
                    }
                    semaforo.release();
                } else {
                    semaforo.release();
                }
            } catch (InterruptedException e1) {
                System.out.println("Error en el control del tráfico (semáforo)!!\n");
            }
        }
    }
}
