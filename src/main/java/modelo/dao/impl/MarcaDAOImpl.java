package modelo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import modelo.conexion.ConnectionManager;
import modelo.dao.MarcaDAO;
import modelo.pojo.Marca;
import modelo.pojo.Perfume;

public class MarcaDAOImpl implements MarcaDAO {
	
	private final static Logger LOG = Logger.getLogger(MarcaDAOImpl.class);
	private static MarcaDAOImpl INSTANCE = null;
	
	private MarcaDAOImpl() {
		super();
	}
	
	public static synchronized MarcaDAOImpl getInstance() {
		
		if (INSTANCE == null) {
			INSTANCE = new MarcaDAOImpl();
		}
		return INSTANCE;
	}
	
	// excuteQuery => ResultSet
	private final String SQL_GET_ALL = "SELECT id, nombre FROM marca ORDER BY nombre ASC;";
	
	
	@Override
	public ArrayList<Marca> getAll() {
		ArrayList<Marca> marcas = new ArrayList<Marca>();
		
		try (	Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_GET_ALL);
				ResultSet rs = pst.executeQuery();){
			LOG.debug(pst);
			while (rs.next()) {
			
				//guardo en el arraylist con su id
				marcas.add(mapper(rs));
			}	
		} catch (Exception e) {
			LOG.error(e);
		}
		return marcas;
	}

	// TODO implementar estos metodos cuando necesitemos
	
	@Override
	public Marca getById(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Marca delete(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Marca insert(Marca pojo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Marca update(Marca pojo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Marca mapper(ResultSet rs) throws SQLException {
		Marca marca = new Marca();
		
		marca.setId(rs.getInt("id"));
		marca.setNombre(rs.getString("nombre"));
		
		return marca;
	}

}
