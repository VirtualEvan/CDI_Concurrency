/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica2;

import java.util.Scanner;
import java.util.Random;
/**
 * @brief Clase que crea una matriz con números aleatorios menores que 10
 * @author Nara, Javier, Esteban
 */
class Matriz{

  // Matriz donde se introducirán los números
  public int[][] array;
  Random rn = new Random();

  /**
   * @brief Constructor de la Clase, coloca en cada posición del array un número aleatorio menor que 10
   * @param n int el número de filas y columnas que tendrá el array
   * @author Nara, Javier, Esteban
   */
  public Matriz(int n) {
    array = new int[n][n];
    for (int i=0 ; i < n; i++){
      for (int j=0 ; j < n; j++){
        array[i][j] = rn.nextInt(10);
      }
    }
  }
}
/**
 * @brief Clase que suma los arrays mediante threads, uno para cada fila
 * @author Nara, Javier, Esteban
 */
public class Hilos extends Thread {

  /** Variable tiempo que lleva completar un hilo */
  public double tiempo;
  /** Número de fila */
  private final int f;
  /** Tamaño del array */
  private static int res[][];
  /** Filas de la matriz 1 */
  public int fm1[];
  /** Filas de la matriz 2 */
  public int fm2[];

  /**
   * @brief Constructor de la Clase, inicializa las variables necesarias y crea el array resultante
   * @param n int, el número de filas y columnas que tendrá el array resultante y el número de elementos de los vectores 'fila'
   * @param f int, el número de fila seleccionado de ambos arrays
   * @param fila_m1 int[], vector con el contenido de una fila de uno de los arrays a sumar
   * @param fila_m2 int[], vector con el contenido de una fila del otro array a sumar
   * @author Nara, Javier, Esteban
   */
  public Hilos(int n, int f, int fila_m1[], int fila_m2[]) {
      res = new int[n][n];
      this.f = f;
      fm1 =  fila_m1;
      fm2 = fila_m2;
  }

  /**
  *@brief Función run para iniciar el thread, suma ambos arrays y lo almacena en la variable res[][], además de calcular su tiempo de ejecución
  *
  */
  @Override
  public void run() {
      try{
          double inicio = (long) System.nanoTime();
          for (int i = 0; i < res[f].length; i++) {
            res[f][i] = fm1[i] + fm2[i];
            System.out.print(res[f][i]+ "\t");
          }

          double fin = (long) System.nanoTime();
          tiempo = fin - inicio;
          System.out.println(" Fila " +f+ " calculada en " +tiempo/1000000 +" ms");
      }catch (Exception exc){};
  }

  /**
   * @brief Función que inicia un thread con cada una de las filas de los arrays y devuelve el array resultante
   * @param m1 Matriz, elemento que contiene el primer array a sumar
   * @param m2 Matriz, elemento que contiene segundo primer array a sumar
   * @return res int[][], array resultante de la suma de ambos vectores
   * @author Nara, Javier, Esteban
   */
  public static int[][] sumar(Matriz m1, Matriz m2){
    try {
      Hilos hilo=null;
      double total = 0;

      for (int i = 0; i < m1.array.length; i++) {
        hilo = new Hilos(m1.array.length, i, m1.array[i], m2.array[i] );
        hilo.start();
        hilo.join();
        total += hilo.tiempo;
      }
      System.out.println("\nProgram has terminated in "+ total/1000000 +" ms");

    } catch (InterruptedException e) {
        System.err.println("ERROR");
    }
    return res;
  }

  /**
  * @brief Función main del ejercicio, pide que se le introduzca por pantalla el número de elementos del array,
  * crea las matrices a sumar e invoca la función sumar, pasándole como parámetro los arrays creados
  *
  */
  public static void main (String[] args){

      Scanner tamaño = new Scanner(System.in);
      System.out.println("Practica2");
      System.out.print("Introduzca tamaño de la matriz: ");
      String tam = tamaño.nextLine();
      int n = Integer.parseInt(tam);

      Matriz matriz1 = new Matriz(n);
      Matriz matriz2 = new Matriz(n);

      //Imprimir matrices
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            System.out.print(matriz1.array[i][j] + " ");
        }
        System.out.print("  |  ");
        for (int j = 0; j < n; j++) {
            System.out.print(matriz2.array[i][j] + " ");
        }
        System.out.print("\n");
      }

      sumar(matriz1, matriz2);
  }
}