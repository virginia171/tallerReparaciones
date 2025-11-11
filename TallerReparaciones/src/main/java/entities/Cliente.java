package entities;
public class Cliente {

		private int id_cliente;
		private String nombre;
		private int telefono;
		private String email;

		public Cliente (int id_cliente, String nombre, int telefono, String email, int dni_cliente) {
			this.setId_cliente(id_cliente);
			this.setNombre(nombre);
			this.setTelefono(telefono);
			this.setEmail(email);
			this.setId_cliente(dni_cliente);
		}

		public int getTelefono() {
			return telefono;
		}

		public void setTelefono(int telefono) {
			this.telefono = telefono;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public int getId_cliente() {
			return id_cliente;
		}

		public void setId_cliente(int id_cliente) {
			this.id_cliente = id_cliente;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
		
		public static void mostrarPersona(Cliente c) {
			System.out.println("--------- Cliente ---------");
			System.out.println("> Persona id:" + c.getId_cliente());
			System.out.println("> Dame nombre:" + c.getNombre());
			System.out.println("> Dame el email:" + c.getEmail());
			System.out.println("> Dame el telefono:" + c.getTelefono());
		}
}
			

