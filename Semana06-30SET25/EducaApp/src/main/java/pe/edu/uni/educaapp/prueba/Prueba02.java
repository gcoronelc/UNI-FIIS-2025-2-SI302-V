package pe.edu.uni.educaapp.prueba;

import pe.edu.uni.educaapp.service.EducaService;

public class Prueba02 {

	public static void main(String[] args) {
		try {
			// Datos
			int idCurso = 3;
			// Proceso
			EducaService service = new EducaService();
			double precio = service.consultarPrecio(idCurso);
			// Reporte
			System.out.println("Precio: " + precio);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
}
