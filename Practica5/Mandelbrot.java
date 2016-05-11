import java.awt.Color;
import java.awt.image.BufferedImage;

public class Mandelbrot {

	 double xc;
	 double yc;
     double size;
     int N;
     int max;
     int partes;
     BufferedImage pic;



    public Mandelbrot(double x, double y, double s, int n, int m,int partes) {
    		xc   = x;
   	    yc   = y;
        size = s;
        this.partes = partes;
        N   = n;   // create N-by-N image
        max = m;   // maximum number of iterations
        pic = new BufferedImage(N, N/partes,1);

	}

    public static int mand(Complex z0, int max) {
        Complex z = z0;
        for (int t = 0; t < max; t++) {
            if (z.abs() > 2.0) return t;
            z = z.times(z).plus(z0);
        }
        return max;
    }

    public BufferedImage realizarFractal(int start, int end, int width)  {
    	System.out.println("["+start+","+end+"]");
        for (int i = 0; i < width; i++) {
            for (int j = start; j <= end; j++) {
            	//System.out.println("\t["+i+","+j+"]");
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
