package pe.edu.uni.educaapp.dto;

public class MatDto {

	// Datos entrada
	private int idCurso;
	private int IdAlumno;
	private int idEmpleado;
	private String tipo;
	private int cuotas;

	// Datos salida
	private int estado;
	private String mensaje;

	public MatDto() {
	}

	public MatDto(int idCurso, int IdAlumno, int idEmpleado, String tipo, int cuotas) {
		this.idCurso = idCurso;
		this.IdAlumno = IdAlumno;
		this.idEmpleado = idEmpleado;
		this.tipo = tipo;
		this.cuotas = cuotas;
	}

	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public int getIdAlumno() {
		return IdAlumno;
	}

	public void setIdAlumno(int IdAlumno) {
		this.IdAlumno = IdAlumno;
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getCuotas() {
		return cuotas;
	}

	public void setCuotas(int cuotas) {
		this.cuotas = cuotas;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
