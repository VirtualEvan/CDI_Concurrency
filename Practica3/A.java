package Practica3;

public class A {

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
