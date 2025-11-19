package dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import dao.DBConnection;
import dao.interfaces.ClienteDAO;
import dwes.maven.mysql.PasswordUtils;
import entities.Cliente;

public class ClienteDAOMySQL implements ClienteDAO{
	
		private Connection conexion;
		
		public ClienteDAOMySQL() {
			conexion = DBConnection.getInstance().getConnection();
		}
		
	
	@Override
	public int insert(Cliente c) {
		try {
			// PreparedStatement
			String sql = "INSERT INTO Cliente (id_cliente, nombre, telefono, email, dni_cliente) VALUES(?, ?, ?, ?, ?);";
			PreparedStatement pst = conexion.prepareStatement(sql);
			pst.setInt(1, 1); // posicion 1, valor 1
			pst.setString(2, "Gonzalo");
			pst.setInt(3, 35);
			pst.setString(4, "123456789");
			pst.setString(6, "123456789@");
			pst.setString(6, PasswordUtils.hashPassword("dwes123"));
			
			
			int resul = pst.executeUpdate();
			System.out.println("resultado de inserccion:" + resul);
		} catch (SQLException e) {
			System.out.println("> NOK:" + e.getMessage());
		}
		return 0;
	}

	@Override
	public int update(Cliente c) {
		try {
			ResultSet resultado = null;
			conexion.setAutoCommit(false);
			String sql = "SELECT id_cliente, nombre, telefono, email, dni_cliente FROM persona WHERE dni_cliente > ?";
			PreparedStatement pst = conexion.prepareStatement(
					sql,
					ResultSet.TYPE_SCROLL_SENSITIVE, // Sensible a cambios
					ResultSet.CONCUR_UPDATABLE); // Permite modificar
			
			pst.setInt(1, 15);
			resultado = pst.executeQuery();
			
			while (resultado.next()) {
				String nombre = resultado.getString("nombre");
				int edadActual = resultado.getInt("edad");
				resultado.updateInt("edad", edadActual + 5);
				resultado.updateRow();
				System.out.println("> La edad de la persona " + nombre + " se modificado a " +  resultado.getInt("edad"));
			}
			
			conexion.commit();
			System.out.println("> Cambios confirmados correctamente");
			
		} catch (SQLException e) {
			if (conexion != null) {
				try {
					conexion.rollback();
					System.out.println("> Cambios confirmados correctamente");
				} catch (SQLException e1) {
					System.out.println("> NOK:" + e.getMessage());
				}
				
			}
		} 
		finally {
			if (conexion != null) {
				try {
					conexion.setAutoCommit(true);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return 0;
	}

	@Override
	public int delete(Cliente c) {
		String sqlDelete = "DELETE FROM Cliente WHERE id_cliente = ?;";
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
	public ArrayList<Cliente> findall() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente findBy(String dni) {
		// TODO Auto-generated method stub
		return null;
	}

}
