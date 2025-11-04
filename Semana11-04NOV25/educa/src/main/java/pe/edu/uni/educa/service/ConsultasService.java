package pe.edu.uni.educa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

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

    public List<Map<String, Object>> listaMatriculados(int idCurso){
        // Validar codigo
        if(!this.existeCurso(idCurso)){
            throw new RuntimeException("No existe el codigo del curso");
        }
        // Proceso
        String sql = """
                select
                	m.cur_id idCurso, m.alu_id idAlumno,
                	a.alu_nombre nombre, m.mat_tipo tipo,
                	m.mat_precio precio, m.mat_cuotas cuotas,
                	m.mat_nota nota
                from MATRICULA m
                join ALUMNO a on m.alu_id = a.alu_id
                where m.cur_id = ?
                """;
        List<Map<String,Object>> lista = jdbcTemplate.queryForList(sql, idCurso );
        return lista;
    }


}
