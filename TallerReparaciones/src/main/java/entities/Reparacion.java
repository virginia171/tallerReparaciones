package entities;

public class Reparacion {
	private int id_reparacion;
	private String vehiculo;
	private String descripcion;
	private String email;
	private int fechaEntrada;
	private int costeEstimado;
	private String estado;
	
	public Reparacion (int id_reparacion, String vehiculo, String descripcion, String email, int fechaEntrada, int costeEstimado, String estado) {
		this.setId_reparacion(id_reparacion);
		this.setVehiculo(vehiculo);
		this.setDescripcion(descripcion);
		this.setEmail(email);
		this.setFechaEntrada(fechaEntrada);
		this.setCosteEstimado(costeEstimado);
		this.setEstado(estado);
	}

	public int getId_reparacion() {
		return id_reparacion;
	}

	public void setId_reparacion(int id_reparacion) {
		this.id_reparacion = id_reparacion;
	}

	public String getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(String vehiculo) {
		this.vehiculo = vehiculo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(int fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public int getCosteEstimado() {
		return costeEstimado;
	}

	public void setCosteEstimado(int costeEstimado) {
		this.costeEstimado = costeEstimado;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}


}
