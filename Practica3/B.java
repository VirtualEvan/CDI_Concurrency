package Practica3;

public class B implements Runnable {

	private A alementoA;

	public B (A valorA){
		this.alementoA=valorA;
	}

	public void run(){
		valorA.EnterAndWait();
	}

}
