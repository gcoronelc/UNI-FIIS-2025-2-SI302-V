package pe.edu.uni.educa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class ConsultasService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public double precioCurso(int idCurso){
        String sql = "select cur_precio from CURSO where cur_id = ?";
        Double precio = jdbcTemplate.queryForObject(sql, Double.class, idCurso);
        return precio;
    }


    public int matriculados(int idCurso){
        // Validar codigo
        if(!this.existeCurso(idCurso)){
            throw new RuntimeException("No existe el codigo del curso");
        }
        // Proceso
        String sql = "select COUNT(1) matriculados from MATRICULA where cur_id=?";
        Integer matriculados = jdbcTemplate.queryForObject(sql, Integer.class, idCurso);
        return matriculados;
    }


    private boolean existeCurso(int idCurso){
        String sql = "select COUNT(1) contador from CURSO where cur_id=?";
        Integer contador = jdbcTemplate.queryForObject(sql, Integer.class, idCurso);
        return (contador==1);
    }
}
