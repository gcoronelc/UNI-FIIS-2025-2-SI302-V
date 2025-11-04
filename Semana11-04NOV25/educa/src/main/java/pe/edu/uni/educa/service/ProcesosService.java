package pe.edu.uni.educa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.uni.educa.dto.MatriculaDto;

@Service
public class ProcesosService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(
            propagation = Propagation.REQUIRES_NEW,
            rollbackFor = Exception.class
    )
    public MatriculaDto matricular(MatriculaDto bean){
        // ******************************
        // Variables
        // ******************************
        String sql;
        int cont;
        // ******************************
        // Validaciones
        // ******************************
        // El codigo del curso debe existir
        sql = "select COUNT(1) contador from CURSO where cur_id = ?";
        cont = jdbcTemplate.queryForObject(sql,Integer.class,bean.getIdCurso());
        if(cont==0){
            throw new RuntimeException("El curso no existe.");
        }
        // El codigo del alumno no existe
        sql = "select COUNT(1) contador from ALUMNO where alu_id = ?";
        cont = jdbcTemplate.queryForObject(sql,Integer.class,bean.getIdAlumno());
        if(cont==0){
            throw new RuntimeException("El alumno no existe.");
        }


        // ******************************
        // Proceso
        // ******************************
        bean.setPrecio(1000.00);
        bean.setEstado("Matricula exitosa.");

        return bean;

    }

}
