package modelo.dao;

import java.util.ArrayList;



import modelo.crud.CrudAble;
import modelo.pojo.Perfume;

public interface PerfumeDAO extends CrudAble<Perfume>{

	ArrayList<Perfume> getAllByNombre (String nombre);
	
	
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
