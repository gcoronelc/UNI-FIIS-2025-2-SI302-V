package pe.edu.uni.supertec.service;

import pe.edu.uni.supertec.dto.AlumnoDto;
import pe.edu.uni.supertec.dto.RepoDto;

public class AppService {

	public AlumnoDto[] getListado() {
		/*
		AlumnoDto[] repo = new AlumnoDto[Data.filas];
		for (int i = 0; i < Data.filas; i++) {
			repo[i] = Data.tabla[i];
		}
		 */
		AlumnoDto[] repo = new AlumnoDto[Data.filas];;
		System.arraycopy(Data.tabla, 0, repo, 0, Data.filas);
		return repo;
	}

	public void addAlumno(AlumnoDto bean) {
		bean.setPromedio(calcPromedio(bean.getNota1(), bean.getNota2(), bean.getNota3(), bean.getNota4()));
		Data.tabla[Data.filas] = bean;
		Data.filas++;
	}

	private int calcPromedio(int nota1, int nota2, int nota3, int nota4) {
		int menor = Math.min(nota1, nota2);
		menor = Math.min(menor, nota3);
		menor = Math.min(menor, nota4);
		int pr = (nota1 + nota2 + nota3 + nota4 - menor) / 3;
		return pr;
	}

	public RepoDto[] getEstadistica() {
		RepoDto[] reporte = {
			new RepoDto("Promedio", aulaPromedio()),
			new RepoDto("Nota mayor", aulaNotaMayor()),
			new RepoDto("Nota menor", aulaNotaMenor()),
			new RepoDto("Aprobados", aulaAprobados()),
			new RepoDto("Desaprobados", aulaDesaprobados())
		};
		return reporte;
	}

	private double aulaPromedio() {
		
		return 0.0;
	}

	private double aulaNotaMayor() {
		int notaMayor = Data.tabla[0].getPromedio();
		for (int i=1; i < Data.filas; i++) {
			if(notaMayor < Data.tabla[i].getPromedio()){
				notaMayor = Data.tabla[i].getPromedio();
			}
		}
		return notaMayor;
	}


	private double aulaAprobados() {
		return 0.0;
	}
	private double aulaDesaprobados() {
		return 0.0;
	}

	
	private double aulaNotaMenor() {
		int notaMenor = Data.tabla[0].getPromedio();
		for (int i=1; i < Data.filas; i++) {
			if(notaMenor > Data.tabla[i].getPromedio()){
				notaMenor = Data.tabla[i].getPromedio();
			}
		}
		return notaMenor;
	}


}
