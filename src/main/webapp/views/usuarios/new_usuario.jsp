<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page errorPage="error.jsp" isErrorPage="false"%>   
    
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
     
<jsp:include page="../../includes/cabecera.jsp">
	<jsp:param name="pagina" value="usuarios" />
 	 <jsp:param name="title" value="Usuarios" /> 
</jsp:include>

	<h1 class="text-center display-4 font-weight-normal">Formulario Nuevo Usuario</h1>
	<div class="row">
		<div class="col-9">
			<form action="new_login" method="post">
				
				<div class="form-group">	
					<label for="nombre">Nombre de Usuario</label>
					<input 	type="text" class="form-control"  name="nombre" id="nombre" value="${usuario.nombre}" 
							placeholder="Debe tener entre 2 y 100 caracteres" autofocus required>
				</div>	
				<div class="form-group">
					<label for="password">Contraseña</label>
					<input type="password" class="form-control" name="password" id="password" value="" placeholder="debe contener al menos 4 caracteres" required>
				</div>
				
				<div class="form-group">
					<label for="repassword">Repetir Contraseña</label>
					<input type="password" class="form-control" name="repassword" id="repassword" value="" placeholder="repetir contraseña" required>
				</div>
					
				<div class="form-group">
					<label for="imagen">Imagen del Usuario</label>
					<input type="text" class="form-control" name="imagen" id="imagen" value="${usuario.imagen}" placeholder="ingresar el URL de la imagen" >
				</div>	
				
				<div class="form-group">
					<input type="submit" class="btn-primary" name="guardar" value="Guardar">
				</div>
			</form>
		</div>
		<div class="col-3">
			<img class="img-thumbnail img-form"  alt="Imagen Usuario" src="${usuario.imagen}">
		</div>
	</div>






<jsp:include page="../../includes/pie-pagina.jsp"></jsp:include>

