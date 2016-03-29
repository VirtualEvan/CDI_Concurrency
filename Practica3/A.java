package Practica3;

/** @brief Clase encargada de mostrar la ejecución del hilo
 * @author Nara, Javier, Esteban
 */
public class A {


	/** @brief Método que implementa un delay de 3 segundos
	 * @author Nara, Javier, Esteban
	 */
	public void EnterAndWait(){

		System.out.println("Se ha comenzado a ejecutar el hilo: " + Hilo.currentThread().getId());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Ahora se ejecuta el hilo" + Hilo.currentThread().getId());

	}

}
