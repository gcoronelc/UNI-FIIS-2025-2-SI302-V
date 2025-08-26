package pe.edu.uni.proyecto01.service;

public class MateService {

	public int sumar(int num1, int num2) {
		// Variables
		int suma;
		// Proceso
		suma = num1 + num2;
		// Reporte
		return suma;
	}
	
	public int restar(int num1, int num2) {
		// Variables
		int resta;
		// Proceso
		resta = num1 - num2;
		// Reporte
		return resta;
	}

	public double evaluaExpresion(int x, int y) {
		// Parte 1: Proceso
		//Calculamos el cubo del número y
		double cuboY = Math.pow(y, 3);
		//Hacemos la suma dentro del radical
		double sumaRadical = x + cuboY;
		//Calculamos la raíz cuadrada de dicha suma
		double raizCuadrada = Math.sqrt(sumaRadical);
		// Parte 2: Reporte
		return raizCuadrada;
	}
}
