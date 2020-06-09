package modelo.pojo;

public class Perfume {
	
	private int id;
	private String nombre;
	private int ml;
	private String imagen;
	
	//constructor
	public Perfume() {
		super();
		this.id = 0;
		this.nombre = "";
		this.ml = 0;
		this.imagen = "https://cdn2.dineroenimagen.com/media/dinero/styles/gallerie/public/images/2019/04/perfume-px.jpg";
	}

	
	public String getImagen() {
		return imagen;
	}


	public void setImagen(String imagen) {
		this.imagen = imagen;
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
		return "Perfume [id=" + id + ", nombre=" + nombre + ", ml=" + ml + ", imagen=" + imagen + "]";
	}
	
	
	
	

}
