<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
     
<jsp:include page="includes/cabecera.jsp"></jsp:include>


<div class="container-sm">
	<h1>Tabla de Perfumes</h1>

	<table id="table" class="table-primary table-bordered ">
		<thead class="blockquote text-center">
			<tr>
				<th>id</th>
				<th>Nombre</th>
				<th>ml</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${Perfumes}" var ="perfume">
				<tr>
					<td class="blockquote text-center">${perfume.id}</td>
					<td>${perfume.nombre}</td>
					<td>${perfume.ml}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>


<jsp:include page="includes/pie-pagina.jsp"></jsp:include>