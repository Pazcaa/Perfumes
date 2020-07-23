package controller.frontoffice;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;



import controller.Message;
import modelo.dao.SeguridadException;
import modelo.dao.impl.PerfumeDAOImpl;
import modelo.pojo.Perfume;
import modelo.pojo.Usuario;

/**
 * Servlet implementation class EliminarPerfumeFrontOfficeController
 */
@WebServlet("/views/frontoffice/eliminar_perfume")
public class EliminarPerfumeFrontOfficeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = Logger.getLogger(EliminarPerfumeFrontOfficeController.class);
	private static final PerfumeDAOImpl dao = PerfumeDAOImpl.getInstance();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
		
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String idParameter = request.getParameter("id");
		
		HttpSession session = request.getSession();
		
		Usuario usuario = new Usuario();
		Message message = new Message();
		
		
		try {
			usuario = (Usuario)session.getAttribute("Usuario_login");
			int idUsuario = usuario.getId();
			int idPerfume = Integer.parseInt(idParameter);
			
			
			Perfume perfume = dao.delete(idPerfume, idUsuario);
			message = new Message("success", "Eliminado el perfume " + perfume.getNombre());
			
		}catch (SeguridadException e) {
			LOG.error(" Intentan saltarse la seguridad " + usuario );
			
		} catch (Exception e) {
			message = new Message("danger", "ERROR inesperado ");
			LOG.error(e);
		}finally {
			//Enviar datos a la vista
			
			request.getSession().setAttribute("message", message);
			
			request.getRequestDispatcher("inicio").forward(request, response);
		}
		
	}

}
