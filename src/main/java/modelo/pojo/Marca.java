package modelo.pojo;

public class Marca {
	
	private int id;
	private String nombre;
	
	//constructor
	public Marca() {
		super();
		this.id = 0;
		this.nombre = "";
	}
	
	//Getters & setters
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

	//toString
	@Override
	public String toString() {
		return "Marca [id=" + id + ", nombre=" + nombre + "]";
	}
	
	
	
	
	

}
