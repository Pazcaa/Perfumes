package modelo.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import modelo.crud.CrudAble;
import modelo.pojo.Perfume;
import modelo.pojo.ResumenTotal;
import modelo.pojo.ResumenUsuario;

public interface PerfumeDAO extends CrudAble<Perfume>{

	
	/**
	 * metodo para validar producto nuevo incorporado
	 * @param id int numero unico de identificación del perfume
	 * @return pojo perfume
	 * @throws Exception en caso que el pojo asociado al id no se haya podido validar
	 * @throws SeguridadException en caso de no contar con permisos para acceder a la informcaion del id
	 */
	
	Perfume validar (int id) throws Exception, SeguridadException;
	
	/**
	 * Elimina un perfume asociado a un usuario, un usuario solo puede eliminar sus perfumes y no los de otros
	 * @param idPerfume int numero unico de identificion de perfume
	 * @param idUsuario int numero unico de identificaión de usuario
	 * @return Perfume eliminado
	 * @throws Exception nos indica porque no se puede eliminar el perfume
	 * @throws SeguridadException Si no puede eliminar el perfume porque no pertenece al usuario
	 */
	Perfume delete(int idPerfume, int idUsuario) throws Exception, SeguridadException;
	
	/**
	 * Obtengo un perfume que pertenece a un usuario en concreto
	 * @param idPerfume numero unico de identificion de perfume
	 * @param idUsuario numero unico de identificaión de usuario
	 * @return me devuelve el perfume asociado al usuario
	 * @throws Exception si el perfume solicitado no pertenece al idUsuario, entonces me lo señala aqui
	 * @throws SeguridadException si no me puede dar el perfume asociado al idUsuario
	 */
	Perfume getById(int idPerfume, int idUsuario) throws Exception, SeguridadException;
	
	/**
	 * Se obtienen todos los datos del pojo Perfume asociados a un nombre
	 * @param nombre String etiqueta identificatoria unica del perfume
	 * @return {@code ArrayList<Perfume>}
	 */
	ArrayList<Perfume> getAllByNombre (String nombre);
	
	/**
	 * Obtiene todos los productos de un usuario, estos pueden estar validados o no
	 * @param id_usuario int identificador del usuario
	 * @param isValidado boolean true para mostrar los productos con fecha_validacion, false para mostrar los pendientes de validar
	 * @return {@code ArrayList<Perfume>}
	 */
	ArrayList<Perfume> getAllByUser (int id_usuario, boolean isValidado );
	
	/**
	 * Obtiene todos los perfumes, agrupados por validaos y pendientes
	 * @param isValidado boolean true muestra todos los perfumes validados, false para mostrar los pendienets de validar
	 * @return  {@code ArrayList<Perfume>}
	 */
	ArrayList<Perfume> getAllDetalle (boolean isValidado );
	
	/**
	 *  Obtiene los ultimos registros ordenador por id descentente
	 * @param numReg int numero de registros a recuperar
	 * @return {@code ArrayList<Perfume>}
	 */
	ArrayList<Perfume> getLast (int numReg);
	
	
	/**
	 * Obtienes los productos de una Categoria
	 * @param idMarca int identificador de la Categoria
	 * @param numReg int numero de registgros a mostrar
	 * @return {@code ArrayList<Perfume>}
	 */
	ArrayList<Perfume> getAllByMarca( int idMarca, int numReg );
	
	
	
	/**
	 * Obtiene datos estadisticos del Usuario y sus productos
	 * @param idUsuario int identificador del usuario
	 * @return entrega numero de perfumes aprobados, pendientes y total de cada usuario
	 */
	ResumenUsuario getResumenByUsuario (int idUsuario);
	
	/**
	 * Obtiene el numero total de perfumes validados y de perfumes pendientes
	 * @param resumen boolean true para mostrar lla estadistica
	 * @return el numero de productos validados y el nuemro de products pendientes
	 */
	ResumenTotal getResumentTotal(boolean resumen);
	
	/**
	 * Actualización de algún o algunos parametros de un perfume perteneciente a un usuario particular
	 * @param perfume pojo de un perfume perteneciente a un usuario
	 * @return valores seteados del perfume y fecha de validación vuelve a NULL
	 * @throws Exception que el perfume que se quiere actualizar no pertenece al usuario que lo solicita
	 * @throws SeguridadException si no me puede dar el perfume asociado al idUsuario
	 */
	Perfume updateByUser(Perfume perfume)throws Exception, SeguridadException;	
}
