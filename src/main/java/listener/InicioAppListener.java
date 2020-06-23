package listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;



import controller.Message;
import modelo.dao.MarcaDAOImpl;

/**
 * Application Lifecycle Listener implementation class InicioAppListener
 *
 */
@WebListener
public class InicioAppListener implements ServletContextListener {
	static private final MarcaDAOImpl marcaDAO = MarcaDAOImpl.getInstance();

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
    	// cuando paramos la App
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	  // cuando ejecutamos la App en el Servidor, al arrancar la 1º vez
    	System.out.println("Estamos arrancado la App, y soy un evento");
    	
    	
    	// Este contexto es para toda la Aplicacion y es accesible desde cualñquier JSP o Servlet    	
    	ServletContext contextoAplicacion = sce.getServletContext();
    	
    	try {
    	
    		contextoAplicacion.setAttribute("Marcas", marcaDAO.getAll() );
    		
    	}catch (Exception e) {
    		contextoAplicacion.setAttribute("message", new Message("danger", "Tenemos un problema sin determinar") );
		}	
    }
	
}
