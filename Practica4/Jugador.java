package Practica4;


/** @brief Clase que implementa los threads del Ping Pong
 * @author Nara, Javier, Esteban
 */
public class Jugador implements Runnable  {
    private int numJugador;
    private Pelota pelota;

    /** @brief Método constructor de la clase
     * @author Nara, Javier, Esteban
     * @param id : Número identificador del jugador a crear
     * @param pelota : Objeto pelota con la cual se realizará el juego
     */
    public Jugador( int id, Pelota pelota ) {
    	this.numJugador = id;
    	this.pelota = pelota;
    }

    /** @brief Método run en el que se realzará ping o pong si es el turno del el Thread en ejecución y se desbloquearán todos los threads
     * en caso contrario, se bloqueará el thread
     * @author Nara, Javier, Esteban
     */
    @Override
    public void run() {
      synchronized (pelota) {
      try {
        while(pelota.getEstado()) {

              if (pelota.getTurno() == this.numJugador) {

                  if(pelota.getTexto() && pelota.getEstado()) {
                      System.out.println("Jugador "+this.numJugador+": Ping!");
                      pelota.setTexto(false);
                      pelota.incrementarJugada();

                  } else if(pelota.getEstado()) {
                      System.out.println("Jugador "+this.numJugador+": Pong!");
                      pelota.setTexto(true);
                      pelota.incrementarJugada();
                  }

                  // Condicion de parada por numero de jugadas
                  if (pelota.getModalidad() !=0 && pelota.getJugadas() == pelota.getMaxJugadas()) {
                      pelota.setEstado(false);
                  }

                  if (this.numJugador < (pelota.getJugadores()-1)) {
                       pelota.setTurno(this.numJugador+1);
                  } else {
                       pelota.setTurno(0);
                  }
                  pelota.notifyAll();
              } else {
                  pelota.wait();
              }

          }
        }catch (Exception e){
                   System.out.println(e.getClass().getName());
        }
      }
    }
}
