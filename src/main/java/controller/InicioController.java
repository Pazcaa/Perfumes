package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import modelo.dao.impl.MarcaDAOImpl;
import modelo.dao.impl.PerfumeDAOImpl;
import modelo.pojo.Perfume;

/**
 * Servlet implementation class PerfumeController
 */
@WebServlet("/inicio")
public class InicioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(InicioController.class);
	private static PerfumeDAOImpl perfumeDAO = PerfumeDAOImpl.getInstance();
	private static MarcaDAOImpl marcaDAO = MarcaDAOImpl.getInstance();

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
		
		String idParameter = request.getParameter("idMarca");
		String nombreParameter = (request.getParameter("nombreMarca") == null) ? "todas las marcas" : request.getParameter("nombreMarca");
		
		ArrayList<Perfume> perfumes = new ArrayList<Perfume>();
		
		try {
			if (idParameter != null) {
				int idMarca = Integer.parseInt(idParameter);
				//request.setAttribute("Perfumes", perfumeDAO.getAllByMarca(idMarca, 10));
				perfumes = perfumeDAO.getAllByMarca(idMarca, 10);
				
				}else {
					//request.setAttribute("Perfumes", perfumeDAO.getAll());
					//request.setAttribute("Perfumes", perfumeDAO.getLast(10));
					perfumes = perfumeDAO.getLast(10);
				}
			
		} catch (Exception e) {
			LOG.error(e);
		}finally {
			request.setAttribute("Perfumes", perfumes);
			request.setAttribute("encabezado1", "<b>" + perfumes.size() + "</b>");
			request.setAttribute("encabezado2", "<b>" + nombreParameter + "</b>");
			request.setAttribute("Marcas", marcaDAO.getAll());
			//request.setAttribute("Perfumes", perfumeDAO.getAll());
			request.getRequestDispatcher("/views/perfumes/index.jsp").forward(request, response);
		}
		
		
		
		
		
		
	}

}
