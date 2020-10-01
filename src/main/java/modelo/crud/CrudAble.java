package modelo.crud;

import java.util.ArrayList;

public interface CrudAble<P> {

	/**
	 * 
	 * @return
	 */
	ArrayList<P> getAll();
	
	/**
	 * Obtiene la información de la clase P
	 * @param id parametro ha entregar
	 * @return nos da la informacion de P
	 * @throws Exception
	 */
	P getById (int id) throws Exception;
	
	
	/**
	 * Elimimna la informacion de P por medio de su id
	 * @param id
	 * @return
	 * @throws Exception
	 */
	P delete (int id) throws Exception;
	
	/**
	 * Agrega un nuevo registro del tipo P
	 * @param pojo
	 * @return
	 * @throws Exception
	 */
	P insert (P pojo) throws Exception;
	
	/**
	 * Actualiza la información que ha variado en P, manteniendo su id
	 * @param pojo
	 * @return
	 * @throws Exception
	 */
	P update (P pojo) throws Exception;
	
}
