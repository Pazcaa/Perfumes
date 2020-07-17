package controller.frontoffice;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.pojo.Perfume;

/**
 * Servlet implementation class InicioFrontOfficeController
 */
@WebServlet("/views/frontoffice/perfumes")
public class PerfumesFrontOfficeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
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
		
		Perfume perfume = new Perfume();
		String validar = request.getParameter("validar");
		String tittle = "";
		
		if (validar == null) {
			tittle = "Perfumes Validados";
			
			perfume.setId(4);
			perfume.setNombre("perfume validado");
			
			request.setAttribute("tittle", tittle);
			request.setAttribute("perfume", perfume);
			request.getRequestDispatcher("perfumes.jsp").forward(request, response);
			
		}else {
			tittle = "Perfumes por validar";
			perfume.setId(100);
			perfume.setNombre("perfume por validar ");
			
			request.setAttribute("tittle", tittle);
			request.setAttribute("perfume", perfume);
			
			request.getRequestDispatcher("perfumes.jsp").forward(request, response);
		}
		
	}

}
