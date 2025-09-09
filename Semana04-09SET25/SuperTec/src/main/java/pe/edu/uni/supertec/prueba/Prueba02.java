package pe.edu.uni.supertec.prueba;

import pe.edu.uni.supertec.dto.AlumnoDto;
import pe.edu.uni.supertec.service.AppService;

public class Prueba02 {

	public static void main(String[] args) {
		// Dato
		AlumnoDto bean = new AlumnoDto("GUSTAVO", 15, 20, 12, 18, 0);
		// Proceso
		AppService appService = new AppService();
		appService.addAlumno(bean);
		AlumnoDto lista[] = appService.getListado();
		// Reporte
		for (AlumnoDto dto : lista) {
			System.out.println(dto);
		}
	}

	
}
