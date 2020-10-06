package modelo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import org.apache.log4j.Logger;



import modelo.conexion.ConnectionManager;
import modelo.dao.PerfumeDAO;
import modelo.dao.SeguridadException;
import modelo.pojo.Marca;
import modelo.pojo.Perfume;
import modelo.pojo.ResumenTotal;
import modelo.pojo.ResumenUsuario;
import modelo.pojo.Usuario;

public class PerfumeDAOImpl implements PerfumeDAO{
	
	private final static Logger LOG = Logger.getLogger(PerfumeDAOImpl.class);
	private static PerfumeDAOImpl INSTANCE = null; //patrón singleton
	
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
	
		private final String SELECT = "	SELECT \n" + 
									"	p.id 'id',\n" + 
									"	p.nombre 'nombre',\n" + 
									"	p.ml 'ml',\n" + 
									"	p.imagen 'imagen',\n" + 
									"   p.precio 'precio',\n" +
									"	m.id 'id_marca',\n" + 
									"	m.nombre 'nombre_marca',\n" + 
									"	u.id 'id_usuario',\n" + 
									"	u.nombre 'nombre_usuario'\n" + 
									" 	FROM perfume p , marca m , usuario u \n" + 
									"	WHERE p.id_marca = m.id  AND p.id_usuario = u.id ";
		
		private final String ORDER_LIMIT500 = "ORDER by p.id DESC LIMIT 500;";
		private final String ORDER_LIMIT = "ORDER by p.fecha_validado DESC LIMIT ?;";
	
		// executeQUery => ResultSet
		
		private final String SQL_GET_ALL 		= SELECT + ORDER_LIMIT500;
		/*
		private final String SQL_GET_ALL 		= 	" SELECT " + 
													" p.id 		'perfume_id', " + 
													" p.nombre 	'perfume_nombre', " + 
													" ml," + 
													" imagen, " + 
													" m.id 		'marca_id', "+
													" m.nombre 	'marca_nombre', " + 
													" precio " + 
													" FROM perfume p, marca m " + 
													" WHERE p.id_marca = m.id  " + 
													" ORDER BY p.id DESC LIMIT 500; ";
													*/
		
		private final String SQL_GET_ALL_VALIDADO 	= SELECT + " AND p.fecha_validado IS NOT NULL " + ORDER_LIMIT500;
		
		private final String SQL_GET_ALL_PENDIENTE 	= SELECT + " AND p.fecha_validado IS NULL " + ORDER_LIMIT500;
		
		private final String SQL_GET_LAST 		= SELECT + " AND p.fecha_validado IS NOT NULL " + ORDER_LIMIT;
		/*
		private final String SQL_GET_LAST 		= 	" SELECT " + 
													"	 p.id     'perfume_id', " + 
													"	 p.nombre 'perfume_nombre', " + 
													"	 ml, " + 
													"	 imagen, " + 
													"	 m.id     'marca_id', " + 
													"	 m.nombre 'marca_nombre',	" + 
													" 	 precio " + 
													" FROM perfume p , marca m " + 
													" WHERE p.id_marca  = m.id AND p.fecha_validado IS NOT NULL " + 
													" ORDER BY p.id DESC LIMIT ? ; ";
		*/
		
		private final String SQL_GET_BY_MARCA = SELECT + " AND p.fecha_validado IS NOT NULL AND m.id = ? " + ORDER_LIMIT;
		/*
		private final String SQL_GET_BY_MARCA = 	" SELECT " + 
													"	 p.id     'perfume_id', " + 
													"	 p.nombre 'perfume_nombre', " + 
													"	 ml, " + 
													"	 imagen, " + 
													"	 m.id     'marca_id', " + 
													"	 m.nombre 'marca_nombre',	" + 
													" 	 precio " + 
													" FROM perfume p , marca m " + 
													" WHERE p.id_marca  = m.id AND p.fecha_validado IS NOT NULL " +
													" AND m.id = ? " +   // filtramos por el id de la categoria
													" ORDER BY p.id DESC LIMIT ? ; ";
		*/
			
		private final String SQL_GET_BY_ID 		= SELECT + " AND p.id = ? " + ORDER_LIMIT500;
		/*
		private final String SQL_GET_BY_ID 		= 	" SELECT " + 
													" p.id 'perfume_id', " + 
													" p.nombre 'perfume_nombre', " + 
													" ml, " + 
													" imagen, " + 
													" m.id 'marca_id', " + 
													" m.nombre 'marca_nombre', " + 
													" 	 precio " + 
													" FROM perfume p, marca m " + 
													" WHERE p.id_marca = m.id  AND p.id = ?;";
		*/
		
		
		
