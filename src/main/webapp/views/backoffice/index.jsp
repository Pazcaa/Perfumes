<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page errorPage="error.jsp" isErrorPage="false"%>   
    
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
   
<jsp:include page="../../includes/headOffice.jsp">
	 <jsp:param name="pagina" value="usuario" />
 	 <jsp:param name="title" value="Usuario" /> 
</jsp:include>
<jsp:include page="../../includes/navbarOffice.jsp"></jsp:include>

<h1>Bienvenido al Back Office</h1>
<p>Usuario Administrador</p>

<p>Aprobados: ${aprobados}</p>
<p>Pendientes: ${pendientes}</p>

<a href="views/backoffice/migracion">Enlace para ver datos de migracion</a>




<jsp:include page="../../includes/footerOffice.jsp"></jsp:include>