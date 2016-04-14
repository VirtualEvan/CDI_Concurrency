package Practica4;


/** @brief Clase que implementa el objeto Pelota para permitir jugar al Ping Pong
 * @author Nara, Javier, Esteban
 */
public class Pelota {
    private int turno;
    private boolean estado;
    private int jugadores;
    private int jugadas;
    private int maxJugadas;
    private int modalidad;
    private boolean texto;

    /** @brief Método constructor de la clase
     * @author Nara, Javier, Esteban
     * @param turno : Número del jugador al que le toca jugar
     * @param jugadores : Número de jugadores del partido
     * @param maxJugadas : Número de turnos que se realizarán en el juego
     * @param modalidad : Identificador que indica si el juego será por turnos o por tiempo
     */
    public Pelota( int turno, int jugadores, int maxJugadas, int modalidad ) {
    	this.turno = turno;
    	this.jugadores = jugadores;
    	this.maxJugadas = maxJugadas;
    	this.modalidad = modalidad;
      this.jugadas = 0;
      this.estado = true;
      this.texto = true;
    }

    /** @brief Método que asinga el jugador al cuál le corresponde el turno
     * @author Nara, Javier, Esteban
     * @param turno : Número del jugador al que le toca jugar
     */
    public void setTurno( int turno ) {
      this.turno = turno;
    }
    /** @brief Método que obtiene el jugador al cuál le corresponde el turno
     * @author Nara, Javier, Esteban
     * @return turno : Número del jugador al que le toca jugar
     */
    public int getTurno() {
      return this.turno;
    }

    /** @brief Método que cambia el estado del juego (termina el juego)
     * @author Nara, Javier, Esteban
     * @param bool : Estado que tendrá el juego
     */
    public void setEstado( boolean bool ) {
      this.estado = bool;
    }

    /** @brief Método que obtiene el estado del juego (termina el juego)
     * @author Nara, Javier, Esteban
     * @return int estado : Estado que tendrá el juego
     */
    public boolean getEstado() {
      return this.estado;
    }

    /** @brief Método que obtiene cuántos jugadores hay en el partido
     * @author Nara, Javier, Esteban
     * @return jugadores : Número de jugadores del partido
     */
    public int getJugadores() {
      return this.jugadores;
    }

    /** @brief Método que obtiene cuántos turnos se han realozado
     * @author Nara, Javier, Esteban
     * @return jugadas : Número de turnos que se han realizado
     */
    public int getJugadas() {
      return this.jugadas;
    }

    /** @brief Método que incrementa en 1 el número de turnos que se han realozado
     * @author Nara, Javier, Esteban
     */
    public void incrementarJugada() {
      this.jugadas++;
    }

    /** @brief Método que obtiene cuántos turnos se deben realizar en el partido
     * @author Nara, Javier, Esteban
     * @return maxJugadas : Número de turnos que se deben realizar
     */
    public int getMaxJugadas() {
      return this.maxJugadas;
    }

    /** @brief Método que obtiene cómo se llevará a cabo el partido (por tiempo o por turnos)
     * @author Nara, Javier, Esteban
     * @return modalidad : Modalidad que se jugará
     */
    public int getModalidad() {
      return this.modalidad;
    }

    /** @brief Método que asigna qué texto debe salir por pantalla (ping o pong)
     * @author Nara, Javier, Esteban
     */
    public void setTexto( boolean texto ) {
      this.texto = texto;
    }

    /** @brief Método que obtiene qué texto debe salir por pantalla (ping o pong)
     * @author Nara, Javier, Esteban
     * @return texto : Valor que identifica qué texto saldrá por pantalla
     */
    public boolean getTexto() {
      return this.texto;
    }

}
