package modelo.pojo;

public class Perfume {
	
	private int id;
	private String nombre;
	private int ml;
	
	//constructor
	public Perfume() {
		super();
		this.id = 0;
		this.nombre = "";
		this.ml = 0;
	}

	
	public int getMl() {
		return ml;
	}


	public void setMl(int ml) {
		this.ml = ml;
	}


	//Getters & Setters
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
		return "Perfume [id=" + id + ", nombre=" + nombre + ", ml=" + ml + "]";
	}
	
	
	
	

}
