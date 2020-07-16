<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
   
      
     
<jsp:include page="../includes/cabecera.jsp">
	<jsp:param name="pagina" value="inicio" />
 	 <jsp:param name="title" value="Inicio" /> 
</jsp:include>


<h1>Error 404</h1>

<p>Lo sentimos pero la URL indicada no existe</p>
<p>Por favor pongase en contacto con el administrador</p>


 <jsp:include page="../includes/pie-pagina.jsp"></jsp:include>