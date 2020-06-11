<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
     
<jsp:include page="includes/cabecera.jsp">
	<jsp:param name="pagina" value="eliminar" />
 	<jsp:param name="title" value="Eliminar" /> 
</jsp:include>

<h1 class="text-center display-4 font-weight-normal">Eliminar Perfume</h1>

<form action="eliminar" method="post">
	<div class="row">
		<div class="col-9">
		<p>¿estas seguro que deseas eliminar este perfume?</p>
			<form action="formulario" method="post">
				<div class="form-group">		
					<label for="id">Id</label>
					<input type="text" class="form-control" name="id" id="id" value="${Perfume.id}"  readonly>
				</div>	
				<div class="form-group">	
					<label for="nombre">Nombre del Perfume</label>
					<input type="text" class="form-control"  name="nombre" id="nombre" value="${Perfume.nombre}" readonly>
				</div>	
				<div class="form-group">
					<label for="ml">Formato (ml)</label>
					<input type="text" class="form-control" name="ml" id="ml" value="${Perfume.ml}" readonly>
				</div>	
				
				<p>Si estas deacuerdo, selecciona "Eliminar", en caso contrario "Cancelar Operación"</p>
	
				<div class="form-group">	
					<label for="alternativa"></label>
					<select class="casillas" name="alternativa" id="alternativa">
						<option value="eliminar" >Eliminar</option>
						<option value="cancelar" selected >Cancelar Operación</option>	
					</select>
					<input type="submit" class="btn-primary" value="Enviar">
				</div>			
			</form>
		</div>
		<div class="col-3">
			<img class="img-thumbnail img-form"  alt="Imagen Perfume" src="${Perfume.imagen}">
		</div>
	</div>

</form>




<jsp:include page="includes/pie-pagina.jsp"></jsp:include>

