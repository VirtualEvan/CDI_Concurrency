package Practica3;

public class Control {

	public static void main (String [] args) throws InterruptedException{

		try{

		A objetoA = new A();
		B objetoB = new B(objetoA);
		Hilo [] ArrayHilos = new Hilo [Integer.parseInt(args[0])];
		Contador count = new Contador();
		for(int i = 0; i < Integer.parseInt(args[0]); i++){

			ArrayHilos[i] = new Hilo(count,i);
			ArrayHilos[i].start();
			comenzar.run();

		}
		}catch(Exception e){

			System.err.println("Error durante la ejecución del código");
		}
	}
}