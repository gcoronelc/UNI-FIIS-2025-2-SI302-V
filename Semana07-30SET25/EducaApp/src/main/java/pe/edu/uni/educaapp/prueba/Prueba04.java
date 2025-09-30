package pe.edu.uni.educaapp.prueba;

import java.util.List;
import java.util.Map;
import pe.edu.uni.educaapp.service.EducaService;

public class Prueba04 {
	
	public static void main(String[] args) {
		EducaService service = new EducaService();
		List<Map<String,?>> lista = service.consultaFinanciera();
		
		for (Map<String, ?> r : lista) {
			System.out.print(r.get("ID").toString() + "\t");
			System.out.print(r.get("NOMBRE").toString() + "\t");
			System.out.print(r.get("MATRICULADOS").toString() + "\t");
			System.out.print(r.get("PROYECTADO").toString() + "\t");
			System.out.print(r.get("RECAUDADO").toString() + "\t");
			System.out.println(r.get("DEUDA").toString());
		}
		
		
	}
}
