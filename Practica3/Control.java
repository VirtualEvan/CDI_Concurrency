package Practica3;

/** @brief Clase que implementa el main y se encarga de realizar la ejecución de threads con objetos de la clase B
 * y en la cuál solo un thread puede ejecutar el método enter EnterAndWait()
 * @author Nara, Javier, Esteban
 */
public class Control {

	public static void main (String [] args) throws InterruptedException{


		A objetoA = new A();
		B objetoB = new B(objetoA);
		Hilo [] ArrayHilos = new Hilo [Integer.parseInt(args[0])];
		Contador count = new Contador();
		try{

		for(int i = 0; i < Integer.parseInt(args[0]); i++){

			ArrayHilos[i] = new Hilo(i,5,count);
			ArrayHilos[i].start();
			objetoB.run();

		}
		}catch(Exception e){

			System.err.println("Error durante la ejecución del código");
		}
	}
}