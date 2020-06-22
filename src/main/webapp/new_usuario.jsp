<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
     
<jsp:include page="includes/cabecera.jsp">
	<jsp:param name="pagina" value="usuarios" />
 	 <jsp:param name="title" value="Usuarios" /> 
</jsp:include>

	<h1 class="text-center display-4 font-weight-normal">Formulario Nuevo Usuario</h1>
	<div class="row">
		<div class="col-9">
			<form action="new_login" method="post">
				<div class="form-group">		
					<label for="id">Id</label>
					<input type="text" class="form-control" name="id" id="id" value="${Usuario.id}"  readonly>
				</div>	
				<div class="form-group">	
					<label for="nombre">Nombre de Usuario</label>
					<input 	type="text" class="form-control"  name="nombre" id="nombre" value="${Usuario.nombre}" 
							placeholder="Debe tener entre 2 y 100 caracteres" autofocus required>
				</div>	
				<div class="form-group">
					<label for="password">Contraseña</label>
					<input type="password" class="form-control" name="password" id="password" value="${Usuario.password}" placeholder="el formato mas pequeño es de 5 ml" required>
				</div>	
				<div class="form-group">
					<label for="imagen">Imagen del Usuario</label>
					<input type="text" class="form-control" name="imagen" id="imagen" value="${Usuario.imagen}" placeholder="ingresar el URL de la imagen" >
				</div>	
				<div class="form-group">
					<input type="submit" class="btn-primary" name="guardar" value="Guardar">
				</div>
			</form>
		</div>
		<div class="col-3">
			<img class="img-thumbnail img-form"  alt="Imagen Perfume" src="${Usuario.imagen}">
		</div>
	</div>






<jsp:include page="includes/pie-pagina.jsp"></jsp:include>

