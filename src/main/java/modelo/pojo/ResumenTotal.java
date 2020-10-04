package modelo.pojo;

public class ResumenTotal {
	
	private int perfumesAprobados;
	private int perfumesPendientes;
	private int perfumesTotal;
	private int marcasTotal;
	private int usuariosTotal;
	
	
	public ResumenTotal() {
		super();
		this.perfumesAprobados = 0;
		this.perfumesPendientes = 0;
		this.perfumesTotal = 0;
		this.marcasTotal = 0;
		this.usuariosTotal = 0;
	}


	public int getMarcasTotal() {
		return marcasTotal;
	}


	public void setMarcasTotal(int marcasTotal) {
		this.marcasTotal = marcasTotal;
	}


	public int getUsuariosTotal() {
		return usuariosTotal;
	}


	public void setUsuariosTotal(int usuariosTotal) {
		this.usuariosTotal = usuariosTotal;
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
		return "ResumenTotal [perfumesAprobados=" + perfumesAprobados + ", perfumesPendientes=" + perfumesPendientes
				+ ", perfumesTotal=" + perfumesTotal + ", marcasTotal=" + marcasTotal + ", usuariosTotal="
				+ usuariosTotal + "]";
	}
	
	
	

}
