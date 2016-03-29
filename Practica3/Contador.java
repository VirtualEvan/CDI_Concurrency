package Practica3;

public class Contador {

	private int valor = 0;

	public Contador() {
	}

    public int incrementar(int n){
    	for(int i=0; i<n; i++){
    		valor++;
    	}
    	return valor;
    }

}
