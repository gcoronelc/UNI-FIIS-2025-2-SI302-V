package pe.edu.uni.educa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import pe.edu.uni.educa.dto.EmpleadoDto;
import pe.edu.uni.educa.dto.UsuarioDto;

@Service
public class LogonService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public EmpleadoDto validar(UsuarioDto bean){
        String sql = """
                select emp_id id, emp_apellido apellido, emp_nombre nombre,
                emp_email email, emp_usuario usuario, '*****' clave
                from empleado
                where emp_usuario=? and emp_clave=?
                """;
        EmpleadoDto empDto;
        try {
            empDto = jdbcTemplate.queryForObject(sql,
                    BeanPropertyRowMapper.newInstance(EmpleadoDto.class),
                    bean.getUsuario(), bean.getClave());
        } catch (EmptyResultDataAccessException e) {
            throw new RuntimeException("Datos incorrectos");
        }
        return empDto;
    }

}
