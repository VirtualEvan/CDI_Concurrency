import java.awt.image.BufferedImage;
import java.io.Serializable;

@SuppressWarnings("serial")
public class Data implements Serializable{

	//Datos fractal
	private double fractalX = 0;
	private double fractalY = 0;
	private double size = 3;

	//Datos parte a calcular para Client
	private int start = 0;
	private int end = 0;
	private int N = 512;
	int iterations;
	private String accion;
	private BufferedImage pic;
	public Data() {
		// TODO Auto-generated constructor stub
	}

	public Data(String x, int s, int e,int it){
		accion = x;
	 this.start = s;
	 this.end = e;
	 this.iterations = it;
	}

	public void setDatosFractal(double fracX, double fracY, double s){
		fractalX = fracX; fractalY = fracY; size = s;
	}
	public void setPicture(BufferedImage p){
		pic = p;
	}
	public BufferedImage getPicture(){
		return pic;
	}
	public int getN(){
		return N;
	}

	public String getAccion(){
		return accion;
	}

	public void setAccion(String x){
		accion = x;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEndEnd(int end) {
		this.end = end;
	}

	public void setN(int n) {
		N = n;
	}

	public double getFractalX() {
		return fractalX;
	}

	public void setFractalX(double fractalX) {
		this.fractalX = fractalX;
	}

	public double getFractalY() {
		return fractalY;
	}

	public void setFractalY(double fractalY) {
		this.fractalY = fractalY;
	}



}