package entities;

public class Vehiculo {
	private int id_vehiculo;
	private String matricula;
	private int marca;
	private String modelo;
	private int cliente_id;
	
	
	public Vehiculo (int id_vehiculo, String matricula, int marca, String modelo, int cliente_id) {
		this.setId_vehiculo(id_vehiculo);
		this.setMatricula(matricula);
		this.setMarca(marca);
		this.setModelo(modelo);
		this.setCliente_id(cliente_id);
	}
	
	
	public int getId_vehiculo() {
		return id_vehiculo;
	}
	public void setId_vehiculo(int id_vehiculo) {
		this.id_vehiculo = id_vehiculo;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public int getMarca() {
		return marca;
	}
	public void setMarca(int marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getCliente_id() {
		return cliente_id;
	}
	public void setCliente_id(int cliente_id) {
		this.cliente_id = cliente_id;
	}

}
