package controller.backoffice;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import modelo.dao.impl.PerfumeDAOImpl;

/**
 * Servlet implementation class PerfumesBackOfiiceController
 */
@WebServlet("/views/backoffice/perfumes")
public class PerfumesBackOfiiceController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(PerfumesBackOfiiceController.class);
	private static PerfumeDAOImpl perfumeDAO = PerfumeDAOImpl.getInstance();
	
       
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setAttribute("Perfumes", perfumeDAO.getAll());
		request.getRequestDispatcher("perfumes/index.jsp").forward(request, response);
	}

}
