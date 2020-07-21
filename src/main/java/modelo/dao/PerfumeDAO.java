package modelo.dao;

import java.util.ArrayList;



import modelo.crud.CrudAble;
import modelo.pojo.Perfume;

public interface PerfumeDAO extends CrudAble<Perfume>{

	/**
	 * metodo para validar producto nuevo incorporado
	 * @param id
	 */
	
	void validar (int id);
	
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
	
}
