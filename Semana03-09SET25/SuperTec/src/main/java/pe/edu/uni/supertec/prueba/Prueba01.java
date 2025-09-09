package pe.edu.uni.supertec.prueba;

import pe.edu.uni.supertec.dto.AlumnoDto;
import pe.edu.uni.supertec.service.AppService;

public class Prueba01 {

	public static void main(String[] args) {
		// Proceso
		AppService appService = new AppService();
		AlumnoDto lista[] = appService.getListado();
		// Reporte
		for (AlumnoDto dto : lista) {
			System.out.println(dto);
		}
	}

	
}
