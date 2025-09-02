package pe.edu.uni.pagoapp.dto;

public class PagoDto {

	// DATOS
	private int horasDia;
	private int dias;
	private double pagoHora;

	// REPORTE
	private double ingresoBruto;
	private double renta;
	private double ingresoNeto;

	public int getHorasDia() {
		return horasDia;
	}
	
	// CONSTRUCTURES

	public PagoDto() {
	}

	public PagoDto(int horasDia, int dias, double pagoHora) {
		this.horasDia = horasDia;
		this.dias = dias;
		this.pagoHora = pagoHora;
	}
	
		
	// GETTERS AND SETTERS
	
	public void setHorasDia(int horasDia) {
		this.horasDia = horasDia;
	}

	public int getDias() {
		return dias;
	}

	public void setDias(int dias) {
		this.dias = dias;
	}

	public double getPagoHora() {
		return pagoHora;
	}

	public void setPagoHora(double pagoHora) {
		this.pagoHora = pagoHora;
	}

	public double getIngresoBruto() {
		return ingresoBruto;
	}

	public void setIngresoBruto(double ingresoBruto) {
		this.ingresoBruto = ingresoBruto;
	}

	public double getRenta() {
		return renta;
	}

	public void setRenta(double renta) {
		this.renta = renta;
	}

	public double getIngresoNeto() {
		return ingresoNeto;
	}

	public void setIngresoNeto(double ingresoNeto) {
		this.ingresoNeto = ingresoNeto;
	}

	

}
