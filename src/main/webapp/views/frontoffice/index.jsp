<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page errorPage="error.jsp" isErrorPage="false"%>   
    
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
   
<jsp:include page="../../includes/headOffice.jsp">
	 <jsp:param name="pagina" value="usuario" />
 	 <jsp:param name="title" value="Usuario" /> 
</jsp:include>
<jsp:include page="../../includes/navbarOffice.jsp"></jsp:include>
						
                
                    <div class="container-fluid">
                        <h1 class="mt-4">Bienvenido</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item active">Tus perfumes</li>
                        </ol>
                        <div class="row">
                        	<div class="col-xl-3 col-md-6"></div>
                            <div class="col-xl-3 col-md-6">
                                <div class="card bg-success text-white mb-4">
                                    <div class="card-body">Aprobados: ${resumen.perfumesAprobados}</div>
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                        <a class="small text-white stretched-link" href="views/frontoffice/perfumes">Detalles</a>
                                        <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-3 col-md-6">
                                <div class="card bg-warning text-white mb-4">
                                    <div class="card-body">Pendientes: ${resumen.perfumesPendientes}</div>
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                        <a class="small text-white stretched-link" href="views/frontoffice/perfumes?validar=0">Detalles</a>
                                        <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-3 col-md-6"></div>
                           
                        </div>
                      
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table mr-1"></i>
                                Total: ${resumen.perfumesTotal}
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                        <thead>
                                            <tr>
                                                <th>id</th>
												<th>Nombre</th>
												<th>Marca</th>
												<th>Formato (ml)</th>
												<th>Precio (€)</th>
												<th>Imagen</th>
												<th>Estado</th>
                                            </tr>
                                        </thead>
                                        <tfoot>
                                            <tr>
                                                <th>id</th>
												<th>Nombre</th>
												<th>Marca</th>
												<th>Formato (ml)</th>
												<th>Precio (€)</th>
												<th>Imagen</th>
												<th>Estado</th>
                                            </tr>
                                        </tfoot>
                                        <tbody>
                                           	<c:forEach items="${perfumesValidos}" var="perfume">
												<tr>
													<td class="blockquote text-center">${perfume.id}</td>
													<td>${perfume.nombre}</td>
													<td>${perfume.marca.nombre}</td>
													<td>${perfume.ml}</td>
													<td>${perfume.precio}</td>
													<td><img class="img-thumbnail img-table" alt="imagen perfume" src="${perfume.imagen}"></td>
													<td> ${tittleAprobados}</td>
												</tr>
											</c:forEach> 
												<c:forEach items="${perfumesPendientes}" var="perfume">
												<tr>
													<td class="blockquote text-center">${perfume.id}</td>
													<td>${perfume.nombre}</td>
													<td>${perfume.marca.nombre}</td>
													<td>${perfume.ml}</td>
													<td>${perfume.precio}</td>
													<td><img class="img-thumbnail img-table" alt="imagen perfume" src="${perfume.imagen}"></td>
													<td> ${tittlePendientes}</td>
												</tr>
											</c:forEach>                                          
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
             

<jsp:include page="../../includes/footerOffice.jsp"></jsp:include>

