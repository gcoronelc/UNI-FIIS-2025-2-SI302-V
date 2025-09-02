package pe.edu.uni.pagoapp.controller;

import pe.edu.uni.pagoapp.dto.PagoDto;
import pe.edu.uni.pagoapp.service.PagoService;

public class PagoController {

	private PagoService pagoService;

	public PagoController() {
		pagoService = new PagoService();
	}

	public PagoDto procesarPago(PagoDto bean) {
		return pagoService.procesarPago(bean);
	}

}
