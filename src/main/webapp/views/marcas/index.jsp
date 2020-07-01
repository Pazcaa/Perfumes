<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
     
<jsp:include page="../../includes/cabecera.jsp">
	<jsp:param name="pagina" value="marcas" />
 	 <jsp:param name="title" value="Marcas" /> 
</jsp:include>


<h1 class="text-center display-4 font-weight-normal">Listado de Marcas</h1>

<h3><a class="btn btn-primary" href="marcas?id=0">Crear Nueva Marca</a></h3>
	
	<table id="table" class="table-primary table-bordered ">
		<thead class="blockquote text-center">
			<tr>
				<th>id</th>
				<th>Marca</th>
				<th>Operación</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${Marcas}" var ="marca">
				<tr>
					<td class="blockquote text-center">${marca.id}</td>
					<td>${marca.nombre}</td>
					<td class="blockquote text-center"><a href="marcas?id=${marca.id}"> <i class="fas fa-edit fa-2x"></i></a>
						<a href="marcas?id=${marca.id}&eliminar=1" onclick="confirmar('${marca.nombre}')"><i class="fas fa-trash fa-2x"></i></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>









<jsp:include page="../../includes/pie-pagina.jsp"></jsp:include>