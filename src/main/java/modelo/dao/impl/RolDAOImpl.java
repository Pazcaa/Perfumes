package modelo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import modelo.conexion.ConnectionManager;
import modelo.dao.RolDAO;
import modelo.pojo.Rol;
import modelo.pojo.Usuario;

public class RolDAOImpl implements RolDAO {
	
	private final static Logger LOG = Logger.getLogger(RolDAOImpl.class);
	private static RolDAOImpl INSTANCE = null;//patron singleton
	
	public RolDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//metodo del INSTANCE
	public static synchronized RolDAOImpl getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new RolDAOImpl();
		}
		
		return INSTANCE;
			
		}
	
	// executeQUery => ResultSet
	private final String SQL_GET_ALL 		= " SELECT id, nombre FROM rol ORDER BY id ASC LIMIT 500;";

	@Override
	public ArrayList<Rol> getAll() {
		ArrayList<Rol> roles = new ArrayList<Rol>();
		
		try (	Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_GET_ALL);
				ResultSet rs = pst.executeQuery()){
			
			LOG.debug(pst);
			while (rs.next()) {
				//guardo cada "rs" en el arraylist
				roles.add(mapper(rs));
			}
			
		} catch (Exception e) {
			LOG.error(e);
		}
		return roles;
	}

	@Override
	public Rol getById(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rol delete(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rol insert(Rol pojo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rol update(Rol pojo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Rol mapper (ResultSet rs) throws SQLException {
		Rol rol = new Rol();
		
		//recupero columnas de resultados y creo pojo para su uso
		rol.setId(rs.getInt("id"));
		rol.setNombre(rs.getString("nombre"));
		
		return rol;
	}
}
