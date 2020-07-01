package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;


import modelo.dao.impl.MarcaDAOImpl;
import modelo.pojo.Marca;

/**
 * Servlet implementation class MarcasController
 */
@WebServlet("/marcas")
public class MarcasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private final static Logger LOG = Logger.getLogger(MarcasController.class);
    
    private static final MarcaDAOImpl marcaDAO = MarcaDAOImpl.getInstance();
    
    private static final String VIEW_TABLA = "/views/marcas/index.jsp";
    private static final String VIEW_FORMULARIO = "/views/marcas/formulario.jsp";
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String view = VIEW_TABLA;
		String idParameter = request.getParameter("id");
		String eliminarParameter = request.getParameter("eliminar");
		
		Message message = new Message();
		Marca marca = new Marca();
		
		try {
			
			if (idParameter != null) {
				int id = Integer.parseInt(idParameter);
				
				if (eliminarParameter != null) {
					
					marca = marcaDAO.delete(id);
					view = VIEW_TABLA;
					message = new Message("success", "La marca " + marca.getNombre() + " se ha eliminado con exito");
					
				}else {
					
					marca = marcaDAO.getById(id);
					view = VIEW_FORMULARIO;
				}
			}
			
		} catch (Exception e) {
			LOG.error(e);
			message = new Message("danger", "No se puede eliminar la Categoria si tiene productos asociados");
		}finally {
			
			request.setAttribute("message", message);
			request.setAttribute("Marca", marca);
			request.setAttribute("Marcas", marcaDAO.getAll());
			request.getRequestDispatcher(view).forward(request, response);
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idParameter = request.getParameter("id");
		String nombreParameter = request.getParameter("nombre");
		
		Message message = new Message();
		Marca marca = new Marca();
		
		try {
			
			int id = Integer.parseInt(idParameter);
			marca.setId(id);
			marca.setNombre(nombreParameter);
			
			if (id != 0) {
				marca = marcaDAO.update(marca);	
				message = new Message ("success", "Su registro se ha modificado correctamente");
				
			}else {
				marca = marcaDAO.insert(marca);
				message = new Message ("success", "Su registro se ha creado correctamente");
				
			}
			
		} catch (Exception e) {
			LOG.error(e);
			message = new Message("warning", "Lo sentimos pero la marca <b>" + marca.getNombre() + "</b> ya esta registrada");
			
		}finally {
			
			request.setAttribute("message", message);
			request.setAttribute("Marca", marca);
			request.getRequestDispatcher(VIEW_FORMULARIO).forward(request, response);
		}
		
	}

}
