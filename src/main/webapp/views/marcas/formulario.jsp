<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page errorPage="error.jsp" isErrorPage="false"%>   
    
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
     
<jsp:include page="../../includes/cabecera.jsp">
	<jsp:param name="pagina" value="marcas" />
 	 <jsp:param name="title" value="Marcas" /> 
</jsp:include>

      
      <h1 class="text-center display-4 font-weight-normal">Formulario Marca</h1>
      
	
		<div id="formulario">
			<form action="marcas" method="post">
			
				<div class="form-group">		
					<label for="id">Id</label>
					<input type="text" class="form-control" name="id" id="id" value="${Marca.id}"  readonly>
				</div>	
				<div class="form-group">	
					<label for="nombre">Nombre de la Marca</label>
					<input 	type="text" class="form-control"  name="nombre" id="nombre" value="${Marca.nombre}" 
							placeholder="Debe tener entre 3 y 100 caracteres" autofocus required>
				</div>		
				<div class="form-group">
					<input type="submit" class="btn-primary" name="guardar" value="Guardar">
				</div>
			</form>
		</div>



<jsp:include page="../../includes/pie-pagina.jsp"></jsp:include>