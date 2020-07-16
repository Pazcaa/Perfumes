package modelo.pojo;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class Usuario {
	
	private int id;
	
	@NotBlank
	@Size(min = 3 , max = 100 , message = "Debe tener entre 3 y 100 caracteres")
	private String nombre;
	
	@Size(min = 4, max = 10, message = "debe contener entre 4 y 10 caracteres")
	private String password;
	
	@NotBlank(message = "Se debe ingresar la URL de la  imagen")
	private String imagen;
	
	private Rol rol;
	
	
	public Usuario() {
		super();
		this.id = 0;
		this.nombre = "";
		this.password = "";
		this.imagen = "https://p1.pxfuel.com/preview/790/280/868/596ed5870f859.jpg";
		this.rol = new Rol();
	}


	public int getId() {
		return id;
	}

	
	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getImagen() {
		return imagen;
	}


	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	

	public Rol getRol() {
		return rol;
	}


	public void setRol(Rol rol) {
		this.rol = rol;
	}



	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", password=" + password + ", imagen=" + imagen + ", rol="
				+ rol + "]";
	}

}
