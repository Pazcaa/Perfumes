<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
     
<jsp:include page="includes/cabecera.jsp">
	<jsp:param name="pagina" value="inicio" />
 	 <jsp:param name="title" value="Inicio" /> 
</jsp:include>



	<h1 class="text-center display-4 font-weight-normal">Listado de Perfumes</h1>
	
	
	<div class="row">
		<c:forEach items="${Perfumes}" var ="perfume">
		<div class="card">
				 
			    <img src="${perfume.imagen}" class="card-img-top" alt="perfume">
			    <div class="card-body">
			      <h5 class="card-title">${perfume.nombre}</h5>
			      <p class="card-text">${perfume.marca.nombre}</p>
			    </div>
			    <div class="card-footer">
			      <small class="text-muted">${perfume.ml} ml</small>
			    </div>
			   	
			  </div>
</c:forEach>
</div>	



<jsp:include page="includes/pie-pagina.jsp"></jsp:include>