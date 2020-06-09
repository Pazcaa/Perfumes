<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
     
<jsp:include page="includes/cabecera.jsp"></jsp:include>



	<h1 class="text-center display-4 font-weight-normal">Listado de Perfumes</h1>

	<table id="table" class="table-primary table-bordered ">
		<thead class="blockquote text-center">
			<tr>
				<th>id</th>
				<th>Nombre</th>
				<th>ml</th>
				<th>imagen</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${Perfumes}" var ="perfume">
				<tr>
					<td class="blockquote text-center">${perfume.id}</td>
					<td>${perfume.nombre}</td>
					<td>${perfume.ml}</td>
					<td><img class="img-thumbnail img-table" alt="imagen perfume" src="${perfume.imagen}"></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>


<jsp:include page="includes/pie-pagina.jsp"></jsp:include>