package controller.backoffice;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import modelo.dao.impl.PerfumeDAOImpl;
import modelo.pojo.ResumenTotal;



/**
 * Servlet implementation class InicioBackOfficeController
 */
@WebServlet("/views/backoffice/inicio")
public class InicioBackOfficeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(InicioBackOfficeController.class);
    private final static PerfumeDAOImpl daoPerfume = PerfumeDAOImpl.getInstance();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ResumenTotal resumen = daoPerfume.getResumentTotal(true);
		
		request.setAttribute("resumen", resumen);
		
		
		
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
