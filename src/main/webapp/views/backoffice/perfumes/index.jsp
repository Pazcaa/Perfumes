<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page errorPage="error.jsp" isErrorPage="false"%>   
    
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
   
<jsp:include page="../../../includes/headOffice.jsp">
	 <jsp:param name="pagina" value="perfumes" />
 	 <jsp:param name="title" value="Perfumes" /> 
</jsp:include>
<jsp:include page="../../../includes/navbarBackOffice.jsp"></jsp:include>

<div class="container">

	<h1 class="text-center display-4 font-weight-normal">Listado de Perfumes ${titulo} </h1>
	
	<table id="table" class="table-primary table-bordered ">
		<thead class="blockquote text-center">
			<tr>
				<th>id</th>
				<th>Nombre</th>
				<th>Marca</th>
				<th>Formato (ml)</th>
				<th>Precio</th>
				<th>Usuario</th>
				<th>Imagen</th>
				<th>Operación</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${perfumes}" var ="perfume">
				<tr>
					<td class="blockquote text-center">${perfume.id}</td>
					<td>${perfume.nombre}</td>
					<td>${perfume.marca.nombre}</td>
					<td>${perfume.ml}</td>
					<td>${perfume.precio}</td>
					<td>${perfume.usuario.nombre}</td>
					<td><img class="img-thumbnail img-table" alt="imagen perfume" src="${perfume.imagen}"></td>
					<td class="blockquote text-center">
					 <c:if test="${'Pendientes' eq titulo }">
						<a href="views/backoffice/validar?id=${perfume.id}&validar=1&perfumes=${('Pendientes' eq titulo)? '0':'1'}"><i class="fas fa-calendar-check fa-2x"></i></a>
					 </c:if>
						<a href="views/backoffice/validar?id=${perfume.id}&eliminar=1&perfumes=${('Pendientes' eq titulo)? '0':'1'}" onclick="confirmar('${perfume.nombre}')"><i class="fas fa-trash fa-2x"></i></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</div>
<jsp:include page="../../../includes/footerOffice.jsp"></jsp:include>