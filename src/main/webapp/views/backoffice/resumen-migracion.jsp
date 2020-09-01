<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page errorPage="error.jsp" isErrorPage="false"%>   
    
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
   
<jsp:include page="../../includes/headOffice.jsp">
	 <jsp:param name="pagina" value="migracion" />
 	 <jsp:param name="title" value="Migracion" /> 
</jsp:include>
<jsp:include page="../../includes/navbarOffice.jsp"></jsp:include>

<h1>Proceso de Migracion</h1>
<p>Fichero Leido: ${fichero}</p>
<p>Tiempo (ms): ${tiempo}</p>
<p>Personas Leidas: ${num_lineas}</p>
<p>Personas Insertadas: ${num_insert}</p>
<p>Personas Erroneas: ${num_errores}</p>



<jsp:include page="../../includes/footerOffice.jsp"></jsp:include>
