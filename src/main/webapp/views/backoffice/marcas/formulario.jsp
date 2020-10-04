<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page errorPage="error.jsp" isErrorPage="false"%>   
    
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
   
<jsp:include page="../../../includes/headOffice.jsp">
	 <jsp:param name="pagina" value="formulario" />
 	 <jsp:param name="title" value="Formulario" /> 
</jsp:include>
<jsp:include page="../../../includes/navbarBackOffice.jsp"></jsp:include>

<div class="container">

 <h1 class="text-center display-4 font-weight-normal">Formulario para Marcas</h1>

		<div id="formulario">
			<form action="views/backoffice/marcas" method="post">
			
				<div class="form-group">		
					<label for="id">Id</label>
					<input type="text" class="form-control" name="id" id="id" value="${marca.id}"  readonly>
				</div>	
				<div class="form-group">	
					<label for="nombre">Nombre de la Marca</label>
					<input 	type="text" class="form-control"  name="nombre" id="nombre" value="${marca.nombre}" 
							placeholder="Debe tener entre 3 y 100 caracteres" autofocus required>
				</div>		
				<div class="form-group">
					<input type="submit" class="btn-primary" name="guardar" value="Guardar">
				</div>
			</form>
		</div>
	
 

</div>

<jsp:include page="../../../includes/footerOffice.jsp"></jsp:include>