package pe.edu.uni.educaapp.prueba;

import pe.edu.uni.educaapp.MatDto;
import pe.edu.uni.educaapp.service.EducaService;

/**
 * Curso no existe
 * @author Usuario
 */
public class Prueba0502 {

	public static void main(String[] args) {
		// Datos
		MatDto bean = new MatDto();
		bean.setIdCurso(5);
		bean.setIdAlumno(7);
		bean.setIdEmpleado(2);
		bean.setTipo("REGULAR");
		bean.setCuotas(1);
		// Proceso
		EducaService service = new EducaService();
		service.matricular(bean);
		// Reporte
		System.out.println("Estado: " + bean.getEstado());
		System.out.println("Mensaje: " + bean.getMensaje());
		
	}

	
}
