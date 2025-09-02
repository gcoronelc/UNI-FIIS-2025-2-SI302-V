package pe.edu.uni.pagoapp.prueba;

import pe.edu.uni.pagoapp.dto.PagoDto;
import pe.edu.uni.pagoapp.service.PagoService;

public class Prueba01 {

	public static void main(String[] args) {
		// Datos
		int dias = 5;
		int horasDia = 6;
		double pagoHoras = 20;
		// Proceso
		/*
		PagoDto bean = new PagoDto();
		bean.setDias(dias);
		bean.setHorasDia(horasDia);
		bean.setPagoHora(pagoHoras);
		*/
		PagoDto bean = new PagoDto(horasDia, dias, pagoHoras);
		PagoService pagoService = new PagoService();
		bean = pagoService.procesarPago(bean);
		// Reporte
		System.out.println("Ingres bruto: " + bean.getIngresoBruto());
		System.out.println("Renta (8%): " + bean.getRenta());
		System.out.println("Ingres neto: " + bean.getIngresoNeto());
	}

	
}
