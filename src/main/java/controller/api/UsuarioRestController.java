package controller.api;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import modelo.dao.impl.UsuarioDAOImpl;

/**
 * Servlet implementation class UsuarioRestController
 */
@WebServlet("/api/usuario")
public class UsuarioRestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = Logger.getLogger(UsuarioRestController.class);
	private final static UsuarioDAOImpl daoUsuario = UsuarioDAOImpl.getInstance();
       
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
LOG.debug("url pathInfo: " + request.getPathInfo());
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		String nombre = request.getParameter("nombre");
		
		boolean encontrado = daoUsuario.buscarByNombre(nombre);
		
		if (encontrado) {
			
			response.setStatus( HttpServletResponse.SC_OK ); //si el nombre existe, encontrado = true, por lo tanto envia el  estado 200
			
			
		}else {
			
			response.setStatus( HttpServletResponse.SC_NO_CONTENT );
		}
		
	}

}
