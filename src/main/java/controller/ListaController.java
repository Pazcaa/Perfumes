package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.impl.PerfumeDAOImpl;

/**
 * Servlet implementation class ListaController
 */
@WebServlet("/lista")
public class ListaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static PerfumeDAOImpl perfumeDAO = PerfumeDAOImpl.getInstance();
 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doProcess(request,response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doProcess(request,response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			request.setAttribute("Perfumes", perfumeDAO.getAll());
			request.getRequestDispatcher("/views/perfumes/lista.jsp").forward(request, response);
		
	}
}

