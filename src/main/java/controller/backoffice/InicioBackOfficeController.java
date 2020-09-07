package controller.backoffice;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;



/**
 * Servlet implementation class InicioBackOfficeController
 */
@WebServlet("/views/backoffice/inicio")
public class InicioBackOfficeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(InicioBackOfficeController.class);
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("aprobados", 3);
		request.setAttribute("pendientes", 2);
		request.setAttribute("numero_logeados", 456);
		request.setAttribute("productos_pendientes", 2);
		
		
		//para hacer fordward coje el webservlet ("/views/frontoffice/inicio") y reemplaza la ultima parte por la request
		// quedando la ruta "/views/frontoffice/index.jsp"
		
		String pagina = "index.jsp";
		LOG.debug("forward: " + pagina);
		
		request.getRequestDispatcher(pagina).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
