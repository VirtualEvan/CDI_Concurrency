package Practica3;

import java.util.Scanner;

public class Hilo extends Thread{
	private int numThread;
	private int incremento;
	private Contador count;
	private int resultado;

	public Hilo(int n, int incremento, Contador contador) {
		this.numThread = n;
		this.incremento = incremento;
		this.count=contador;
	}

	/** @brief threads
	 *
	 *
	 */

	public void run()
	{
		System.out.println( "Incrementando en el Thread " +numThread );
		int resultado = 0;
		resultado = cont.incrementar(incremento);
		System.out.println("El resultado es : "+valor);
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
		try {
		      Hilo hilo=null;
		      for (int i = 0; i < n; i++) {
						hilo = new Hilo(i, m);
		        hilo.start();
		        hilo.join();
		      }
		    } catch (InterruptedException e) {
		        System.err.println("ERROR");
		    }
	}
}