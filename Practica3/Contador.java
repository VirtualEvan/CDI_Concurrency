package Practica3;

/** @brief Clase que realiza el incremento de una variable
 * @author Nara, Javier, Esteban
 */
public class Contador {

	private int valor = 0;

	public Contador() {
	}
	/** @brief Método que realiza el incremento de la variable valor
	 * @author Nara, Javier, Esteban
	 * @args int n : Número de incrementos a realizar
	 * @return valor : Valor de la variable luego de realizar todos los incrementos
	 */
    public int incrementar(int n){
    	for(int i=0; i<n; i++){
    		valor++;
    	}
    	return valor;
    }

}
