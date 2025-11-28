package dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import dao.DBConnection;
import dao.interfaces.ReparacionDAO;
import dwes.maven.mysql.PasswordUtils;
import entities.Reparacion;

public class ReparacionDAOMySQL implements ReparacionDAO{

	private Connection conexion;
	
	public ReparacionDAOMySQL() {
		conexion = DBConnection.getInstance().getConnection();
	}
	

	@Override
	public int insert(Reparacion c) {
		try {
			// PreparedStatement
			String sql = "INSERT INTO Reparacion (id_reparacion, vehiculo, descripcion, email, fechaEntrada, costeEstimado, estado) VALUES(?, ?, ?, ?, ?, ?, ?);";
			PreparedStatement pst = conexion.prepareStatement(sql);
			pst.setInt(1, 1); // posicion 1, valor 1
			pst.setString(2, "virginia");
			pst.setInt(3, 35);
			pst.setString(4, "123456789");
			LocalDate fechaToday = LocalDate.now();
			pst.setDate(5, java.sql.Date.valueOf(fechaToday));
			pst.setString(6, PasswordUtils.hashPassword("dwes123"));
			
			
			int resul = pst.executeUpdate();
			System.out.println("resultado de inserccion:" + resul);
		} catch (SQLException e) {
			System.out.println("> NOK:" + e.getMessage());
		}
		return 0;

	}

	@Override
	public int update(Reparacion c) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Reparacion c) {
		String sqlDelete = "DELETE FROM Persona WHERE id_repacion = ?;";
		try {
			PreparedStatement pst = conexion.prepareStatement(sqlDelete);
			pst.setInt(1, 1); // borrar id
			int filas = pst.executeUpdate();
			
			if (filas > 0) {
				System.out.println("> OK. Persona con id 1 eliminada correctamente.");
			} else {
				System.out.println("> NOK. Persona con id 1 no se encuentra en la base de datos.");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
				return 0;
	}

	@Override
	public ArrayList<Reparacion> findall() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reparacion findBy(String dni) {
		// TODO Auto-generated method stub
		return null;
	}

}
