package modelo.crud;

import java.util.ArrayList;

public interface CrudAble<P> {

	/**
	 * Obtiene la información de todos los id.
	 * @return {@code ArrayList<P>}
	 */
	ArrayList<P> getAll();
	
	/**
	 * Obtiene la información de la clase P
	 * @param id parametro ha entregar
	 * @return nos da la informacion de P
	 * @throws Exception si no se puede obtener la información para el parametro id
	 */
	P getById (int id) throws Exception;
	
	
	/**
	 * Elimimna la informacion de P por medio de su id
	 * @param id parametro de entrada
	 * @return elimina todo lo asociado al id entregado
	 * @throws Exception si no se puede eliminar la información asociada al id
	 */
	P delete (int id) throws Exception;
	
	/**
	 * Agrega un nuevo registro del tipo P
	 * @param pojo información para agregar un nuevo P
	 * @return pojo ya insertado
	 * @throws Exception si no se puede reailzar la insert para el pojo
	 */
	P insert (P pojo) throws Exception;
	
	/**
	 * Actualiza la información que ha variado en P, manteniendo su id
	 * @param pojo agergamos la información que acualizaremos o cambiaremos del pojo unicamente
	 * @return pojo con toda su información ya actualizada
	 * @throws Exception si no se puede actualizar la información del pojo
	 */
	P update (P pojo) throws Exception;
	
}
