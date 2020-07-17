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
@WebServlet("/views/frontoffice/crear_perfume")
public class CrearPerfumeFrontOfficeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Perfume perfume = new Perfume();
		
		perfume.setId(100);
		perfume.setNombre("Prueba");
		
		request.setAttribute("perfume", perfume);
		request.setAttribute("tittle", "Formulario Crear perfume");
		
		request.getRequestDispatcher("formulario.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Perfume perfume = new Perfume();
		
		perfume.setId(101);
		perfume.setNombre("Prueba Hecha");
		
		request.setAttribute("perfume", perfume);
		request.setAttribute("tittle", "Perfume creado");
		
		request.getRequestDispatcher("formulario.jsp").forward(request, response);
		
	}

}
