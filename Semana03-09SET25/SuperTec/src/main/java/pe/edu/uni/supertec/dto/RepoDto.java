package pe.edu.uni.supertec.dto;

public class RepoDto {

	private String concepto;
	private double valor;

	public RepoDto() {
	}

	public RepoDto(String concepto, double valor) {
		this.concepto = concepto;
		this.valor = valor;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		String repo = "(concepto:" + concepto;
		repo += "; Valor:" + valor + ")";
		return repo;
	}
	
	
}
