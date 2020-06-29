package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.impl.PerfumeDAOImpl;
import modelo.pojo.Perfume;

/**
 * Servlet implementation class EliminarController
 */
@WebServlet("/eliminar")
public class EliminarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PerfumeDAOImpl dao = PerfumeDAOImpl.getInstance();
		
		Perfume perfume = new Perfume();
		
		String idParameter = request.getParameter("id");
		int id = Integer.parseInt(idParameter);
		
			try {
				
				if (id != 0) {
				request.setAttribute("Perfume", dao.getById(id));
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.getRequestDispatcher("eliminar.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PerfumeDAOImpl dao = PerfumeDAOImpl.getInstance();
		Message message = new Message();
		
		String idParameter = request.getParameter("id");
		int id = Integer.parseInt(idParameter);
		
		String alternativa = request.getParameter("alternativa");
		
		
		
		try {
			if ("eliminar".equals(alternativa)) {
				Perfume perfume = dao.delete(id);
				message = new Message("success", "El perfume " + perfume.getNombre() + " ha sido eliminado con exito");
			}else {
				
				message = new Message("danger", "Se ha cancelado la eliminación del perfume");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		request.setAttribute("message", message);
		request.getRequestDispatcher("inicio").forward(request, response);
		
		
		
		
		
		
		
	}

}
