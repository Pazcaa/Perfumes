<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
     
<c:if test="${not empty message}">

	<div class="alert alert-${message.tipo} alert-dismissible fade show" role="alert">
	  <strong>${message.texto}</strong>
	  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
	    <span aria-hidden="true">&times;</span>
	  </button>
	</div>
	<% 
	//vamos a poner a null el atributo de sesion justo despues de pintarlo
	session.setAttribute("message", null);
	
	%>
</c:if>



    
    
