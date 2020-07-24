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
import modelo.pojo.ResumenUsuario;
import modelo.pojo.Usuario;

/**
 * Servlet implementation class InicioFrontOfficeController
 */
@WebServlet("/views/frontoffice/inicio")
public class InicioFrontOfficeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final static Logger LOG = Logger.getLogger(InicioFrontOfficeController.class);
	private static final PerfumeDAOImpl daoPerfume = PerfumeDAOImpl.getInstance(); 
       
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	Usuario usarioSession = (Usuario) request.getSession().getAttribute("Usuario_login");
	int idUsuario = usarioSession.getId();
	
	// ArrayList<Perfume> aprobados =daoPerfume.getAllByUser(idUsuario, true);
	// ArrayList<Perfume> pendientes =daoPerfume.getAllByUser(idUsuario, false);
	//request.setAttribute("aprobados", aprobados.size());
	//request.setAttribute("pendientes", pendientes.size());
	
	ResumenUsuario resumen = daoPerfume.getResumenByUsuario(idUsuario);
	ArrayList<Perfume> perfumesValidos = new ArrayList<Perfume>();
	ArrayList<Perfume> perfumesPendientes = new ArrayList<Perfume>();
	//ArrayList<Perfume> perfumes = new ArrayList<Perfume>();
	
	perfumesValidos = daoPerfume.getAllByUser(idUsuario, true);
	String tittleAprobados = "Aprobado";
	perfumesPendientes = daoPerfume.getAllByUser(idUsuario, false);
	String tittlePendientes = "Pendiente";
	
	//perfumes.addAll(perfumesValidos);
	//perfumes.addAll(perfumesPendientes);
	
	request.setAttribute("resumen", resumen);
	//request.setAttribute("perfumes", perfumes);
	request.setAttribute("perfumesValidos", perfumesValidos);
	request.setAttribute("perfumesPendientes", perfumesPendientes);
	request.setAttribute("tittleAprobados", tittleAprobados);
	request.setAttribute("tittlePendientes", tittlePendientes);
	
		
		
		//para hacer fordward coje el webservlet ("/views/frontoffice/inicio") y reemplaza la ultima parte por la request
		// quedando la ruta "/views/frontoffice/index.jsp"
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
