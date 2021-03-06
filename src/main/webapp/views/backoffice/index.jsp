<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page errorPage="error.jsp" isErrorPage="false"%>   
    
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
   
<jsp:include page="../../includes/headOffice.jsp">
	 <jsp:param name="pagina" value="administrador" />
 	 <jsp:param name="title" value="Admnistrador" /> 
</jsp:include>
<jsp:include page="../../includes/navbarBackOffice.jsp"></jsp:include>

<div class="container-fluid">
<h1>Bienvenido al Back Office</h1>


<div class="row">
            
             	<div class="col-xl-3 col-md-6">
                    <div class="card bg-primary text-white mb-4 position-relative">
                        <div class="card-body">Total de Perfumes reigistrados: <span class="big-number">${resumen.perfumesTotal}</span></div>
                        <div class="card-footer d-flex align-items-center justify-content-between">
                            <a class="small text-white stretched-link" href="#">Ver Detalle</a>
                            <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                        </div>
                    </div>
                </div>  
                
                <div class="col-xl-3 col-md-6">
                    <div class="card bg-danger text-white mb-4 position-relative">
                        <div class="card-body">Perfumes Pendientes de Validar: <span class="big-number">${resumen.perfumesPendientes}</span></div>
                        <div class="card-footer d-flex align-items-center justify-content-between">
                            <a class="small text-white stretched-link" href="#">Ver Detalle</a>
                            <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                        </div>
                    </div>
                </div>  
                
                  <div class="col-xl-3 col-md-6">
                    <div class="card bg-warning text-white mb-4 position-relative">
                        <div class="card-body">Perfumes Validados: <span class="big-number">${resumen.perfumesAprobados}</span></div>
                        <div class="card-footer d-flex align-items-center justify-content-between">
                            <a class="small text-white stretched-link" href="#">Ver Detalle</a>
                            <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                        </div>
                    </div>
                </div> 
                
 </div> 

<div class="row">
                
                <div class="col-xl-3 col-md-6">
                    <div class="card bg-info text-white mb-4 position-relative">
                        <div class="card-body">Usuarios: <span class="big-number">${resumen.marcasTotal}</span></div>
                        <div class="card-footer d-flex align-items-center justify-content-between">
                            <a class="small text-white stretched-link" href="#">Ver Detalle</a>
                            <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                        </div>
                    </div>
                </div> 
                
                <div class="col-xl-3 col-md-6">
                    <div class="card bg-success text-white mb-4 position-relative">
                        <div class="card-body">Categorias: <span class="big-number">${resumen.usuariosTotal}</span></div>
                        <div class="card-footer d-flex align-items-center justify-content-between">
                            <a class="small text-white stretched-link" href="#">Ver Detalle</a>
                            <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                        </div>
                    </div>
                </div>  
                
                
 </div>                

<h2>Usuario Logeados</h2>
 <div class="row">
	
	<div class="col">
		<ul class="list-group">
		  <c:forEach items="${usuariosLogeados}" var="ul">	
		  	<li class="list-group-item">${ul.key} - ${ul.value.id} ${ul.value.nombre}</li>
		  </c:forEach>		 
		</ul>
	</div>

</div>


<a href="views/backoffice/migracion">Enlace para ver datos de migracion</a>

</div>

<jsp:include page="../../includes/footerOffice.jsp"></jsp:include>