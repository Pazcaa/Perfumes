<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
     
<jsp:include page="includes/cabecera.jsp">
	<jsp:param name="pagina" value="formulario" />
 	<jsp:param name="title" value="Formulario" /> 
</jsp:include>


	<h1 class="text-center display-4 font-weight-normal">Formulario Nuevo Perfume</h1>
	<div class="row">
		<div class="col-9">
			<form action="formulario" method="post">
				<div class="form-group">		
					<label for="id">Id</label>
					<input type="text" class="form-control" name="id" id="id" value="${Perfume.id}"  readonly>
				</div>	
				<div class="form-group">	
					<label for="nombre">Nombre del Perfume</label>
					<input type="text" class="form-control"  name="nombre" id="nombre" value="${Perfume.nombre}" autofocus required>
				</div>	
				<div class="form-group">
					<label for="ml">Formato (ml)</label>
					<input type="text" class="form-control" name="ml" id="ml" value="${Perfume.ml}" required>
				</div>	
				<div class="form-group">
					<label for="imagen">Imagen del Perfume</label>
					<input type="text" class="form-control" name="imagen" id="imagen" value="${Perfume.imagen}" >
				</div>	
				<div class="form-group">
					<input type="submit" class="btn-primary" name="guardar" value="Guardar">
				</div>
			</form>
		</div>
		<div class="col-3">
			<img class="img-thumbnail img-form"  alt="Imagen Perfume" src="${Perfume.imagen}">
		</div>
	</div>



<jsp:include page="includes/pie-pagina.jsp"></jsp:include>

