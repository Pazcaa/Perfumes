package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.UsuarioDAOImpl;
import modelo.pojo.Usuario;

/**
 * Servlet implementation class CrearUsuarioController
 */
@WebServlet("/new_login")
public class CrearUsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UsuarioDAOImpl dao = UsuarioDAOImpl.getInstance();
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Usuario usuario = new Usuario();
		
		request.setAttribute("Usuario", usuario);
		
		request.getRequestDispatcher("new_usuario.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idParameter = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String password = request.getParameter("password");
		String imagen = request.getParameter("imagen");
		
		int id = Integer.parseInt(idParameter);
		
		//creo nuevos atributos
		Usuario usuario = new Usuario();
		Message message = new Message();
		
		usuario.setId(id);
		usuario.setNombre(nombre);
		usuario.setPassword(password);
		usuario.setImagen(imagen);
		
		
		//TODO validacion
		
		try {
			
			if (id == 0) {
			dao.insert(usuario);
			message = new Message("success", "El usuario ha sido creado con exito");
			}
			
			
		} catch (Exception e) {
			message = new Message("danger", "Lo sentimos, pero ha ocurrido una excepcion, " + e.getMessage());
			e.printStackTrace();
		}
		
			request.setAttribute("Usuario", usuario);
			request.setAttribute("message", message);
			
			request.getRequestDispatcher("new_usuario.jsp").forward(request, response);
		
	}

}