		private final String SQL_GET_BY_ID_AND_USER	= SELECT + " AND p.id = ? AND p.id_usuario = ? " + ORDER_LIMIT500;
		/*
		private final String SQL_GET_BY_ID_AND_USER	= " SELECT p.id 'perfume_id' ," + 
														" p.nombre 'perfume_nombre', p.ml , p.imagen , p.precio," + 
														" m.id 'marca_id', m.nombre 'marca_nombre' " + 
														" FROM perfume p , marca m "+ 
														" WHERE p.id_marca = m.id AND p.id = ? AND p.id_usuario = ?;"; 
		*/
		
		
		private final String SQL_VIEW_RESUMEN_USUARIO = "SELECT id_usuario, total, aprobado, pendiente FROM `v.perfumes_resumen` WHERE id_usuario = ? ; ";
		
		private final String SQL_VIEW_RESUMEN_TOTAL = " SELECT total, aprobados, pendientes, marcas, usuarios FROM `v.perfumes_resumen_total`;";
		
		private final String SQL_GET_BY_USUARIO_PERFUME_VALIDADO = SELECT + " AND p.fecha_validado IS NOT NULL AND p.id_usuario =? " + ORDER_LIMIT500;
		/*
		private final String SQL_GET_BY_USUARIO_PERFUME_VALIDADO = " SELECT p.id 'perfume_id', p.nombre 'perfume_nombre',  ml, imagen, m.id 'marca_id',  m.nombre 'marca_nombre', precio" + 
																	" FROM perfume p, marca m " + 
																	" WHERE p.id_marca = m.id  AND p.fecha_validado IS NOT NULL AND p.id_usuario =?" + 
																	" ORDER BY p.id " + 
																	" LIMIT 500;";
		*/
		
		private final String SQL_GET_BY_USUARIO_PERFUME_NO_VALIDADO = SELECT + " AND p.fecha_validado IS NULL AND p.id_usuario =? " + ORDER_LIMIT500;
		/*
		private final String SQL_GET_BY_USUARIO_PERFUME_NO_VALIDADO = " SELECT p.id 'perfume_id', p.nombre 'perfume_nombre',  ml, imagen, m.id 'marca_id',  m.nombre 'marca_nombre', precio" + 
																	" FROM perfume p, marca m " + 
																	" WHERE p.id_marca = m.id  AND p.fecha_validado IS NULL AND p.id_usuario =?" + 
																	" ORDER BY p.id " + 
																	" LIMIT 500;";
		*/
		
		// excecuteUpdate => AffectedRows (numero de filas afectadas)
		private final String SQL_INSERT = "INSERT INTO perfume (nombre, ml, imagen, id_marca, id_usuario, precio ) VALUES ( ? ,?, ?, ?, ?, ?); ";
		
		private final String SQL_UPDATE = "UPDATE perfume SET nombre = ?, ml = ?, imagen = ?, id_marca = ?, precio = ?  WHERE id = ? ; ";	
		
		private final String SQL_UPDATE_VALIDAR = "UPDATE perfume SET fecha_validado = CURRENT_TIMESTAMP() WHERE id = ? ;"; 
		
		private final String SQL_UPDATE_BY_USER = "UPDATE perfume SET nombre = ?, ml = ?, imagen = ?, id_marca = ?, precio = ?, fecha_validado = NULL WHERE id = ? ; ";	
		
		private final String SQL_DELETE = "DELETE FROM perfume WHERE id = ? ; "; // si no escribo 'where id = ?' me cargo toda la lista!!!
		
		private final String SQL_DELETE_BY_USER = "DELETE FROM perfume WHERE id = ? AND id_usuario = ?; "; // si no escribo 'where id = ?' me cargo toda la lista!!!
		
	
	@Override
	public ArrayList<Perfume> getAll() {
		ArrayList<Perfume> perfumes = new ArrayList<Perfume>();
		
	try (	Connection conexion = ConnectionManager.getConnection();
			PreparedStatement pst = conexion.prepareStatement(SQL_GET_ALL);
			ResultSet rs = pst.executeQuery();){
		
		LOG.debug(pst);
		while (rs.next()) {
		
			//guardo en el arraylist con su id
			perfumes.add(mapper(rs));
		}	
	} catch (Exception e) {
		LOG.error(e);
	}	
		return perfumes;
	}
	
	@Override
	public ArrayList<Perfume> getAllDetalle(boolean isValidado) {
		ArrayList<Perfume> perfumes = new ArrayList<Perfume>();
		
		String sql = (isValidado)? SQL_GET_ALL_VALIDADO: SQL_GET_ALL_PENDIENTE;
		
		try (Connection conexion = ConnectionManager.getConnection();
			PreparedStatement pst = conexion.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();){
						
			LOG.debug(pst);
			
			
				while (rs.next()) {
					perfumes.add(mapper(rs));	
			}
			
		} catch (Exception e) {
			LOG.error(e);
		}
		return perfumes;
	}

