package Practica3;


/** @brief Clase que implementa runnable y contiene un valor de tipo A para su ejecución mediante hilos
 * @author Nara, Javier, Esteban
 */
public class B implements Runnable {

	private A elementoA;

	public B (A valorA){
		this.elementoA=valorA;
	}

	/** @brief Método run que implementa los threads
	 * @author Nara, Javier, Esteban
	 */
	public void run(){
		elementoA.EnterAndWait();
	}

}
