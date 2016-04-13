package Practica4;


/* @brief Clase que implementa el objeto Pelota para permitir jugar al Ping Pong
 * @author Nara, Javier, Esteban
 */
public class Pelota {
    private int posesion;
    private boolean estado;
    private int jugadores;
    private int jugadas;
    private int maxJugadas;
    private int modalidad;
    private boolean valor;

    public Pelota( int posesion, int jugadores, int maxJugadas, int modalidad ) {
    	this.posesion = posesion;
    	this.jugadores = jugadores;
    	this.maxJugadas = maxJugadas;
    	this.modalidad = modalidad;
      this.jugadas = 0;
      this.estado = true;
      this.valor = true;
    }

    public void setPosesion( int posesion ) {
      this.posesion = posesion;
    }

    public int getPosesion() {
      return this.posesion;
    }

    public void setEstado( boolean bool ) {
      this.estado = bool;
    }

    public boolean getEstado() {
      return this.estado;
    }

    public int getJugadores() {
      return this.jugadores;
    }

    public int getJugadas() {
      return this.jugadas;
    }

    public void incrementarJugada() {
      this.jugadas++;
    }

    public int getMaxJugadas() {
      return this.maxJugadas;
    }

    public int getModalidad() {
      return this.modalidad;
    }

    public void setValor( boolean valor ) {
      this.valor = valor;
    }

    public boolean getValor() {
      return this.valor;
    }

}
