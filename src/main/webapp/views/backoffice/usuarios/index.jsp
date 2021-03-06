<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page errorPage="error.jsp" isErrorPage="false"%>   
    
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
   
<jsp:include page="../../../includes/headOffice.jsp">
	 <jsp:param name="pagina" value="usuarios" />
 	 <jsp:param name="title" value="Usuarios" /> 
</jsp:include>
<jsp:include page="../../../includes/navbarBackOffice.jsp"></jsp:include>
<div class="container">
	<h1 class="text-center display-4 font-weight-normal">Listado de Usuarios</h1>
	
		<table id="table" class="table-primary table-bordered ">
			<thead class="blockquote text-center">
				<tr>
					<th>id</th>
					<th>Nombre</th>
					<th>Imagen</th>
					<th>Rol</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${Usuarios}" var ="usuario">
					<tr>
						<td class="blockquote text-center">${usuario.id}</td>
						<td>${usuario.nombre}</td>
						<td><img class="img-thumbnail img-table" alt="imagen perfume" src="${usuario.imagen}"></td>
						<td>${usuario.rol.nombre}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
</div>


<jsp:include page="../../../includes/footerOffice.jsp"></jsp:include>

