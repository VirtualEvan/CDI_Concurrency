package Practica3;

import java.util.Scanner;

/** @brief Clase que implementa el main, además incluye la ejecución de threads
 * @author Nara, Javier, Esteban
 */
public class Hilo extends Thread{
	private int numThread;
	private int incremento;
	private Contador count;
	private int resultado;

	/** @brief Método constructor de la clase
	 * @author Nara, Javier, Esteban
	 * @arg int n : Número de thread
	 * @arg int incremento : Número de veces que se realizará el incremento
	 * @arg Contador contador : Contador creado
	 */
	public Hilo(int n, int incremento, Contador contador) {
		this.numThread = n;
		this.incremento = incremento;
		this.count=contador;
	}

	/** @brief Método que implementa la ejecución de los threads
	 * @author Nara, Javier, Esteban
	 */

	public void run()
	{
		System.out.println( "Incrementando en el Thread " +numThread );
		int resultado = 0;
		resultado = count.incrementar(incremento);
		System.out.println("El resultado es : "+resultado);
		System.out.println( "Finalizado el incrmento del Thread " +numThread );
	}



	/**
	 * @param args
	 */
	public static void main( String[] args ) {
		Scanner incrementos = new Scanner(System.in);
		Scanner threads = new Scanner(System.in);
		System.out.println("Practica3");
		System.out.print("Introduzca el número de threads: ");
		String thr = threads.nextLine();
		System.out.print("Introduzca el número de incrementos a realizar: ");
		String inc = incrementos.nextLine();
		int n = Integer.parseInt(thr);
		int m = Integer.parseInt(inc);
		Contador cont = new Contador();
		try {
		      Hilo hilo=null;
		      for (int i = 0; i < n; i++) {
						hilo = new Hilo(i, m, cont);
		        hilo.start();
		        hilo.join();
		      }
		    } catch (InterruptedException e) {
		        System.err.println("ERROR");
		    }
	}
}