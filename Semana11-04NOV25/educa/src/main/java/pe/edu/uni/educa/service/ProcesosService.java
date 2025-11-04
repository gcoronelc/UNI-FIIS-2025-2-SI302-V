package pe.edu.uni.educa.service;

import org.springframework.stereotype.Service;
import pe.edu.uni.educa.dto.MatriculaDto;

@Service
public class ProcesosService {

    public MatriculaDto matricular(MatriculaDto bean){

        bean.setPrecio(1000.00);
        bean.setEstado("Matricula exitosa.");

        return bean;

    }




}
