package modelo.dao;

import modelo.crud.CrudAble;
import modelo.pojo.Usuario;

public interface UsuarioDAO extends CrudAble<Usuario> {
	
	
	/**
	 * Busca si existe el usuario en la base de datos
	 * @param nombre
	 * @param password
	 * @return Usuario con los datos si estos existen, si no existe retorna null
	 */
	
	Usuario existe (String nombre, String password);
	
}
