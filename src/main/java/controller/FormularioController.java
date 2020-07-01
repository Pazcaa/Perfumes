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

import modelo.dao.impl.MarcaDAOImpl;
import modelo.dao.impl.PerfumeDAOImpl;
import modelo.pojo.Marca;
import modelo.pojo.Perfume;

/**
 * Servlet implementation class FormularioController
 */
@WebServlet("/formulario")
public class FormularioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static PerfumeDAOImpl daoPerfume = PerfumeDAOImpl.getInstance(); 
	private static MarcaDAOImpl daoMarca = MarcaDAOImpl.getInstance();
	private static ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	private static Validator validator = factory.getValidator();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		Perfume perfume = new Perfume();
		
		
		String idParameter = request.getParameter("id");
		int id = Integer.parseInt(idParameter);
	
			try {
				if (id != 0) {
				request.setAttribute("Perfume", daoPerfume.getById(id));
				}else {
					request.setAttribute("Perfume", perfume);	
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		request.setAttribute("marcas", daoMarca.getAll());
		request.getRequestDispatcher("/views/perfumes/formulario.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		//recupero los parametros
			String idParameter = request.getParameter("id");
			String nombre = request.getParameter("nombre");
			String mlParameter = request.getParameter("ml");
			String imagen = request.getParameter("imagen");
			String marcaId = request.getParameter("marca_id");
			
			int id = Integer.parseInt(idParameter);
			int idMarca = Integer.parseInt(marcaId);
			int ml = Integer.parseInt(mlParameter);
			
			//creo mis nuevos atributos
			Perfume perfume = new Perfume();
			Marca marca = new Marca();
			Message message = new Message();
			
			perfume.setId(id);
			perfume.setNombre(nombre);
			perfume.setMl(ml);
			perfume.setImagen(imagen);
			marca.setId(idMarca);
			perfume.setMarca(marca);
			
			Set<ConstraintViolation<Perfume>> violations = validator.validate(perfume);
			
			
			try {
				
				if (violations.isEmpty()) { //no hay errores de validación
					
					if (id == 0) {
						daoPerfume.insert(perfume);
						message = new Message("success", "El perfume ha sido incorporado con exito al listado");
					}else {
						daoPerfume.update(perfume);
						message = new Message("success", "El perfume ha sido editado con exito al listado");
					}
					//enviamos los atributos a la vista
					request.getSession().setAttribute("message", message);
					response.sendRedirect("inicio");
					
				}else { //si hay errores de validacion, me los muestra en el mensaje
					
					String error = "";
					for (ConstraintViolation<Perfume> cViolation : violations) {
						
						error += "<p>" + cViolation.getPropertyPath() + ": " + cViolation.getMessage() +  "</p>";
					}
					
					message = new Message("danger", error);
					
					//enviamos los atributos a la vista
					request.setAttribute("Perfume", perfume);
					request.setAttribute("message", message);
					
					//ir a la nueva vista
					request.setAttribute("marcas", daoMarca.getAll() );
					request.getRequestDispatcher("/views/perfumes/formulario.jsp").forward(request, response);
				}
				
				
			} catch (Exception e) {
				message = new Message("danger", "Lo sentimos, pero ha ocurrido una excepcion, " + e.getMessage());
				e.printStackTrace();
				
				//enviamos los atributos a la vista
				request.setAttribute("Perfume", perfume);
				request.setAttribute("message", message);
				request.setAttribute("marcas", daoMarca.getAll() );
				
				//ir a la nueva vista
				request.getRequestDispatcher("/views/perfumes/formulario.jsp").forward(request, response);
			}
	
	}

}
