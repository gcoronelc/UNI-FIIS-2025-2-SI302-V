package pe.edu.uni.educaapp.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import pe.edu.uni.educaapp.MatDto;
import pe.edu.uni.educaapp.db.AccesoDB;

public class EducaService {
	
	
	public double consultarPrecio(int idCurso){
		String sql_select = """
                      select cur_precio precio 
                      from CURSO where cur_id=?
                      """;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		double precio = 0.0;
		try {
			cn = AccesoDB.getConnection();
			pstm = cn.prepareStatement(sql_select);
			pstm.setInt(1, idCurso);
			rs = pstm.executeQuery();
			if(!rs.next()){
				throw new SQLException("Curso no existe.");
			}
			precio = rs.getDouble("precio");
			rs.close();
			pstm.close();
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		} catch (Exception e) {
			throw new RuntimeException("Error en el proceso.!!!");
		} finally{
			try {
				cn.close();
			} catch (Exception e) {
			}
		}
		return precio;
	}
	
	public List<Map<String,?>> consultaFinanciera(){
		String query = """
                 with 
                 mat as (
                 	select 
                 		cur_id id,
                 		COUNT(1) matriculados,
                 		SUM(mat_precio) proyectado
                 	from MATRICULA
                 	group by cur_id
                 ),
                 rec as (
                 	select 
                 		cur_id id,
                 		SUM(pag_importe) recaudado
                 	from pago
                 	group by cur_id
                 )
                 select
                 	mat.id, c.cur_nombre nombre,
                 	mat.matriculados, mat.proyectado,
                 	ISNULL(rec.recaudado,0.0) recaudado,
                 	(mat.proyectado - ISNULL(rec.recaudado,0.0)) deuda
                 from curso c
                 join mat on c.cur_id = mat.id
                 left join rec on mat.id = rec.id
                 """;
		Connection cn = null;
		List<Map<String,?>> lista = null;
		PreparedStatement pstm;
		ResultSet rs;
		try {
			cn = AccesoDB.getConnection();
			pstm = cn.prepareStatement(query);
			rs = pstm.executeQuery();
			lista = JdbcUtil.rsToList(rs);
			rs.close();
			pstm.close();
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		} catch(Exception e){
			throw new RuntimeException("Error en el proceso");
		}finally{
			try {
				cn.close();
			} catch (Exception e) {
			}
		}
		return lista;
	}

	public MatDto matricular(MatDto bean){
		Connection cn = null;
		PreparedStatement pstm;
		ResultSet rs;
		String sql;
		int cont, filas;
		try {
			// INICIO
			cn = AccesoDB.getConnection();
			cn.setAutoCommit(false); // Inicio de Tx
			// VALIDACIONES
			// Validar curso
			sql = """
                   select count(1) cont from CURSO
                   where cur_id=? 
                   and (cur_vacantes - cur_matriculados) > 0
				""";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, bean.getIdCurso());
			rs = pstm.executeQuery();
			rs.next();
			cont = rs.getInt("cont");
			rs.close();
			pstm.close();
			if(cont==0){
				throw new SQLException("No hay vacantes o curso no existe.");
			}
			
			
			
			// OPERACIONES
			// Actualizar curso
			sql = """
					Update CURSO
					set cur_matriculados = cur_matriculados + 1
					where cur_id=?
				""";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, bean.getIdCurso());
			filas = pstm.executeUpdate();
			pstm.close();
			if(filas == 0){
				throw new SQLException("Curso no existe.");
			}
			// Registrar la matricula
			sql = """
				insert into MATRICULA(cur_id,alu_id,emp_id,mat_tipo,
				mat_fecha,mat_precio,mat_cuotas)
				values(?,?,?,?,GETDATE(),?,?)
				""";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, bean.getIdCurso());
			pstm.setInt(2, bean.getIdAlumno());
			pstm.setInt(3, bean.getIdEmpleado());
			pstm.setString(4, bean.getTipo());
			pstm.setDouble(5, 1000.0);
			pstm.setDouble(6, bean.getCuotas());
			pstm.executeUpdate();
			pstm.close();
			// CONFIRMAR PROCESO
			bean.setEstado(1);
			bean.setMensaje("Proceso concluido.");
			cn.commit();
		} catch (SQLException e) {
			bean.setEstado(0);
			bean.setMensaje(e.getMessage());
			try {
				cn.rollback(); // Cancela la Tx
			} catch (Exception e1) {
			}
		} catch (Exception e) {
			bean.setEstado(0);
			bean.setMensaje("Error en el proceso.");
			try {
				cn.rollback(); // Cancela la Tx
			} catch (Exception e1) {
			}
		} finally{
			try {
				cn.close();
			} catch (Exception e) {
			}
		}
		return bean;
	}
	
}
