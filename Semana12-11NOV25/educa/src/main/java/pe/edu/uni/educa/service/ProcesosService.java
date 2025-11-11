package pe.edu.uni.educa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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
        int filas;
        double precio;
        final String TIPOS = "REGULAR,BECA,MEDIABECA";
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
        // La matricula ya existe
        sql = "select COUNT(1) contador from MATRICULA ";
        sql += "where cur_id=? and alu_id=?";
        cont = jdbcTemplate.queryForObject(sql,Integer.class,bean.getIdCurso(),bean.getIdAlumno());
        if(cont==1){
            throw new RuntimeException("Matricula ya existe.");
        }
        // El tipo de matricula debe ser: REGULAR, MEDIABECA o BECA
        bean.setTipo(bean.getTipo().toUpperCase());
        if(TIPOS.indexOf(bean.getTipo()) == -1){
            throw new RuntimeException("Tipo de matricula es incorrecto.");
        }
        // La cantidad de cuotas
        if(bean.getCuotas()<1 || bean.getCuotas()>3){
            throw new RuntimeException("El numero de cuotas es incorrecto.");
        }
        if((bean.getTipo().equals("BECA") || bean.getTipo().equals("MEDIABECA")) && (bean.getCuotas()!=1)){
            throw new RuntimeException("El numero de cuotas debe ser 1.");
        }
        // ******************************
        // Proceso
        // ******************************
        // Actualizar curso
        sql = """
                update curso
                set cur_matriculados = cur_matriculados + 1
                where cur_id = ? and cur_matriculados < cur_vacantes
                """;
        filas = jdbcTemplate.update(sql, bean.getIdCurso());
        if(filas!=1){
            throw new RuntimeException("Error al actualizar el curso.");
        }
        // Obtener el precio del curso
        sql = "select cur_precio from CURSO where cur_id=?";
        precio = jdbcTemplate.queryForObject(sql, Double.class, bean.getIdCurso());
        bean.setPrecio(precio);
        // Insertar matricula
        sql = """
            insert into MATRICULA(cur_id,alu_id,emp_id,mat_tipo,mat_fecha,mat_precio,mat_cuotas)
            values(?,?,?,?,GETDATE(),?,?)
            """;
        Object[] parms = {
          bean.getIdCurso(), bean.getIdAlumno(),bean.getIdEmpleado(),
          bean.getTipo(),bean.getPrecio(), bean.getCuotas()
        };
        jdbcTemplate.update(sql, parms);
        bean.setEstado("Matricula exitosa confirmada.");
        return bean;
    }

}
