package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.conexion.ConnectionManager;
import modelo.pojo.Usuario;

public class UsuarioDAOImpl implements UsuarioDAO {
	
	//patron singleton
	private static UsuarioDAOImpl INSTANCE = null;
	
	//constructor del INSTANCE
	public UsuarioDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//metodo del INSTANCE
	public static synchronized UsuarioDAOImpl getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new UsuarioDAOImpl();
		}
		
		return INSTANCE;
		
	}
	
		// executeQUery => ResultSet
		private final String SQL_GET_ALL 		= "SELECT id, nombre, password, imagen FROM usuario ORDER BY id DESC LIMIT 500;";
		private final String SQL_GET_BY_ID 		= "SELECT id, nombre, password, imagen FROM usuario WHERE id = ?;";
		private final String SQL_EXISTE 		= "SELECT id, nombre, password, imagen FROM usuario WHERE nombre = ? AND password = ? ; ";
		
		// excecuteUpdate => AffectedRows (numero de filas afectadas)
		private final String SQL_INSERT = "INSERT INTO usuario (nombre, password, imagen) VALUES ( ? ,?, ?); ";
		private final String SQL_DELETE = "DELETE FROM usuario WHERE id = ? ; "; // si no escribo 'where id = ?' me cargo toda la lista!!!
		private final String SQL_UPDATE = "UPDATE usuario SET nombre = ?, password = ?, imagen = ? WHERE id = ? ; ";	

	@Override
	public ArrayList<Usuario> getAll() {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		
		try (	Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_GET_ALL);
				ResultSet rs = pst.executeQuery()){
			
			while (rs.next()) {
				//guardo cada "rs" en el arraylist
				usuarios.add(mapper(rs));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuarios;
	}

	@Override
	public Usuario getById(int id) throws Exception {
		
		Usuario usuario = new Usuario();
		
		try (	Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_GET_BY_ID)){
			
			pst.setInt(1, id);
			
			try (	ResultSet rs = pst.executeQuery()){
				if (rs.next()) {
					usuario = mapper(rs);
				}else {
					throw new Exception("No se puede encontrar el usuario con el id = " + id);
				}
				
			} 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return usuario;
	}

	@Override
	public Usuario delete(int id) throws Exception {
		Usuario usuario = getById(id);
		
		try (	Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_DELETE)){
			
			pst.setInt(1, id);
			int affectedRows = pst.executeUpdate();

			if (affectedRows != 1) {
				throw new Exception("No se pude eliminar el registro id = " + id);
				}
		}
		return usuario;
	}

	@Override
	public Usuario insert(Usuario pojo) throws Exception {
		
		try (	Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS);) {

				pst.setString(1, pojo.getNombre());
				pst.setString(2, pojo.getPassword());
				pst.setString(3, pojo.getImagen());
				
				int AffectedRows = pst.executeUpdate();
				if (AffectedRows == 1) {
					// conseguir el ID que nos ha arrojado

				try (ResultSet rskeys = pst.getGeneratedKeys()) {
					if (rskeys.next()) {
						int id = rskeys.getInt(1);
						pojo.setId(id);
					}
				}

			} else {
				throw new Exception("No se ha podido guardar el usuario" + pojo);
			}

		} catch (Exception e) {
			throw new Exception("No se ha podido guardar el usuario " + pojo.getNombre());
		}
		return pojo;
	}

	@Override
	public Usuario update(Usuario pojo) throws Exception {
		
		if (pojo == null) {
			throw new Exception("No se puede modificar si es null");
		}

		try (	Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_UPDATE)) {

			pst.setString(1, pojo.getNombre());
			pst.setString(2, pojo.getPassword());
			pst.setString(3, pojo.getImagen());
			pst.setInt(4, pojo.getId());

			int affectedRows = pst.executeUpdate();
			if (affectedRows != 1) {
				throw new Exception("No se ha podido actualizar el usuario con id =" + pojo.getId());
			}

		} catch (SQLException e) { // excepcion mas especifica que "exception e"
			throw new Exception("El usuario " + pojo.getNombre() + " ya existe");
		}

		return pojo;
	}

	@Override
	public Usuario existe(String nombre, String password) {
		Usuario usuario = null;

		try (	Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_EXISTE);) {

			pst.setString(1, nombre);
			pst.setString(2, password);
			
			try (ResultSet rs = pst.executeQuery();) {
				if (rs.next()) {
					usuario = mapper(rs);
				} 
			}//try
		} catch (Exception e) {
			e.printStackTrace();
		}

		return usuario;
	}

	private Usuario mapper(ResultSet rs) throws SQLException {
		Usuario usuario = new Usuario();
		
		//recupero columnas de resultados y creo pojo para su uso
		usuario.setId((rs.getInt("id")));;
		usuario.setNombre(rs.getString("nombre"));
		usuario.setPassword(rs.getString("password"));
		usuario.setImagen(rs.getString("imagen"));
		
		return usuario;
	}
}
