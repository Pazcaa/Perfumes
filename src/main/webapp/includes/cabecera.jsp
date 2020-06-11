<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
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
	<header>
		<nav class="navbar navbar-dark bg-dark">
		  <div class="container d-flex flex-column flex-md-row justify-content-between">
		    <a class="py-2" href="inicio" aria-label="Product"><i class="far fa-gem fa-lg"></i><i class="fas fa-gem fa-lg"></i><i class="far fa-gem fa-lg"></i></a>
		    <a class="py-2 d-none d-md-inline-block  ${ ( 'inicio' eq param.pagina ) ? 'active' : '' }" href="inicio">Listado Perfumes</a>
		    <a class="py-2 d-none d-md-inline-block  ${ ( 'formulario' eq param.pagina ) ? 'active' : '' }" href="formulario?id=0">Crear Registro Perfume</a>
		   
		  </div>
		</nav>
	</header>

<main class="container">




<jsp:include page="message.jsp"></jsp:include>
