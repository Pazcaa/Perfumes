package modelo.dao;

import java.util.ArrayList;



import modelo.crud.CrudAble;
import modelo.pojo.Perfume;
import modelo.pojo.ResumenUsuario;

public interface PerfumeDAO extends CrudAble<Perfume>{

	/**
	 * metodo para validar producto nuevo incorporado
	 * @param id
	 */
	
	void validar (int id);
	
	/**
	 * Elimina un perfume asociado a un usuario, un usuario solo puede eliminar sus perfumes y no los de otros
	 * @param idPerfume
	 * @param idUsuario
	 * @return Perfume eliminado
	 * @throws Exception
	 * @throws SeguridadException Si no puede eliminar el perfume porque no pertenece al usuario
	 */
	Perfume delete(int idPerfume, int idUsuario) throws Exception, SeguridadException;
	
	/**
	 * Obtengo un perfume que pertenece a un usuario en concreto
	 * @param idPerfume
	 * @param idUsuario
	 * @return
	 * @throws Exception
	 * @throws SeguridadException
	 */
	Perfume getById(int idPerfume, int idUsuario) throws Exception, SeguridadException;
	
	ArrayList<Perfume> getAllByNombre (String nombre);
	
	/**
	 * Obtiene todos los productos de un usuario, estos pueden estar validados o no
	 * @param idUsuario int identificador del usuario
	 * @param isValidado boolean true para mostrar los productos con fecha_validacion, false para mostrar los pendientes de validar
	 * @return
	 */
	ArrayList<Perfume> getAllByUser (int id_usuario, boolean isValidado );
	
	/**
	 *  Obtiene los ultimos registros ordenador por id descentente
	 * @param numReg int numero de registros a recuperar
	 * @return ArrayList<Perfume>
	 */
	ArrayList<Perfume> getLast (int numReg);
	
	
	/**
	 * Obtienes los productos de una Categoria
	 * @param idMarca int identificador de la Categoria
	 * @param numReg int numero de registgros a mostrar
	 * @return ArrayList<Perfume>
	 */
	ArrayList<Perfume> getAllByMarca( int idMarca, int numReg );
	
	
	
	/**
	 * Obtiene datos estadisticos del Usuario y sus productos
	 * @param idUsuario
	 * @return
	 */
	ResumenUsuario getResumenByUsuario (int idUsuario);
	
	Perfume updateByUser(Perfume perfume)throws Exception, SeguridadException;	
}
