package controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import modelo.dao.PerfumeDAOImpl;
import modelo.pojo.Message;
import modelo.pojo.Perfume;

/**
 * Servlet implementation class FormularioController
 */
@WebServlet("/formulario")
public class FormularioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PerfumeDAOImpl dao = PerfumeDAOImpl.getInstance();
		
		Perfume perfume = new Perfume();
		
		request.setAttribute("Perfume", perfume);
		
		request.getRequestDispatcher("formulario.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		//recupero los parametros
			String idParameter = request.getParameter("id");
			String nombre = request.getParameter("nombre");
			String mlParameter = request.getParameter("ml");
			String imagen = request.getParameter("imagen");
			
			int id = Integer.parseInt(idParameter);
			int ml = Integer.parseInt(mlParameter);
			
			//creo mis nuevos atributos
			Perfume perfume = new Perfume();
			Message message = new Message();
			
			perfume.setId(id);
			perfume.setNombre(nombre);
			perfume.setMl(ml);
			perfume.setImagen(imagen);
			
			
			//lo integro a mi dao
			PerfumeDAOImpl dao = PerfumeDAOImpl.getInstance();
			
			try {
				
				if (nombre!= null && nombre.length() > 2 && nombre.length() <= 100) {
					
					if (id == 0) {
						dao.insert(perfume);
						
					}
					
					message = new Message("success", "El perfume ha sido incorporado con exito al listado");
					
				}else {
					message = new Message("danger", "El nombre del perfume debe tener entre 2 y 100 caracteres");
				}
				
				
				
			} catch (Exception e) {
				message = new Message("danger", "Lo sentimos, pero ha ocurrido una excepcion, " + e.getMessage());
				e.printStackTrace();
			}
			
			//enviamos los atributos a la vista
			request.setAttribute("Perfume", perfume);
			request.setAttribute("message", message);
			
			//ir a la nueva vista
			request.getRequestDispatcher("formulario.jsp").forward(request, response);
	
	}

}
