<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page errorPage="error.jsp" isErrorPage="false"%>   
    
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
     
<jsp:include page="../includes/cabecera.jsp">
	<jsp:param name="pagina" value="login" />
 	<jsp:param name="title" value="Login" /> 
</jsp:include>

<h1 class="text-center display-4 font-weight-normal">Iniciar Sesion</h1>

<div id="login">
	<form action="login" method="post" onsubmit="cifrar()">
	
		<div class="form-group">	
			<label for="nombre">Nombre de Usuario</label>
			<input 	type="text" class="form-control"  name="nombre" id="nombre" value="${Usuario_login.nombre}" 
								placeholder="Debe tener entre 3 y 100 caracteres" autofocus required>
		</div>	
		<div class="form-group">
			<label for="password">Password</label>
			<input type="password" class="form-control" name="password" id="password" value="${Usuario_login.password}" placeholder="debe contener entre 4 y 10 caracteres" required >
			<i class="fas fa-eye" onclick="showHidePass('password')"></i>
		</div>	
		<div class="form-group">
			<input type="submit" class="btn-primary" name="login" value="Iniciar Sesion">
		</div>
	</form>
	
	<p>¿No eres usuario aún? Registrate <a href="registro">Aquí</a></p>
	
</div>




<jsp:include page="../includes/pie-pagina.jsp"></jsp:include>
