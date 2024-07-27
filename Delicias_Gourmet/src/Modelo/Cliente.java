package Modelo;

public class Cliente {

	// Variables de la clase
	private int id;
	private String nombre;
	private String telefono;
	private String email;
	private String contrasenia;

	// Constructor
	public Cliente() {
	}

	// Set y get de id
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// Set y get de nombre
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	// Set y get de telefono
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	// Set y get de mail
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// Set y get de contraseña
	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
}
