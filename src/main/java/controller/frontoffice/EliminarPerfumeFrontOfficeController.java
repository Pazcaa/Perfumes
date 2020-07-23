package controller.frontoffice;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;



import controller.Message;
import modelo.dao.impl.PerfumeDAOImpl;
import modelo.pojo.Perfume;

/**
 * Servlet implementation class EliminarPerfumeFrontOfficeController
 */
@WebServlet("/views/frontoffice/eliminar_perfume")
public class EliminarPerfumeFrontOfficeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(EliminarPerfumeFrontOfficeController.class);

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PerfumeDAOImpl dao = PerfumeDAOImpl.getInstance();
		
		//Perfume perfume = new Perfume();
		
		String idParameter = request.getParameter("id");
		int id = Integer.parseInt(idParameter);
		Message message = new Message();
		
		
		try {
			Perfume perfume = dao.delete(id);
			message = new Message("success", "Eliminado el perfume " + perfume.getNombre());
			
		} catch (Exception e) {
			message = new Message("danger", "ERROR " + e.getMessage());
			LOG.error(e);
		}
		
		//Enviar datos a la vista
		
		request.getSession().setAttribute("message", message);
		
		request.getRequestDispatcher("inicio").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
