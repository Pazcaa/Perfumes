package modelo.pojo;

public class Message {

	private String tipo;
	private String texto;
	
	public Message() {
		super();
		this.tipo = "";
		this.texto = "";
	}
	
	public Message(String tipo, String texto) {
		this();
		this.tipo = tipo;
		this.texto = texto;
	}



	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	@Override
	public String toString() {
		return "Message [tipo=" + tipo + ", texto=" + texto + "]";
	}
	
	
	
	
	
	
	
	
	
}
