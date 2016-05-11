import java.awt.Color;
import java.awt.image.BufferedImage;

/** @brief Clase que realiza el cálculo de Mandelbrot
 * @author Nara, Javier, Esteban
 */
public class Mandelbrot {

	 double xc;
	 double yc;
     double size;
     int N;
     int max;
     int iterations;
     BufferedImage pic;


 /** @brief Método constructor de la clase
  * @author Nara, Javier, Esteban
  * @param x : Valor de x
  * @param y : Valor de y
  * @param s : Tamaño de la iteración
	* @param n : Tamaño de los lados de la imagen
	* @param m : Número máximo de iteraciones
  * @param iterations : Número de iteraciones
  */
  public Mandelbrot(double x, double y, double s, int n, int m,int iterations) {
		xc   = x;
    yc   = y;
    size = s;
    this.iterations = iterations;
    N   = n;   // create N-by-N image
    max = m;   // maximum number of iterations
    pic = new BufferedImage(N, N/iterations,1);

	}


		/** @brief Método que realiza el cálculo de Nabdekbrot
		 * @author Nara, Javier, Esteban
		 * @param z0 : Número complejo para realizar el cálculo
		 * @param max : Número máximo de iteraciones
		 * @return max : Nuevo Número máximo de iteraciones
		 */
    public static int mand(Complex z0, int max) {
        Complex z = z0;
        for (int t = 0; t < max; t++) {
            if (z.abs() > 2.0) return t;
            z = z.times(z).plus(z0);
        }
        return max;
    }

		/** @brief Método que crea el fractal
		 * @author Nara, Javier, Esteban
		 * @param start : Coordenada Y donde comienza la Iteracion
		 * @param end : Coordenada Y donde acaba la Iteracion
		 * @param width : Ancho total de la imagen de la Iteración
		 * @return : Imagen pic
		 */
    public BufferedImage realizarFractal(int start, int end, int width)  {
    	System.out.println("["+start+","+end+"]");
        for (int i = 0; i < width; i++) {
            for (int j = start; j <= end; j++) {
                double x0 = xc - size/2 + size*i/N;
                double y0 = yc - size/2 + size*j/N;
                Complex z0 = new Complex(x0, y0);
                int gray = max - mand(z0, max);
                Color col = new Color(gray,gray,gray);

                pic.setRGB(i,j-start,col.getRGB());

            }
        }
       return pic;
    }
}
