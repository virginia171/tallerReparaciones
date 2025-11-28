package dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import dao.DBConnection;
import dao.interfaces.UsuarioDAO;
import dwes.maven.mysql.PasswordUtils;
import entities.Usuario;

public class UsuarioDAOMySQL implements UsuarioDAO  {

	private Connection conexion;
	
	public UsuarioDAOMySQL() {
		conexion = DBConnection.getInstance().getConnection();
	}
	
	 
	@Override
	public int insert(Usuario c) {
		try {
			// PreparedStatement
			String sql = "INSERT INTO Usuario (id_usuario, nombre_Usuario, password, rol, dni_usuario) VALUES(?, ?, ?, ?, ?);";
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
		return 0;
		
	}

	@Override
	public int update(Usuario c) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Usuario c) {
		String sqlDelete = "DELETE FROM Usuario WHERE id_usuario = ?;";
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
	public ArrayList<Usuario> findall() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario findBy(String dni) {
		// TODO Auto-generated method stub
		return null;
	}

}
