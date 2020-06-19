package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.conexion.ConnectionManager;
import modelo.pojo.Marca;
import modelo.pojo.Perfume;

public class PerfumeDAOImpl implements PerfumeDAO{
	
	//patrón singleton
	private static PerfumeDAOImpl INSTANCE = null;
	
	//constructor del INSTANCE
	private PerfumeDAOImpl() {
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
		private final String SQL_GET_ALL 		= 	" SELECT " + 
													" p.id 		'perfume_id', " + 
													" p.nombre 	'perfume_nombre', " + 
													" ml," + 
													" imagen, " + 
													" m.id 		'marca_id', "+
													" m.nombre 	'marca_nombre' " + 
													" FROM perfume p, marca m " + 
													" WHERE p.id_marca = m.id  " + 
													" ORDER BY p.id DESC LIMIT 500; ";
		
											
		private final String SQL_GET_BY_ID 		= 	" SELECT " + 
													" p.id 'perfume_id', " + 
													" p.nombre 'perfume_nombre', " + 
													" ml, " + 
													" imagen, " + 
													" m.id 'marca_id', " + 
													" m.nombre 'marca_nombre' " + 
													" FROM perfume p, marca m " + 
													" WHERE p.id_marca = m.id  AND p.id = ?;";
		
		// excecuteUpdate => AffectedRows (numero de filas afectadas)
		private final String SQL_INSERT = "INSERT INTO perfume (nombre, ml, imagen, id_marca) VALUES ( ? ,?, ?, ?); ";
		private final String SQL_DELETE = "DELETE FROM perfume WHERE id = ? ; "; // si no escribo 'where id = ?' me cargo toda la lista!!!
		private final String SQL_UPDATE = "UPDATE perfume SET nombre = ?, ml = ?, imagen = ?, id_marca = ? WHERE id = ? ; ";		
	
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
		Perfume perfume = new Perfume();
		
		try (	Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_GET_BY_ID);) {
			
			pst.setInt(1, id);
			try (ResultSet rs = pst.executeQuery();){
				if (rs.next()) {
					perfume = mapper(rs);
				}else {
					throw new Exception ("No se puede encontrar el registro con id=" + id);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return perfume;
	}

	@Override
	public Perfume delete(int id) throws Exception {
		// del listado de perfumes, conseguir el id del que deseamos eliminar
				Perfume perfume = getById(id);
			
		try (	Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_DELETE);) {

				pst.setInt(1, id);
				int affectedRows = pst.executeUpdate();

				if (affectedRows != 1) {
					throw new Exception("No se pude eliminar el registro id=" + id);
					}
				}

				return perfume;
	}

	@Override
	public Perfume insert(Perfume pojo) throws Exception {
		
		try (	Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS);) {

			
				pst.setString(1, pojo.getNombre());
				pst.setInt(2, pojo.getMl());
				pst.setString(3, pojo.getImagen());
				pst.setInt(4, pojo.getMarca().getId());
				
				
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
	public Perfume update(Perfume pojo) throws Exception {
		if (pojo == null) {
			throw new Exception("No se puede modificar si es null");
		}

		try (	Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_UPDATE)) {

			pst.setString(1, pojo.getNombre());
			pst.setInt(2, pojo.getMl());
			pst.setString(3, pojo.getImagen());
			pst.setInt(4, pojo.getMarca().getId());
			pst.setInt(5, pojo.getId());

			int affectedRows = pst.executeUpdate();
			if (affectedRows != 1) {
				throw new Exception("No se ha podido eliminar el registro con id =" + pojo.getId());
			}

		} catch (SQLException e) { // excepcion mas especifica que "exception e"
			throw new Exception("El usuario " + pojo.getNombre() + " ya existe");
		}

		return pojo;
	}

	private Perfume mapper(ResultSet rs) throws SQLException {
		
		Perfume perfume = new Perfume();
		Marca marca = new Marca();
		
		//recupero columnas de resultados y creo pojo para su uso
		perfume.setId(rs.getInt("perfume_id"));
		perfume.setNombre(rs.getString("perfume_nombre"));
		perfume.setMl(rs.getInt("ml"));
		perfume.setImagen(rs.getString("imagen"));
		
		marca.setId(rs.getInt("marca_id"));
		marca.setNombre(rs.getString("marca_nombre"));
		perfume.setMarca(marca);
		
		return perfume;
		
	}
}
