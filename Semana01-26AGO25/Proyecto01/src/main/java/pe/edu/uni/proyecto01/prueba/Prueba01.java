package pe.edu.uni.proyecto01.prueba;

import pe.edu.uni.proyecto01.service.MateService;

public class Prueba01 {
	
	public static void main(String[] args) {
		// Datos
		int num1 = 30;
		int num2 = 53;
		// Proceso
		MateService mateService = new MateService();
		int suma = mateService.sumar(num1, num2);
		// Reporte
		System.out.println("Numero 1: " + num1);
		System.out.println("Numero 2: " + num2);
		System.out.println("Suma: " + suma);
		System.out.println("Chevere!!!");
		
	}
	
}
