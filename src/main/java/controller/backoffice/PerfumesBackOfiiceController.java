package controller.backoffice;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import modelo.dao.impl.PerfumeDAOImpl;
import modelo.pojo.Perfume;

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
		
		
		int perfume = Integer.parseInt(request.getParameter("perfumes"));
		String titulo = "";
		ArrayList<Perfume> perfumes = new ArrayList<Perfume>();
		
		
		if (perfume == 1) {
			
			perfumes = perfumeDAO.getAllDetalle(true);
			titulo = "Validados";
		
		}if (perfume == 0) {
			
			perfumes = perfumeDAO.getAllDetalle(false);
			titulo = "Pendientes";
		}
		
		
		request.setAttribute("perfumes", perfumes);
		request.setAttribute("titulo", titulo);
		request.getRequestDispatcher("perfumes/index.jsp").forward(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	

}
