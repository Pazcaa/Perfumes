package modelo.pojo;

public class ResumenUsuario {
	
	private int idUsuario;
	private int perfumesTotal;
	private int perfumesAprobados;
	private int perfumesPendientes;
	
	
	public ResumenUsuario() {
		super();
		// los this. no estan hechos, porque por defento el valor de un int es cero
	}


	public int getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}


	public int getPerfumesTotal() {
		return perfumesTotal;
	}


	public void setPerfumesTotal(int perfumesTotal) {
		this.perfumesTotal = perfumesTotal;
	}


	public int getPerfumesAprobados() {
		return perfumesAprobados;
	}


	public void setPerfumesAprobados(int perfumesAprobados) {
		this.perfumesAprobados = perfumesAprobados;
	}


	public int getPerfumesPendientes() {
		return perfumesPendientes;
	}


	public void setPerfumesPendientes(int perfumesPendientes) {
		this.perfumesPendientes = perfumesPendientes;
	}


	@Override
	public String toString() {
		return "ResumenUsuario [idUsuario=" + idUsuario + ", perfumesTotal=" + perfumesTotal + ", perfumesAprobados="
				+ perfumesAprobados + ", perfumesPendientes=" + perfumesPendientes + "]";
	}
	
	

}
