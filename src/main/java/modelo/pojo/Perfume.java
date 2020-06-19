package modelo.pojo;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class Perfume {
	
	private int id;
	
	@NotBlank
	@Size( min = 2, max = 100, message = "Debe contener entre 2 y 100 caracteres")
	private String nombre;
	
	@Min( value = 5, message = "El formato del perfume no debe ser inferior a 5 ml (muestra)")
	private int ml;
	
	@NotBlank(message = "Se debe ingresar la URL de la  imagen")
	private String imagen;
	
	
	//constructor
	public Marca marca;
	
	public Perfume() {
		super();
		this.id = 0;
		this.nombre = "";
		this.ml = 0;
		this.imagen = "https://cdn2.dineroenimagen.com/media/dinero/styles/gallerie/public/images/2019/04/perfume-px.jpg";
		this.marca = new Marca();
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
	

	public Marca getMarca() {
		return marca;
	}


	public void setMarca(Marca marca) {
		this.marca = marca;
	}


	@Override
	public String toString() {
		return "Perfume [id=" + id + ", nombre=" + nombre + ", ml=" + ml + ", imagen=" + imagen + ", marca=" + marca
				+ "]";
	}
	
	
	
	

}
