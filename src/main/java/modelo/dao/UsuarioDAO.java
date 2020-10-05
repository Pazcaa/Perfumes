package modelo.dao;

import modelo.crud.CrudAble;
import modelo.pojo.Usuario;

public interface UsuarioDAO extends CrudAble<Usuario> {
	
	
	/**
	 * Busca si existe el usuario en la base de datos
	 * @param nombre String que corresponde al nombre con que se registro el usuario
	 * @param password String unico, codificado a MD5 
	 * @return Usuario con los datos si estos existen, si no existe retorna null
	 */
	
	Usuario existe (String nombre, String password);
	

	/**
	 * me avisa si el nombre buscado ya existe o no
	 * @param nombre String con la palabra de busqueda dentro de la tabla Usuarios
	 * @return true si el nombre existe, false si el nombre no existe
	 */
	boolean buscarByNombre(String nombre);
	
}
