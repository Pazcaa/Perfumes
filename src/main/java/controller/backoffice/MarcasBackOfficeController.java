package controller.backoffice;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import modelo.dao.impl.MarcaDAOImpl;
import modelo.pojo.Marca;

/**
 * Servlet implementation class MarcasBackOfficeController
 */
@WebServlet("/views/backoffice/marcas")
public class MarcasBackOfficeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(MarcasBackOfficeController.class);
	private static final MarcaDAOImpl dao = MarcaDAOImpl.getInstance();
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.trace("Listado categorias");

		//TODO llamar a un Procedimiento almacenado
		ArrayList<Marca> listado = dao.getAll();

		request.setAttribute("marcas", listado );

		// como el controlador escucha en la url "/views/backoffice/categoria"
		// para hacer el forward pierde la utima parte de la url "categoria" y debemos añadir la caroeta donde esta la index de las categorias
		// /views/backoffice/ + categoria/index.jsp
		request.getRequestDispatcher("marcas/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
