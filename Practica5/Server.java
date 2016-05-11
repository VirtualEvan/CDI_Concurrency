import java.util.Scanner;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import java.util.logging.*;
import java.io.*;
import java.net.*;
import javax.imageio.ImageIO;

/** @brief Clase que contiene el main que inicia el servidor y controla los threads que reciben las imágenes
 * @author Nara, Javier, Esteban
 */
public class Server extends Thread {
    //static boolean done = false;
    static int width = 512;
    static int length = 512;
    static int index;
    static int iterations;
    static String inputString;
    static ServerSocket connection;
    static Socket socket;
    static Picture finalPic;

    private int start;
    private int end;

    private ObjectOutputStream output;
    private ObjectInputStream input;

    /** @brief Método constructor de la clase
     * @author Nara, Javier, Esteban
     * @param socket : Socket
     * @param iterations : Número de iteraciones necesarias para rellenar la foto
     * @param iteration : Iteración recibida
     * @param img : Imagen actual que se aplicará
     */
    public Server(Socket socket,int iterations,Iteration iteration, Picture img) {
      this.socket = socket;
      this.start = iteration.start;
  		this.end = iteration.end;
      this.finalPic = img;
      try {
        output = new ObjectOutputStream(socket.getOutputStream());
        input = new ObjectInputStream(socket.getInputStream());
      } catch (IOException ex) {
        Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
      }
    }

    /** @brief Método que realiza la desconexión
     * @author Nara, Javier, Esteban
     */
    public void desconnectar() {
      try {
        socket.close();
      } catch (IOException ex) {
        Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
      }
    }

    /** @brief Método run que gestiona los threads en el servidor
     * @author Nara, Javier, Esteban
     */
    @Override
    public void run(){
      try {
    		Object dataConnection;
    		Data dataGet = null;

    		dataConnection = input.readObject();

    		if (dataConnection instanceof Data) dataGet = (Data)dataConnection;
          if(dataGet.getAccion().equals("Request"))
          {

          	Data dataReturn = new Data("Response", start, end, iterations);
              output.writeObject(dataReturn);
          }
          byte v [] =  (byte[]) input.readObject();
          ByteArrayInputStream array = new ByteArrayInputStream( v );
          Picture foto = new Picture( ImageIO.read(array));
          //foto.show();
          for(int i = 0;i < foto.width();i++ ){
            for(int j = 0;j < foto.height();j++ ){
              finalPic.set(i, j+start, foto.get(i, j));
            }
          }
          System.out.println(socket + " Conexion finalizada. ");
          finalPic.show();
      } catch (IOException | ClassNotFoundException ex) {
        Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
      }

      desconnectar();
    }


    /** @brief Método main de la clase
     * @author Nara, Javier, Esteban
     * @param args[] : Array de argumentos pasados como parámetros
     */
    public static void main(String args[]){
        Picture image = new Picture(width,length);
        Scanner input = new Scanner(System.in);
        List<Iteration> itList = new LinkedList<Iteration>();


        do {
          System.out.println("\nSeleccione número de iteraciones necesarias para completar el fractal: ");
          System.out.println("0: 1");
          System.out.println("1: 2");
          System.out.println("2: 4");
          System.out.println("3: 8");
          System.out.println("4: 16");
          System.out.println("5: 32");
          System.out.println("6: 64");
          System.out.println("7: 128");
          System.out.println("8: 256");
          System.out.println("9: 512");
          System.out.println("10: 1024\n");
          System.out.print("Seleccionar: ");

          inputString = input.nextLine();
          index = Integer.parseInt(inputString);
        } while ( index < 0 || index > 10);


        switch(index){
          case 0: iterations = 1;
                  break;
          case 1: iterations = 2;
                  break;
          case 2: iterations = 4;
                  break;
          case 3: iterations = 8;
                  break;
          case 4: iterations = 16;
                  break;
          case 5: iterations = 32;
                  break;
          case 6: iterations = 64;
                  break;
          case 7: iterations = 128;
                  break;
          case 8: iterations = 256;
                  break;
          case 9: iterations = 512;
                  break;
          case 10: iterations = 1024;
                  break;
        }
        //iterations = 64;
        for ( int i = 0; i < length; i+=length/iterations ){
          itList.add( new Iteration(i, i+length/iterations-1) );
        }
        Iterator<Iteration> iterator = itList.iterator();
        System.out.println("Server iniciado");
        image.show();

        try {
          connection = new ServerSocket(15000);
          System.out.println("Esperando conecciones en el puerto 15000");
          while (true) {
            socket = connection.accept();
            System.out.println(socket+ " Conexión establecida");
            Server thread = new Server(socket,  iterations, iterator.next(), image);
            thread.start();
            thread.join();

            if(!iterator.hasNext()){
            	System.out.println("\nProgram of excercise 5 has terminated");
            	System.exit(0);
            }
          }
      } catch (IOException | InterruptedException ex) {
          Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}