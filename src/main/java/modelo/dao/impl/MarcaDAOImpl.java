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
	private final String SQL_GET_BY_ID = "SELECT id, nombre FROM marca WHERE  id = ?;";
	
	// excecuteUpdate => AffectedRows (numero de filas afectadas)
	private final String SQL_INSERT = "INSERT INTO marca (nombre) VALUES (?);";
	private final String SQL_UPDATE = "UPDATE marca SET nombre = ? WHERE id = ?;";
	private final String SQL_DELETE = "DELETE FROM marca WHERE id = ?;";
	
	
	
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
	
	@Override
	public Marca getById(int id) throws Exception {
		Marca marca = new Marca();
		
		try (	Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_GET_BY_ID);) {
			
			pst.setInt(1, id);
			LOG.debug(pst);
			try (ResultSet rs = pst.executeQuery();){
				if (rs.next()) {
					marca = mapper(rs);
				}else {
					throw new Exception ("No se puede encontrar el registro con id=" + id);
				}
			}
			
		} catch (Exception e) {
			LOG.error(e);
		}
		return marca;
	}

	@Override
	public Marca delete(int id) throws Exception {
		// del listado de marcas, conseguir el id del que deseamos eliminar
		Marca marca = getById(id);
	
try (	Connection conexion = ConnectionManager.getConnection();
		PreparedStatement pst = conexion.prepareStatement(SQL_DELETE);) {

		pst.setInt(1, id);
		LOG.debug(pst);
		int affectedRows = pst.executeUpdate();

		if (affectedRows != 1) {
			throw new Exception("No se pude eliminar el registro id=" + id);
			}
		}

		return marca;
	}

	@Override
	public Marca insert(Marca pojo) throws Exception {

		try (	Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS);) {

			
				pst.setString(1, pojo.getNombre());
				LOG.debug(pst);
				
				int affectedRows = pst.executeUpdate();
				if (affectedRows == 1) {
					// conseguir el ID que nos ha arrojado

				try (ResultSet rskeys = pst.getGeneratedKeys()) {
					if (rskeys.next()) {
						int id = rskeys.getInt(1);
						pojo.setId(id);
					}
				}

			} else {
				throw new Exception("No se ha podido guardar el registro" + pojo);
			}

		} catch (Exception e) {
			throw new Exception("No se ha podido guardar el perfume " + pojo.getNombre());
		}
		return pojo;
	}

	@Override
	public Marca update(Marca pojo) throws Exception {
		if (pojo == null) {
			throw new Exception("No se puede modificar si es null");
		}

		try (	Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_UPDATE)) {

			pst.setString(1, pojo.getNombre());
			pst.setInt(2, pojo.getId());
			LOG.debug(pst);
			int affectedRows = pst.executeUpdate();
			if (affectedRows != 1) {
				throw new Exception("No se ha podido eliminar el registro con id =" + pojo.getId());
			}

		} catch (SQLException e) { // excepcion mas especifica que "exception e"
			throw new Exception("El usuario " + pojo.getNombre() + " ya existe");
		}

		return pojo;
	}
	
	
	private Marca mapper(ResultSet rs) throws SQLException {
		Marca marca = new Marca();
		
		marca.setId(rs.getInt("id"));
		marca.setNombre(rs.getString("nombre"));
		
		return marca;
	}

}
