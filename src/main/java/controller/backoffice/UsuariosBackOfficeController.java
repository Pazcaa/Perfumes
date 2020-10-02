package controller.backoffice;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import modelo.dao.impl.UsuarioDAOImpl;
import modelo.pojo.Usuario;

/**
 * Servlet implementation class UsuariosBackOfficeController
 */
@WebServlet("/views/backoffice/usuarios")
public class UsuariosBackOfficeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(UsuariosBackOfficeController.class);
	private final static UsuarioDAOImpl daoUsuario = UsuarioDAOImpl.getInstance();
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Usuario> usuarios = daoUsuario.getAll();
		
		request.setAttribute("Usuarios", usuarios);
		
		request.getRequestDispatcher("usuarios/index.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
