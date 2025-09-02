package pe.edu.uni.pagoapp.service;

import pe.edu.uni.pagoapp.dto.PagoDto;

public class PagoService {

	public PagoDto procesarPago(PagoDto bean){
		// Datos
		int horasDia = bean.getHorasDia();
		int dias = bean.getDias();
		double pagoHora = bean.getPagoHora();
		// Proceso
		double ingresoBruto = horasDia * dias * pagoHora;
		double renta = ingresoBruto * (ingresoBruto>1500.00?0.08:0.0);
		double ingresoNeto = ingresoBruto - renta;
		// Reporte
		bean.setIngresoBruto(ingresoBruto);
		bean.setRenta(renta);
		bean.setIngresoNeto(ingresoNeto);
		return bean;
	}

	
	
}
