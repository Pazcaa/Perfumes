package controller.backoffice;

import java.io.IOException;
import java.util.ArrayList;
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

import org.apache.log4j.Logger;

import controller.Message;
import modelo.dao.SeguridadException;
import modelo.dao.impl.MarcaDAOImpl;
import modelo.dao.impl.PerfumeDAOImpl;
import modelo.pojo.Marca;
import modelo.pojo.Perfume;
import modelo.pojo.Usuario;

/**
 * Servlet implementation class ValidarPerfumeBackOffice
 */
@WebServlet("/views/backoffice/validar")
public class ValidarPerfumeBackOffice extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = Logger.getLogger(ValidarPerfumeBackOffice.class);
	private static final PerfumeDAOImpl daoPerfume = PerfumeDAOImpl.getInstance();
	private static final MarcaDAOImpl daoMarca = MarcaDAOImpl.getInstance();
	private static final String VIEW_TABLA_PENDIENTES = "perfumes?perfumes=0";
	private static final String VIEW_TABLA_VALIDADOS = "perfumes?perfumes=1";
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.trace("Listado categorias");

		String view = VIEW_TABLA_PENDIENTES;
		String idParameter = request.getParameter("id");
		String eliminarParameter = request.getParameter("eliminar");
		
		String validarParameter = request.getParameter("validar");
		int perfumesParameter = Integer.parseInt(request.getParameter("perfumes"));
		
		Message message = new Message();
		Perfume perfume = new Perfume();
		
		
		try {
			
			if (idParameter != null) {
				int id = Integer.parseInt(idParameter);
				
				if (eliminarParameter != null) {
					
					perfume = daoPerfume.delete(id);
					message = new Message("success", "El perfume " + perfume.getNombre() + " se ha eliminado con exito");
					
					if (perfumesParameter == 0) {
						view = VIEW_TABLA_PENDIENTES;
					}else {
						view = VIEW_TABLA_VALIDADOS;
					}
					
				} if (validarParameter != null) {
					
					perfume = daoPerfume.validar(id);
					message = new Message("success", "El perfume " + perfume.getNombre() + " se validado con exito");
					
					if (perfumesParameter == 0) {
						view = VIEW_TABLA_PENDIENTES;
					}else {
						view = VIEW_TABLA_VALIDADOS;
					}
				}
			}
			
		} catch (Exception e) {
			LOG.error(e);
			message = new Message("danger", "No se puede realizar la accion señalada");
		}finally {
			
			request.setAttribute("message", message);
			request.setAttribute("perfume", perfume);
			
			request.getRequestDispatcher(view).forward(request, response);
			
		}	

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}	
}
