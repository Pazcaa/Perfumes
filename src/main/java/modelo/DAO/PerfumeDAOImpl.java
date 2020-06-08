package modelo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.conexion.ConnectionManager;
import modelo.pojo.Perfume;

public class PerfumeDAOImpl implements PerfumeDAO{
	
	//patrón singleton
	private static PerfumeDAOImpl INSTANCE = null;
	
	//constructor del INSTANCE
	public PerfumeDAOImpl() {
		super();
	}

	//metodo del INSTANCE
	public static synchronized PerfumeDAOImpl getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new PerfumeDAOImpl();
		}
		
		return INSTANCE;
	}
	
	// executeQUery => ResultSet
		private final String SQL_GET_ALL 		= "SELECT id, nombre, ml FROM perfume ORDER BY id DESC;";
	
	
	@Override
	public ArrayList<Perfume> getAll() {
		ArrayList<Perfume> perfumes = new ArrayList<Perfume>();
		
	try (	Connection conexion = ConnectionManager.getConnection();
			PreparedStatement pst = conexion.prepareStatement(SQL_GET_ALL);
			ResultSet rs = pst.executeQuery();){
		
		while (rs.next()) {
		
			//guardo en el arraylist con su id
			perfumes.add(mapper(rs));
			
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
		
		return perfumes;
	}


	@Override
	public Perfume getById(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Perfume delete(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Perfume insert(Perfume pojo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Perfume update(Perfume pojo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	private Perfume mapper(ResultSet rs) throws SQLException {
		
		Perfume perfume = new Perfume();
		
		//recupero columnas de resultados y creo pojo para su uso
		perfume.setId(rs.getInt("id"));
		perfume.setNombre(rs.getString("nombre"));
		perfume.setMl(rs.getInt("ml"));
		
		return perfume;
		
	}
}
