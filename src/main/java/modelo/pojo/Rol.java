package modelo.pojo;

import org.hibernate.validator.constraints.NotBlank;

public class Rol {
	
	public static final int ADMIN = 2;
	public static final int USUARIO = 1;
	
	private int id;
	
	@NotBlank
	private String nombre;
	
	
	
	public Rol() {
		super();
		this.id = 0;
		this.nombre = "";
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



	@Override
	public String toString() {
		return "Rol [id=" + id + ", nombre=" + nombre + "]";
	}
	
	
	

}
