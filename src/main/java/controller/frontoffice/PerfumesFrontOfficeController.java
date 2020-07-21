package controller.frontoffice;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import modelo.dao.impl.PerfumeDAOImpl;
import modelo.pojo.Perfume;
import modelo.pojo.Usuario;

/**
 * Servlet implementation class InicioFrontOfficeController
 */
@WebServlet("/views/frontoffice/perfumes")
public class PerfumesFrontOfficeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(PerfumesFrontOfficeController.class);
	private static final PerfumeDAOImpl daoPerfumes = PerfumeDAOImpl.getInstance();
    
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
		
		//Perfume perfume = new Perfume();
		String validar = request.getParameter("validar");
		String tittle = "";
		ArrayList<Perfume> perfumes = new ArrayList<Perfume>();
		
		try {
			
			Usuario usuarioSession = (Usuario) request.getSession().getAttribute("Usuario_login");
			int idUsuario = usuarioSession.getId();
			
			if (validar == null) {
				tittle = "Perfumes Validados";
				perfumes = daoPerfumes.getAllByUser(idUsuario, true);
				
				
				
			}else {
				tittle = "Perfumes por validar";
				perfumes = daoPerfumes.getAllByUser(idUsuario, false);
		
			}
			
		} catch (Exception e) {
			LOG.error(e);

		}finally {
			request.setAttribute("tittle", tittle);
			request.setAttribute("perfumes", perfumes);
			request.getRequestDispatcher("perfumes.jsp").forward(request, response);
			
		}
		
		
		
		
	}

}
