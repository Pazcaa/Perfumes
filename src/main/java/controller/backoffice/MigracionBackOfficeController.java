package controller.backoffice;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import modelo.conexion.ConnectionManager;




/**
 * Servlet implementation class MigracionBackOfficeController
 */
@WebServlet("/views/backoffice/migracion")
public class MigracionBackOfficeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(MigracionBackOfficeController.class);
  

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LOG.trace("Inicio");
		String fichero = "/home/java/personas.txt";
		int numLineas = 0;
		int numInsert = 0;
		int numErrores = 0;
		long tiempoInicio = System.currentTimeMillis();
		long tiempoFin = 0;
		

		final String SQL = "INSERT INTO usuario (nombre, password, imagen, id_rol) VALUES (?, 1234, 'https://p1.pxfuel.com/preview/790/280/868/596ed5870f859.jpg', 1);";
		
		/******** Logica de programacion **********/
		
		try (Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL);){
			
			// Cuando establecemos una conexion en Java, siempre es autocomitable
			// Con esta linea le decimos que no lo sea y deberemos hacer un COMMIT para guardar los cambios temporales
			conexion.setAutoCommit(false);
						
			LOG.trace("Leer Fichero texto");
			
			LOG.trace("Recorrer linea a linea");
			
			// @see: https://blog.openalfa.com/como-leer-un-fichero-de-texto-linea-a-linea-en-java
			// usar While en vez de for
			
			for (int i = 0; i < 5 ; i++) {
				
			try {
				numLineas++;
				// obviar la 1º linea, que son la cabecera
				
				String linea = "Magee;Amet Risus LLC;Mar 21, 2019;(014644) 35372;Quisque@Donec.ca;16480805 5737";
				String[] campos = linea.split(";");
				// si la linea no tiene 6 campos es ERRONEA
				
				//LOG.trace("Comprobar datos correctos en la linea");
				
				pst.setString(1, "persona" + i );				
				
				LOG.debug(pst);
				pst.executeUpdate();
				numInsert++;
				LOG.trace("Insertada Persona");
			
			// capturar posibles Excepciones para poder seguir dentro del FOR	
				
				pst.setString(1, "persona" + i);
				
				int affectedRows = pst.executeUpdate();
				if ( affectedRows == 1 ) {
					numInsert++;
					LOG.trace("Insertada Persona");
				}else {
					numErrores++;
					LOG.trace("No se puede Insertar Persona");
				}
				
			} catch (Exception e) {
			// capturar posibles Excepciones para poder seguir dentro del FOR
			numErrores++;
			}
		}//end FOR
			
			LOG.trace("Al finalizar, realizar un commit para guardar en bbdd");
		
		}catch (Exception e) {
			LOG.error(e);
			e.printStackTrace();
		}finally {

			request.setAttribute("fichero", fichero);
			request.setAttribute("num_lineas", numLineas);
			request.setAttribute("num_insert", numInsert);
			request.setAttribute("num_errores", numErrores);
			
			tiempoFin = System.currentTimeMillis();
			request.setAttribute("tiempo", (tiempoFin - tiempoInicio));
			
			request.getRequestDispatcher("resumen-migracion.jsp").forward(request, response);
			
		}
		
		LOG.trace("Fin");
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
