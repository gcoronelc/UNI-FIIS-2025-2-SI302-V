/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.uni.proyecto01.prueba;

import pe.edu.uni.proyecto01.service.MateService;

/**
 *
 * @author PCB307
 */
public class valorZ {

	public static void main(String[] args) {
		//Ingresamos valores
		int valorX = 1;
		int valorY = 2;
		//Servicio
		MateService expresion = new MateService();
		//Calculamos la expresion
		double valorZ = expresion.evaluaExpresion(valorX, valorY);
		//Mostramos el resultado en pantalla
		System.out.println("El primer numero es: " + valorX);
		System.out.println("El segundo numero es: " + valorY);
		System.out.println("El resultado de la expresion es: " + valorZ);
	}
}
