import java.awt.image.BufferedImage;
import java.io.*;
import java.net.Socket;

import javax.imageio.ImageIO;

/** @brief Clase que contiene el main del cliente que realiza la conexión y calcula Mandelbrot
 * @author Nara, Javier, Esteban
 */
public class Client {

		protected static Socket socket;
		protected static ObjectOutputStream output;
		protected static ObjectInputStream input;

		/** @brief Método main de la clase
		 * @author Nara, Javier, Esteban
		 * @param args[] : Array de argumentos pasados como parámetros
		 */
    public static void main(String[] args) throws ClassNotFoundException, InterruptedException, IOException {


            socket = new Socket("127.0.0.1", 15000);
            output = new ObjectOutputStream(socket.getOutputStream());
            input = new ObjectInputStream(socket.getInputStream());

            Data dataReturn = new Data();
            dataReturn.setAccion("Request");
            System.out.println("Connection type: " + dataReturn.getAccion());
            output.writeObject(dataReturn);

            Object dataConnection;
            Data dataGet = null;
            dataConnection = input.readObject();
            if (dataConnection instanceof Data) dataGet = (Data)dataConnection;
            if (dataGet.getAccion().equals("Response")){
            	//System.out.println("["+dataGet.getStart()+","+dataGet.getEnd()+"]");
            	Mandelbrot creador = new Mandelbrot(dataGet.getFractalX(),dataGet.getFractalY(),dataGet.getSize(),dataGet.getN(),255,dataGet.iterations);
            	BufferedImage pic = creador.realizarFractal(dataGet.getStart(), dataGet.getEnd(), dataGet.getN());
            	System.out.println("Connection ended");
            	ByteArrayOutputStream array = new ByteArrayOutputStream();
            	ImageIO.write(pic, "jpg", array);
            	output.writeObject(array.toByteArray());
            }
            input.close();
            output.close();
            socket.close();
    }
}