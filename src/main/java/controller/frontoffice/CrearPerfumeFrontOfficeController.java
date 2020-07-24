package controller.frontoffice;

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

import org.apache.log4j.Logger;


import controller.Message;
import modelo.dao.SeguridadException;
import modelo.dao.impl.MarcaDAOImpl;
import modelo.dao.impl.PerfumeDAOImpl;
import modelo.pojo.Marca;
import modelo.pojo.Perfume;
import modelo.pojo.Usuario;

/**
 * Servlet implementation class InicioFrontOfficeController
 */
@WebServlet("/views/frontoffice/crear_perfume")
public class CrearPerfumeFrontOfficeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(CrearPerfumeFrontOfficeController.class);
	private static PerfumeDAOImpl daoPerfume = PerfumeDAOImpl.getInstance(); 
	private static MarcaDAOImpl daoMarca = MarcaDAOImpl.getInstance();
	private static ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	private static Validator validator = factory.getValidator();
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			Perfume perfume = new Perfume();
		// recuperar usuario de session y setearlo en el producto
			HttpSession session = request.getSession();
			Usuario usuario = (Usuario)session.getAttribute("Usuario_login");
			perfume.setUsuario(usuario);
			String view = "formulario.jsp";
		
		
		try {
			String idParameter = request.getParameter("id");
			
			if (idParameter != null) {
				int idPerfume = Integer.parseInt(idParameter);
				int idUsuario = usuario.getId();
				perfume = daoPerfume.getById(idPerfume, idUsuario);
				request.setAttribute("tittle", "Formulario para Modificar perfume");
			
			}else {
				request.setAttribute("perfume", perfume);	
				request.setAttribute("tittle", "Formulario Crear perfume");
			}
			
		}catch (SeguridadException e) {
			view = "/views/frontoffice/inicio";
			LOG.error("Se estan saltando la seguridad " + usuario);
			
		} catch (Exception e) {
			LOG.error(e);
			
		}finally {
			request.setAttribute("perfume", perfume);	
			request.setAttribute("marcas", daoMarca.getAll());
			request.getRequestDispatcher(view).forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//creo mis nuevos atributos
		Perfume perfume = new Perfume();
		Marca marca = new Marca();
		Message message = new Message();
		String view = "formulario.jsp";
		
		//recupero los parametros
		String idParameter = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String mlParameter = request.getParameter("ml");
		String precioParameter = request.getParameter("precio");
		String imagen = request.getParameter("imagen");
		String marcaId = request.getParameter("marca_id");
		
		// recuperar usuario de session y setearlo en el producto
		HttpSession session = request.getSession();
		Usuario usuario = (Usuario)session.getAttribute("Usuario_login");
		
		
		
		try {
			
			int idPerfume = Integer.parseInt(idParameter);
			int idUsuario = usuario.getId();
		
			if (idPerfume !=0) {
				perfume = daoPerfume.getById(idPerfume, idUsuario);// verifico nuevamente que elperfume es del usuario registrado, si no, salta la seguridad
			}
			
			
			int idMarca = Integer.parseInt(marcaId);
			int ml = Integer.parseInt(mlParameter);
			float precio = Float.parseFloat(precioParameter);
			
			perfume.setId(idPerfume);
			perfume.setNombre(nombre);
			perfume.setMl(ml);
			perfume.setPrecio(precio);
			perfume.setImagen(imagen);
			marca.setId(idMarca);
			perfume.setMarca(marca);
			perfume.setUsuario(usuario);
			
			
			
			Set<ConstraintViolation<Perfume>> violations = validator.validate(perfume);
			
			
			if (violations.isEmpty()) { //no hay errores de validación
				
				if (idPerfume == 0) {
					daoPerfume.insert(perfume);
					message = new Message("success", "El perfume ha sido incorporado con exito al listado");
				}else {
					daoPerfume.updateByUser(perfume);
					message = new Message("success", "El perfume ha sido editado con exito al listado");
				}
				//enviamos los atributos a la vista
				request.getSession().setAttribute("message", message);
				//response.sendRedirect("inicio");
				view = "inicio";
				
			}else { //si hay errores de validacion, me los muestra en el mensaje
				
				String error = "";
				for (ConstraintViolation<Perfume> cViolation : violations) {
					
					error += "<p>" + cViolation.getPropertyPath() + ": " + cViolation.getMessage() +  "</p>";
				}
				
				message = new Message("danger", error);
				
				//enviamos los atributos a la vista
				//request.setAttribute("perfume", perfume);
				//request.setAttribute("message", message);
				
				//ir a la nueva vista
				//request.setAttribute("marcas", daoMarca.getAll() );
				//request.getRequestDispatcher(view).forward(request, response);
			}
			
			
		}catch (SeguridadException e) {
			LOG.error(" Intentan saltarse la seguridad " + usuario );
			view = "inicio";
			
		}catch (Exception e) {
			message = new Message("danger", "Lo sentimos, pero ha ocurrido una excepcion, " + e.getMessage());
			LOG.error(e);;
			
		}finally {
			//enviamos los atributos a la vista
			request.setAttribute("perfume", perfume);
			request.setAttribute("message", message);
			request.setAttribute("marcas", daoMarca.getAll() );
			
			//ir a la nueva vista
			request.getRequestDispatcher(view).forward(request, response);
		}

		
	}

}
