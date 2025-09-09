package pe.edu.uni.supertec.service;

import pe.edu.uni.supertec.dto.AlumnoDto;

class Data {

	// Para evitar crear objetos
	private Data() {
	}
	
	// Variables
	static  final int TAMANIO = 50;
	static AlumnoDto[] tabla;
	static int filas;
	
	// Inicializacion de las variables
	static{
		tabla = new AlumnoDto[TAMANIO];
		tabla[0] = new AlumnoDto("KEVIN", 10, 15, 13, 18, 15);
		tabla[1] = new AlumnoDto("RENATO", 18, 5, 14, 10, 14);
		tabla[2] = new AlumnoDto("ANTHONY", 15, 16, 14, 12, 15);
		tabla[3] = new AlumnoDto("YADIRA", 12, 19, 15, 16, 16);
		filas = 4;
	}
	
}
