package controller;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import modelo.dao.impl.UsuarioDAOImpl;
import modelo.pojo.Usuario;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UsuarioDAOImpl dao = UsuarioDAOImpl.getInstance();
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Usuario usuario = new Usuario();
		
		request.setAttribute("Usuario_login", usuario);
		
		request.getRequestDispatcher("/views/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//parametros de entrada
		String nombre = request.getParameter("nombre");
		String password = request.getParameter("password");
		
			//establezco sesion
			HttpSession session = request.getSession();
	
			//recupero el usuario
			Usuario usuario = dao.existe(nombre, password);
			
			if (usuario != null ) {
					
					session.setMaxInactiveInterval(60 * 5);//tras 5 min sin peticiones se desconecta automaticamente
					session.setAttribute("Usuario_login", usuario);
					
					request.setAttribute("message", new Message("success", usuario.getNombre() + " se ha conectado con exito"));
					request.getRequestDispatcher("inicio").forward(request, response);
				
				
			}else {
				request.setAttribute("message",new Message("danger", "Sus datos son incorrectos, vuelva a intentarlo"));
				request.getRequestDispatcher("/views/login.jsp").forward(request, response);	
			}
		
	}
		
}
