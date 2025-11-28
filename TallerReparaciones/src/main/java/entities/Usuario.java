package entities;

public class Usuario {
	private int id_usuario;
	private String nombre_usuario;
	private int password;
	private String rol;
	private int dni_usuario;
	
	public Usuario (int id_usuario, String nombre_usuario, int password, String rol, int dni_usuario) {
		this.setDni_usuario(id_usuario);
		this.setNombre_usuario(nombre_usuario);
		this.setPassword(password);
		this.setRol(rol);
		this.setDni_usuario(dni_usuario);
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password2) {
		this.password = password2;
	}

	public int getDni_usuario() {
		return dni_usuario;
	}

	public void setDni_usuario(int dni_usuario) {
		this.dni_usuario = dni_usuario;
	}

}
