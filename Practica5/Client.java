import java.awt.image.BufferedImage;
import java.io.*;
import java.net.Socket;

import javax.imageio.ImageIO;

public class Client {

	 protected static Socket sk;
	 protected static ObjectOutputStream output;
	 protected static ObjectInputStream input;

    public static void main(String[] args) throws ClassNotFoundException, InterruptedException, IOException {


            sk = new Socket("127.0.0.1", 15000);
            output = new ObjectOutputStream(sk.getOutputStream());
            input = new ObjectInputStream(sk.getInputStream());

            Data paqueteE = new Data();
            paqueteE.setAccion("Request");
            System.out.println("Connection type: " + paqueteE.getAccion());
            output.writeObject(paqueteE);

            Object dataConnection;
            Data dataGet = null;
            dataConnection = input.readObject();
            if (dataConnection instanceof Data) dataGet = (Data)dataConnection;
            if(dataGet.getAccion().equals("Response")){
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
            sk.close();
    }
}