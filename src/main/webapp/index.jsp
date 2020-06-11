<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
     
<jsp:include page="includes/cabecera.jsp">
	<jsp:param name="pagina" value="inicio" />
 	 <jsp:param name="title" value="Listado" /> 
</jsp:include>



	<h1 class="text-center display-4 font-weight-normal">Listado de Perfumes</h1>

	<table id="table" class="table-primary table-bordered ">
		<thead class="blockquote text-center">
			<tr>
				<th>id</th>
				<th>Nombre</th>
				<th>Formato (ml)</th>
				<th>Imagen</th>
				<th>Operación</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${Perfumes}" var ="perfume">
				<tr>
					<td class="blockquote text-center">${perfume.id}</td>
					<td>${perfume.nombre}</td>
					<td>${perfume.ml}</td>
					<td><img class="img-thumbnail img-table" alt="imagen perfume" src="${perfume.imagen}"></td>
					<td class="blockquote text-center"><a href="formulario?id=${perfume.id}"> <i class="fas fa-edit fa-2x"></i></a>
						<a href="eliminar?id=${perfume.id}"><i class="fas fa-trash fa-2x"></i></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>


<jsp:include page="includes/pie-pagina.jsp"></jsp:include>