package controller;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import modelo.dao.UsuarioDAOImpl;
import modelo.pojo.Usuario;

/**
 * Servlet implementation class CrearUsuarioController
 */
@WebServlet("/new_login")
public class CrearUsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UsuarioDAOImpl dao = UsuarioDAOImpl.getInstance();
	private static ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	private static Validator validator = factory.getValidator();

 
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
		
		
		Set<ConstraintViolation<Usuario>> violations = validator.validate(usuario);
		
		try {
			
			if (violations.isEmpty()) { //no hay errores de validacion
				
				if (id == 0) {
					dao.insert(usuario);
					message = new Message("success", "El usuario ha sido creado con exito");
					}
					//enviamos los atributos a la vista
					request.getSession().setAttribute("message", message);
					response.sendRedirect("inicio");
			}else {//si hay errores de validacion, me los muestra en el mensaje
				
				String error = "";
				for (ConstraintViolation<Usuario> cViolation : violations) {
					
					error += "<p>" + cViolation.getPropertyPath() + ": " + cViolation.getMessage() +  "</p>";
				}
				
				message = new Message("danger", "Lo sentimos, pero sus datos son incorrectos" + error);
				
				//enviamos los atributos a la vista
				request.setAttribute("Usuario", usuario);
				request.setAttribute("message", message);
				
				//ir a la nueva vista
				request.getRequestDispatcher("new_usuario.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			message = new Message("danger", "Lo sentimos, pero ha ocurrido una excepcion, " + e.getMessage());
			e.printStackTrace();
			request.setAttribute("Usuario", usuario);
			request.setAttribute("message", message);
			
			request.getRequestDispatcher("new_usuario.jsp").forward(request, response);
		}
	
	}

}
