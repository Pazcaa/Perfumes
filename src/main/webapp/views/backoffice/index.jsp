<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page errorPage="error.jsp" isErrorPage="false"%>   
    
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
   
      
     
<jsp:include page="../../includes/cabecera.jsp">
	<jsp:param name="pagina" value="inicio" />
 	 <jsp:param name="title" value="Inicio" /> 
</jsp:include>

<h1>Bienvenido al Back Office</h1>
<p>Usuario Administrador</p>

<p>Aprobados: ${aprobados}</p>
<p>Pendientes: ${pendientes}</p>




<jsp:include page="../../includes/pie-pagina.jsp"></jsp:include>