	@Override
	public ArrayList<Perfume> getLast(int numReg) {
		ArrayList<Perfume> perfumes = new ArrayList<Perfume>();		
		try (
				Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_GET_LAST);
			) {			
					pst.setInt( 1, numReg);
					LOG.debug(pst);
					try ( ResultSet rs = pst.executeQuery() ){
						while ( rs.next() ) {					
							perfumes.add( mapper(rs) );					
						}
					}
			
		} catch (Exception e) {			
			LOG.error(e);				
		}
		return perfumes;
	}

	@Override
	public ArrayList<Perfume> getAllByMarca(int idMarca, int numReg) {
		ArrayList<Perfume> perfumes = new ArrayList<Perfume>();		
		try (
				Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_GET_BY_MARCA);
			) {			
					pst.setInt( 1, idMarca);
					pst.setInt( 2, numReg);
					LOG.debug(pst);
					try ( ResultSet rs = pst.executeQuery() ){
						while ( rs.next() ) {					
							perfumes.add( mapper(rs) );					
						}
					}
			
		} catch (Exception e) {			
			LOG.error(e);				
		}
		return perfumes;
	}

	@Override
	public Perfume getById(int id) throws Exception {
		Perfume perfume = new Perfume();
		
		try (	Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_GET_BY_ID);) {
			
			pst.setInt(1, id);
			LOG.debug(pst);
			try (ResultSet rs = pst.executeQuery();){
				if (rs.next()) {
					perfume = mapper(rs);
				}else {
					throw new Exception ("No se puede encontrar el registro con id=" + id);
				}
			}
			
		} catch (Exception e) {
			LOG.error(e);
		}
		return perfume;
	}
	
	
	@Override
	public Perfume getById(int idPerfume, int idUsuario) throws Exception, SeguridadException {
		Perfume perfume = new Perfume();
		
		try (	Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_GET_BY_ID_AND_USER);) {
			
			pst.setInt(1, idPerfume);
			pst.setInt(2, idUsuario);
			LOG.debug(pst);
			
			ResultSet rs = pst.executeQuery();
				if (rs.next()) {
					perfume = mapper(rs);
				}else {
					throw new SeguridadException();
				}
			
		}
		
		return perfume;
	}
	

	@Override
	public ResumenUsuario getResumenByUsuario(int idUsuario) {
		ResumenUsuario resumen = new ResumenUsuario();
		
		try (Connection conexion = ConnectionManager.getConnection();
			PreparedStatement pst = conexion.prepareStatement(SQL_VIEW_RESUMEN_USUARIO);){
			
			pst.setInt(1, idUsuario);
			LOG.debug(pst);
			
			try (ResultSet rs = pst.executeQuery();) {
				if (rs.next()) {
					resumen.setIdUsuario(idUsuario);
					resumen.setPerfumesAprobados(rs.getInt("aprobado"));
					resumen.setPerfumesPendientes(rs.getInt("pendiente"));
					resumen.setPerfumesTotal(rs.getInt("total"));
				}
			}
			
		} catch (Exception e) {
			LOG.error(e);
		}
		
		return resumen;
	}
	
	@Override
	public ResumenTotal getResumentTotal(boolean resumen) {
		ResumenTotal resumenTotal = new ResumenTotal();
		
		try (Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_VIEW_RESUMEN_TOTAL);
				ResultSet rs = pst.executeQuery();){
				
				
				LOG.debug(pst);
				
				
					if (rs.next()) {
						resumenTotal.setPerfumesAprobados(rs.getInt("aprobados"));
						resumenTotal.setPerfumesPendientes(rs.getInt("pendientes"));
						resumenTotal.setPerfumesTotal(rs.getInt("total"));
						resumenTotal.setMarcasTotal(rs.getInt("marcas"));
						resumenTotal.setUsuariosTotal(rs.getInt("usuarios"));
					}
				
				
			} catch (Exception e) {
				LOG.error(e);
			}
			
		
		return resumenTotal;
	}
	
	@Override
	public ArrayList<Perfume> getAllByUser(int id_usuario, boolean isValidado) {
		ArrayList<Perfume> perfumes = new ArrayList<Perfume>();
		
		String sql = (isValidado)? SQL_GET_BY_USUARIO_PERFUME_VALIDADO : SQL_GET_BY_USUARIO_PERFUME_NO_VALIDADO;
		
		try (Connection conexion = ConnectionManager.getConnection();
			PreparedStatement pst = conexion.prepareStatement(sql);){
			
			// TODO mirar como hacerlo con una SQL,   "IS NOT NULL" o "IS NULL"
			// pst.setBoolean(1, isValidado); // me sustitulle con un 1 o 0
						
			pst.setInt(1, id_usuario);
						
			LOG.debug(pst);
			
			try ( ResultSet rs = pst.executeQuery() ){
				while (rs.next()) {
					perfumes.add(mapper(rs));
				}	
			}
			
		} catch (Exception e) {
			LOG.error(e);
		}
		
		return perfumes;
	}

	@Override
	public Perfume delete(int id) throws Exception {
		// del listado de perfumes, conseguir el id del que deseamos eliminar
				Perfume perfume = getById(id);
			
		try (	Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_DELETE);) {

				pst.setInt(1, id);
				LOG.debug(pst);
				int affectedRows = pst.executeUpdate();

				if (affectedRows != 1) {
					throw new Exception("No se pude eliminar el registro id=" + id);
					}
				}

				return perfume;
	}
	
	@Override
	public Perfume delete(int idPerfume, int idUsuario) throws Exception, SeguridadException {
		// del listado de perfumes, conseguir el id del que deseamos eliminar PARA EL USUARIO
		Perfume perfume = getById(idPerfume, idUsuario);
	
		try (	Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_DELETE_BY_USER);) {
		
				pst.setInt(1, idPerfume);
				pst.setInt(2, idUsuario);
				
				LOG.debug(pst);
				
				pst.executeUpdate();
		
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
				pst.setInt(5, pojo.getUsuario().getId());
				pst.setFloat(6, pojo.getPrecio());
				
				
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
			pst.setFloat(5, pojo.getPrecio());
			pst.setInt(6, pojo.getId());
			LOG.debug(pst);
			int affectedRows = pst.executeUpdate();
			if (affectedRows != 1) {
				throw new Exception("No se ha podido eliminar el registro con id =" + pojo.getId());
			}

		} catch (SQLException e) { // excepcion mas especifica que "exception e"
			throw new Exception("El perfume " + pojo.getNombre() + " ya existe");
		}

		return pojo;
	}
	
	@Override
	public Perfume updateByUser(Perfume pojo) throws Exception, SeguridadException {
		
		try (	Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_UPDATE_BY_USER)) {

			int idPerfume = pojo.getId();
			int idUsuario = pojo.getUsuario().getId();
			
			getById(idPerfume, idUsuario);// confirmo que el id perfume corresponde al usuario (filtro de seguridad)
			
			//seteo los datos, para actualizarlos y llevar la fecha_validado a null
			pst.setString(1, pojo.getNombre());
			pst.setInt(2, pojo.getMl());
			pst.setString(3, pojo.getImagen());
			pst.setInt(4, pojo.getMarca().getId());
			pst.setFloat(5, pojo.getPrecio());
			pst.setInt(6, pojo.getId());
			
			LOG.debug(pst);
			int affectedRows = pst.executeUpdate();
			if (affectedRows != 1) {
				throw new Exception("No se ha podido eliminar el registro con id =" + pojo.getId());
			}

		}

		return pojo;
	}
	

	@Override
	public ArrayList<Perfume> getAllByNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Perfume validar(int id) throws Exception {
		
		Perfume perfume = getById(id);
		
		try (	Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_UPDATE_VALIDAR);) {
			
			pst.setInt(1, id);
			LOG.debug(pst);
			int affectedRows = pst.executeUpdate();
			if (affectedRows != 1) {
				throw new Exception("No se ha podido validar el registro con id = " + id);
			}
			
		}catch (SQLException e) { // excepcion mas especifica que "exception e"
			LOG.error(e);
			throw new Exception("El perfume con id = " + id + " no se ha podido validar");
		}
		return perfume;
	}

	

	private Perfume mapper(ResultSet rs) throws SQLException {
		
		Perfume perfume = new Perfume();
		Marca marca = new Marca();
		Usuario usuario = new Usuario();
		
		//recupero columnas de resultados y creo pojo para su uso
		perfume.setId(rs.getInt("id"));
		perfume.setNombre(rs.getString("nombre"));
		perfume.setMl(rs.getInt("ml"));
		perfume.setImagen(rs.getString("imagen"));
		perfume.setPrecio(rs.getFloat("precio"));
		
		marca.setId(rs.getInt("id_marca"));
		marca.setNombre(rs.getString("nombre_marca"));
		perfume.setMarca(marca);
		
		usuario.setId(rs.getInt("id_usuario"));
		usuario.setNombre(rs.getString("nombre_usuario"));
		perfume.setUsuario(usuario);
		
		
		return perfume;
		
	}

	








	

	

	

}
