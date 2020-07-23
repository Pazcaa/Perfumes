<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page errorPage="error.jsp" isErrorPage="false"%>   
    
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
   
<jsp:include page="../../includes/headOffice.jsp">
	 <jsp:param name="pagina" value="usuario" />
 	 <jsp:param name="title" value="Usuario" /> 
</jsp:include>
<jsp:include page="../../includes/navbarOffice.jsp"></jsp:include>
						
			
                   
<div class="container">		              
 <h1 class="text-center display-4 font-weight-normal">${tittle}</h1>
	<div class="row">
		<div class="col-9">
			<form action="views/frontoffice/crear_perfume" method="post">
				<div class="form-group">		
					<label for="id">Id</label>
					<input type="text" class="form-control" name="id" id="id" value="${perfume.id}"  readonly>
				</div>	
				<div class="form-group">	
					<label for="nombre">Nombre del Perfume</label>
					<input 	type="text" class="form-control"  name="nombre" id="nombre" value="${perfume.nombre}" 
							placeholder="Debe tener entre 3 y 100 caracteres" autofocus required>
				</div>	
				<div class="form-group">
					<label for="ml">Formato (ml)</label>
					<input type="text" class="form-control" name="ml" id="ml" value="${perfume.ml}" placeholder="el formato mas pequeño es de 5 ml" required>
				</div>	
				<div class="form-group">
					<label for="precio">Precio (€)</label>
					<input type="text" class="form-control" name="precio" id="precio" value="${perfume.precio}" placeholder="el precio debe ser mayor a 0" required>
				</div>	
				<div class="form-group">
					<label for="imagen">Imagen del Perfume</label>
					<input type="text" class="form-control" name="imagen" id="imagen" value="${perfume.imagen}" placeholder="ingresar el URL de la imagen" >
				</div>	
				<div class="form-group">
					<label for="marca_id"> Marca:</label>
						<select class="casillas form-control" name="marca_id" id="marca_id">
							<c:forEach items="${marcas}" var="marca" >
								<option value="${marca.id }"  ${ (marca.id eq perfume.marca.id) ? "selected": "" } >${marca.nombre}</option>
							</c:forEach>
						</select>
				</div>
				<div class="form-group">
					<input type="submit" class="btn-primary" name="guardar" value="Guardar">
				</div>
			</form>
		</div>
		<div class="col-3">
			<img class="img-thumbnail img-form"  alt="Imagen Perfume" src="${perfume.imagen}">
		</div>
	</div>
</div>                   

             
             

<jsp:include page="../../includes/footerOffice.jsp"></jsp:include>

