package pe.edu.uni.educa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatriculaDto {

    private int idCurso;
    private int idAlumno;
    private String tipo;
    private int cuotas;
    private double precio;
    private String estado;



}
