<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 		<nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <a class="navbar-brand text-primary" href="inicio"><i class="far fa-gem fa-lg"></i><i class="fas fa-gem fa-lg"></i><i class="far fa-gem fa-lg"></i></a>
            <button class="btn btn-link btn-sm order-1 order-lg-0 text-primary" id="sidebarToggle" href="#"><i class="fas fa-bars"></i></button>
           
          
            <!-- Navbar-->
            <ul class="navbar-nav ml-auto ml-md-0">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle text-primary" id="userDropdown" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
                        <a class="dropdown-item text-primary">${Usuario_login.nombre}</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item text-primary" href="logout">Cerrar Sesion</a>
                    </div>
                </li>
            </ul>
        </nav>
        
         <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">
                            <div class="sb-sidenav-menu-heading"></i></div>
                            <a class="nav-link text-primary" href="views/frontoffice/inicio">
                                <div class="sb-nav-link-icon text-primary"><i class="fa fa-globe fa-lg"></i></div>
                                Mi perfil
                            </a>
                           
                            <a class="nav-link text-primary" href="views/backoffice/perfumes">
                                <div class="sb-nav-link-icon text-primary"><i class="far fa-gem fa-lg"></i></div>
                                Perfumes
                                <div class="sb-sidenav-collapse-arrow text-primary"><i class="fas fa-angle-right"></i></div>
                            </a>
                            <a class="nav-link text-primary" href="views/backoffice/usuarios">
                                <div class="sb-nav-link-icon text-primary"><i class="fas fa-gem fa-lg"></i></div>
                                Usuarios
                                <div class="sb-sidenav-collapse-arrow text-primary"><i class="fas fa-angle-right"></i></div>
                            </a>
                            <a class="nav-link text-primary" href="views/backoffice/marcas" >
                                <div class="sb-nav-link-icon text-primary"><i class="far fa-gem fa-lg"></i></div>
                                Marcas
                                <div class="sb-sidenav-collapse-arrow text-primary"><i class="fas fa-angle-right"></i></div>
                            </a>
                             <a class="nav-link text-primary" href="views/backoffice/migracion" >
                                <div class="sb-nav-link-icon text-primary"><i class="fas fa-gem fa-lg"></i></div>
                                Lanzar Proceso Migración
                                <div class="sb-sidenav-collapse-arrow text-primary"><i class="fas fa-angle-right"></i></div>
                            </a>
                             <a class="nav-link text-primary" href="#" >
                                <div class="sb-nav-link-icon text-primary"><i class="far fa-gem fa-lg"></i></div>
                                Parsear Web
                                <div class="sb-sidenav-collapse-arrow text-primary"><i class="fas fa-angle-right"></i></div>
                            </a>
                        </div>
                    </div>
                    <div class="sb-sidenav-footer text-primary">
                        <div class="small text-primary">Sesion iniciada por:</div>
                       ${Usuario_login.nombre}
                    </div>
                </nav>
            </div>
            <div id="layoutSidenav_content">
<main>
                
     <jsp:include page="message.jsp"></jsp:include>
     
     