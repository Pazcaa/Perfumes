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

import org.apache.log4j.Logger;


import modelo.dao.impl.UsuarioDAOImpl;
import modelo.pojo.Rol;
import modelo.pojo.Usuario;

/**
 * Controlador para la creación de nuevos usuarios.
 */
@WebServlet("/registro")
public class CrearUsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = Logger.getLogger(CrearUsuarioController.class);
	private static UsuarioDAOImpl daoUsuario = UsuarioDAOImpl.getInstance();
	private static ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	private static Validator validator = factory.getValidator();

 
	/**
	 * Presenta un formulario para poder crear un nuevo usuario
	 * Parametros:
	 * <dl>
	 * 		<dt>no recibe ninguno </dt>
	 * 		<dd></dd>
	 * </dl>
	 * Atributos:
	 *  <dl>
	 * 		<dt>usuario</dt>
	 * 		<dd>nuevo Usuario()</dd>
	 * </dl>
	 * 
	 * Finalmente hace un forward hacia "/views/new_usuario.jsp"
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Usuario usuario = new Usuario();
			
		request.setAttribute("usuario", usuario);
		
		//request.setAttribute("Rol", daoRol.getAll());
		
		request.getRequestDispatcher("/views/new_usuario.jsp").forward(request, response);
	}

	/**
	 * Recoge los valores ingresado por medio de los parametros en el formulario existente, 
	 * realizando una validación de los nuevos datos del pojo usuario().
	 * Parametros:
	 * <dl>
	 * 		<dt>nombre</dt>
	 * 			<dd>String con el nombre de usuario</dd>
	 * 		<dt>password</dt>
	 * 			<dd>String de la password codificada en MD5</dd>
	 * 		<dt>repassword</dt>
	 * 			<dd>String confirmación de la password, codificada en MD5</dd>
	 * 		<dt>imagen</dt>
	 * 			<dd>String con la url de la imagen del usuario</dd>
	 * </dl>
	 * Atributos:
	 *  <dl>
	 * 		<dt>usuario</dt>
	 * 			<dd>pojo con la información del nuevo Usuario() creado</dd>
	 * 		<dt>message</dt>
	 * 			<dd>Mensaje automatico que indica si la accion de inserción se ha realizado con exito o ha tenido problemas</dd>
	 * </dl>
	 * 
	 * Finalmente hace un forward hacia "/views/new_usuario.jsp" en caso de no haber realizado la inserción, o una redirección a la pagina inicial por medio de un SendRedirect 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombre = request.getParameter("nombre");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		String imagen = request.getParameter("imagen");
		
		
		int id 		= 1;
		boolean isError = true; //==> me indica si hay diferencia entre el password y el repassword
		
		//creo nuevos atributos
		Usuario usuario = new Usuario();
		Message message = new Message();
		Rol rol = new Rol();
		
		
		usuario.setNombre(nombre);
		usuario.setPassword(password);
		usuario.setImagen(imagen);
		
		rol.setId(id);
		usuario.setRol(rol);
		
		
		Set<ConstraintViolation<Usuario>> violations = validator.validate(usuario);
		
		try {
			
			if (violations.isEmpty()) { //no hay errores de validacion
				
				if (password.equals(repassword)) {
					
					try {
						daoUsuario.insert(usuario);
						isError = false;
						LOG.info("Usuario" + usuario +" registrado");
						
						message = new Message( "success", "Se ha registrado con exito");
						
					} catch (Exception e) {
						message = new Message( "danger", "Usuario ya existente");
					}
					
						
				}else {
					
					request.setAttribute("usuario", usuario);
					message = new Message( "warning", "La confirmación de la contraseña no es carrecta");
					
				}
				
				
			}else {//si hay errores de validacion, me los muestra en el mensaje
				
				String error = "";
				for (ConstraintViolation<Usuario> cViolation : violations) {
					
					error += "<p>" + cViolation.getPropertyPath() + ": " + cViolation.getMessage() +  "</p>";
				}
				
				message = new Message("danger", "Lo sentimos, pero sus datos son incorrectos" + error);
				
				//enviamos los atributos a la vista
				request.setAttribute("usuario", usuario);
				request.setAttribute("message", message);
				
				//ir a la nueva vista
				request.getRequestDispatcher("/views/new_usuario.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			message = new Message("danger", "Lo sentimos, pero ha ocurrido una excepcion, " + e.getMessage());
			e.printStackTrace();
			
		}finally {
			
			if (isError) {
				request.setAttribute("usuario", usuario); // volvemos a enviar el parametro como atributo
				request.setAttribute("message", message);
				request.getRequestDispatcher("views/new_usuario.jsp").forward(request, response);
			}else {
				request.setAttribute("message", message);
				response.sendRedirect(request.getContextPath() + "/login");
			}
			request.getSession().setAttribute("message", message);
		}	
			
	}

}
