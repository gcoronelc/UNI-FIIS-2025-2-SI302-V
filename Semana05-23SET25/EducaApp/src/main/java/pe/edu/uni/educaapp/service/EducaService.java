package pe.edu.uni.educaapp.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	

	
}
