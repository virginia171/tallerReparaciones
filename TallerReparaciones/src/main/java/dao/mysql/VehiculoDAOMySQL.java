package dao.mysql;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import dao.interfaces.VehiculoDAO;
import dwes.maven.mysql.ConexionJDBC;
import dwes.maven.mysql.PasswordUtils;
import entities.Vehiculo;

public class VehiculoDAOMySQL implements VehiculoDAO{

	Private Connection conexion;
	
	public VehiculoDAOMySQL() {
		conexion = DBConnection.getInstance().getConnection();
	}

	@Override
	public int insert(Vehiculo v) {
		try {
			// PreparedStatement
			String sql = "INSERT INTO Vehiculo (id_vehciulo, matricula, marca, modelo, cliente_id) VALUES(?, ?, ?, ?, ?);";
			PreparedStatement pst = conexion.prepareStatement(sql);
			pst.setInt(1, 1); // posicion 1, valor 1
			pst.setString(2, "Gonzalo");
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
		
	}

	@Override
	public int update(Vehiculo v) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Vehiculo v) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Vehiculo> findall() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vehiculo findBy(String dni) {
		// TODO Auto-generated method stub
		return null;
	}

}

