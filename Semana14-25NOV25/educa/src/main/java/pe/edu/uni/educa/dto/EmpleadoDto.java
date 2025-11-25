package pe.edu.uni.educa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpleadoDto {

    private String id         ;
    private String apellido   ;
    private String nombre     ;
    private String direccion  ;
    private String email      ;
    private String usuario    ;
    private String clave      ;

}
