<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    
<!DOCTYPE html>
<html>
<head>
  <!-- Required meta tags -->
     <meta charset="utf-8">
     <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
 
     <!-- Bootstrap CSS -->
     <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
         integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

 		<!-- Font Awesome -->
     <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">
     
      <!-- datatables -->
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css">
    
     <!-- datatables -->
    <link rel="stylesheet" href="css/styles.css">

    
<title>${param.title} |Perfumes</title>
</head>
<body>
	<header class="bg-dark shadow-sm">
	
	<div class="container d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3">
	  <h5 class="my-0 mr-md-auto font-weight-normal text-primary"><a href="inicio"><i class="far fa-gem fa-lg"></i><i class="fas fa-gem fa-lg"></i><i class="far fa-gem fa-lg"></i></a></h5>
	<div class="dropdown">
		  <button class="btn btn-outline-primary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		    Marcas
		  </button>
		  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
		  	<a class="dropdown-item" href="inicio">Todos</a>
		  	<c:forEach items="${Marcas}" var="marca">
		    	<a class="dropdown-item" href="inicio?idMarca=${marca.id}&nombreMarca=${marca.nombre}">${marca.nombre}</a>
			 </c:forEach>  
		  </div>
	</div>
	
	
	  <nav class="my-2 my-md-0 mr-md-3 navbar-dark">
	  
	  
		<c:if test="${'Admin' eq Usuario_login.nombre }">
	    <a class="py-2 d-none d-md-inline-block  ${ ( 'listado' eq param.pagina ) ? 'active' : '' }" href="lista">Perfumes</a>
	    <a class="py-2 d-none d-md-inline-block ${ ( 'marcas' eq param.pagina ) ? 'active' : '' }" href="marcas">Marcas</a>
		<a class="py-2 d-none d-md-inline-block ${ ( 'usuarios' eq param.pagina ) ? 'active' : '' }" href="usuarios">Usuarios</a>  
		</c:if>
		
		<c:if test="${not empty Usuario_login}">
		<a class="py-2 d-none d-md-inline-block text-primary active">${Usuario_login.nombre}</a>
		</c:if>
		
	  </nav>
	   	<c:if test="${empty Usuario_login}">
	  		<a class="btn btn-outline-primary ${ ( 'login' eq param.pagina ) ? 'active' : '' }" href="login">Iniciar Sesion</a>
		</c:if>
		<c:if test="${not empty Usuario_login}">
		 	<a class="btn btn-outline-primary" href="logout">Cerrar Sesion</a>
		</c:if>
	</div>
	
	</header>

<main class="container">




<jsp:include page="message.jsp"></jsp:include>
