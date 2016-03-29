package Practica3;

/** @brief Clase que implementa el main y se encarga de realizar la ejecución de threads con objetos de la clase B
 * y en la cuál todos los threads pueden ejecutar el método enter EnterAndWait()
 * @author Nara, Javier, Esteban
 */
public class Control1 {

	public static void main(String [] args){
		try{

			A objetoA = new A();

			B [] ArrayHilos = new B [Integer.parseInt(args[0])];
			Contador cont = new Contador();

			for(int i = 0; i < Integer.parseInt(args[0]); i++){

				ArrayHilos[i] = new B(objetoA);
				new Thread(ArrayHilos[i]).start();

			}
			}catch(Exception e){

				System.err.println("Error durante la ejecución del código");
			}
	}
}
