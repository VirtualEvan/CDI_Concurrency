import java.awt.image.BufferedImage;
import java.io.Serializable;

@SuppressWarnings("serial")
/** @brief Clase que implementa los datos que se envían entre cliente y servidor
 * @author Nara, Javier, Esteban
 */
public class Data implements Serializable{

	//Datos fractal
	private double fractalX = 0;
	private double fractalY = 0;
	private double size = 3;

	//Datos parte a calcular para cliente
	private int start = 0;
	private int end = 0;
	private int N = 512;
	int iterations;
	private String accion;
	private BufferedImage pic;
	public Data() {
		// TODO Auto-generated constructor stub
	}

	/** @brief Método constructor de la clase
	 * @author Nara, Javier, Esteban
	 * @param x : Nombre del paquete
	 * @param s : Coordenada Y del inicio de la iteración
	 * @param e : Coordenada Y del final de la iteración
	 * @param it : Número de iteraciones
	 */
	public Data(String x, int s, int e,int it){
		accion = x;
	 this.start = s;
	 this.end = e;
	 this.iterations = it;
	}

	/** @brief Método que asigna los datos del fractal
	 * @author Nara, Javier, Esteban
	 * @param fracX : Número de jugadores del partido
	 * @param fracY : Número de jugadores del partido
	 * @param s : Número de jugadores del partido
	 */
	public void setDatosFractal(double fracX, double fracY, double s){
		fractalX = fracX; fractalY = fracY; size = s;
	}

	/** @brief Método que da valor a la imagen pic
   * @author Nara, Javier, Esteban
   * @param p : Valor de la imagen
   */
	public void setPicture(BufferedImage p){
		pic = p;
	}

	/** @brief Método que obtiene el valor de la imagen pic
   * @author Nara, Javier, Esteban
   * @return pic : Valor de la imagen pic
   */
	public BufferedImage getPicture(){
		return pic;
	}

	/** @brief Método que obtiene el número máxio de iteraciones
   * @author Nara, Javier, Esteban
   * @return N : Número máximo de iteraciones
   */
	public int getN(){
		return N;
	}

	/** @brief Método que obtiene la acción
	 * @author Nara, Javier, Esteban
	 * @return accion : Número de jugadores del partido
	 */
	public String getAccion(){
		return accion;
	}

	/** @brief Método que asigna una accion
	 * @author Nara, Javier, Esteban
	 * @param jugadores : Acción a establecer
	 */
	public void setAccion(String x){
		accion = x;
	}

	/** @brief Método que obtiene el tamaño de la imagen
	 * @author Nara, Javier, Esteban
	 * @return size : Número de jugadores del partido
	 */
	public double getSize() {
		return size;
	}

	/** @brief Método que asigna el tamaño de la imagen
	 * @author Nara, Javier, Esteban
	 * @param size : Tamaño de la imagen a establecer
	 */
	public void setSize(double size) {
		this.size = size;
	}

	/** @brief Método que obtiene la coordenada y de inicio
	 * @author Nara, Javier, Esteban
	 * @return start : Coordenada Y donde inicia la ieracion
	 */
	public int getStart() {
		return start;
	}

	/** @brief Método que establece la coordenada Y donde inicia la iteracion
	 * @author Nara, Javier, Esteban
	 * @param start : Coordenada Y de inicio
	 */
	public void setStart(int start) {
		this.start = start;
	}
	/** @brief Método que obtiene la coordenada y de fin
	 * @author Nara, Javier, Esteban
	 * @return end : Coordenada Y donde termina la ieracion
	 */
	public int getEnd() {
		return end;
	}

	/** @brief Método que establece la coordenada Y donde termina la iteracion
	 * @author Nara, Javier, Esteban
	 * @param start : Coordenada Y de fin
	 */
	public void setEndEnd(int end) {
		this.end = end;
	}

	/** @brief Método que asigna el numero máximo de iteraciones
	 * @author Nara, Javier, Esteban
	 * @param n : Número máximo de iteraciones
	 */
	public void setN(int n) {
		N = n;
	}

	/** @brief Método que obtiene el fractal en X
	 * @author Nara, Javier, Esteban
	 * @return fractalX : Fractal en X
	 */
	public double getFractalX() {
		return fractalX;
	}

	/** @brief Método que asigna el valor del fractal en X
	 * @author Nara, Javier, Esteban
	 * @param fractalX : Fractal en X
	 */
	public void setFractalX(double fractalX) {
		this.fractalX = fractalX;
	}

	/** @brief Método que obtiene el fractal en Y
	 * @author Nara, Javier, Esteban
	 * @return fractalX : Fractal en Y
	 */
	public double getFractalY() {
		return fractalY;
	}

	/** @brief Método que asigna el valor del fractal en Y
	 * @author Nara, Javier, Esteban
	 * @param fractalX : Fractal en Y
	 */
	public void setFractalY(double fractalY) {
		this.fractalY = fractalY;
	}



}