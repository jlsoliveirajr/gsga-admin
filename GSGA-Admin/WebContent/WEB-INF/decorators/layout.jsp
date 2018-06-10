<!DOCTYPE html>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>GSGA Admin</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="robots" content="all,follow">

	<link rel="shortcut icon" href="<s:url value="/includes/img/favicon.png"/>">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
    <link rel="stylesheet" href="<s:url value="/includes/vendor/bootstrap/css/bootstrap.min.css "/>">
    <link rel="stylesheet" href="<s:url value="/includes/vendor/font-awesome/css/font-awesome.min.css "/>">
    <link rel="stylesheet" href="<s:url value="/includes/css/fontastic.css "/>">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins:300,400,700">
    <link rel="stylesheet" href="<s:url value="/includes/css/style.default.css "/>" id="theme-stylesheet">
    <link rel="stylesheet" href="<s:url value="/includes/css/custom.css "/>">
    <link rel="stylesheet" href="<s:url value="/includes/css/gsga.css "/>">
    

    <script src="<s:url value='/includes/vendor/jquery/jquery.min.js'/>"></script>
    <script src="<s:url value='/includes/js/jquery.block.js'/>"></script>
    <script src="<s:url value='/includes/vendor/popper.js/umd/popper.min.js'/>"></script>
    <script src="<s:url value='/includes/vendor/bootstrap/js/bootstrap.min.js'/>"></script>
    <script src="<s:url value='/includes/vendor/jquery.cookie/jquery.cookie.js'/>"></script>
    <script src="<s:url value='/includes/vendor/chart.js/Chart.min.js'/>"></script>
    <script src="<s:url value='/includes/vendor/jquery-validation/jquery.validate.min.js'/>"></script>
    <script src="<s:url value='/includes/js/front.js'/>"></script>
    <script src="<s:url value='/includes/js/gsga.util.js'/>"></script>
    <title>
        <decorator:title default="GAIA SILVA GAEDE ADVOGADOS" />
    </title>
    <decorator:head />
</head>
<body>
        <div class="page">
            <!-- Main Navbar-->
            <header class="header">
                <nav class="navbar">
                    <!-- Search Box-->
                    <div class="search-box">
                        <button class="dismiss"><i class="icon-close"></i></button>
                        <form id="searchForm" action="#" role="search">
                            <input type="search" placeholder="What are you looking for..." class="form-control">
                        </form>
                    </div>
                    <div class="container-fluid">
                        <div class="navbar-holder d-flex align-items-center justify-content-between">
                            <!-- Navbar Header-->
                            <div class="navbar-header">
                                <!-- Navbar Brand -->
                                <a href="index.html" class="navbar-brand d-none d-sm-inline-block">
                                    <div class="brand-text d-none d-lg-inline-block"><span>GSGA&nbsp;</span><strong>Admin</strong></div>
                                    <div class="brand-text d-none d-sm-inline-block d-lg-none"><strong>GSGA</strong></div>
                                </a>
                                <!-- Toggle Button--><a id="toggle-btn" href="#" class="menu-btn active"><span></span><span></span><span></span></a>
                            </div>
                            <!-- Navbar Menu -->
                            <ul class="nav-menu list-unstyled d-flex flex-md-row align-items-md-center">
                                <!-- Logout    -->
                                <li class="nav-item">
                                    <a href="login.html" class="nav-link logout"> <span class="d-none d-sm-inline">Logout</span><i class="fa fa-sign-out"></i></a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </nav>
            </header>
            <div class="page-content d-flex align-items-stretch">
                <!-- Side Navbar -->
                <nav class="side-navbar">
                    <!-- Sidebar Header-->
                    <div class="sidebar-header d-flex align-items-center">
                        <div class="avatar">
                            <img class="img-fluid rounded-circle" src="<s:url value="/includes/img/avatar/AVATAR_MASCULINO_2.png"/>" id="avatar-usuario">
                        </div>
                        <div class="title">
                            <h1 class="h4">Deiwson</h1>
                            <p>Advogado</p>
                        </div>
                    </div>
                    <!-- Sidebar Navidation Menus--><span class="heading">Menu</span>
                    <ul class="list-unstyled">
                        <li>
                            <a href="/GSGA-Admin/receita/conversoes.do"> <i class="icon-grid"></i>Conversões</a>
                        </li>
                        <li>
                            <a href="/GSGA-Admin/parametrizacao/parametrizacao.do"> <i class="fa fa-cog"></i>Parametrizações</a>
                        </li>
                    </ul>
                </nav>
                <div class="content-inner">
                    <!-- Page Header-->
                    <header class="page-header">
                        <div class="container-fluid">
                            <h2 class="no-margin-bottom"><decorator:title/></h2>
                        </div>
                    </header>
                    <section class="forms"> 
						<div class="container-fluid">
							<s:if test="actionErrors != null && !actionErrors.isEmpty()">
								<div class="alert alert-danger" role="alert">
									<s:iterator value="actionErrors">
										<li class="lista-msg"><s:property /></li>
									</s:iterator>	
								</div>						
							</s:if>	
							<s:if test="actionMessages != null && !actionMessages.isEmpty()">
								<div class="alert alert-primary" role="alert">
									<s:iterator value="actionMessages">
										<li class="lista-msg"><s:property /></li>
									</s:iterator>	
								</div>						
							</s:if>	
                           <decorator:body />
                    	</div>
                    </section>
                    <!-- Page Footer-->
                    <footer class="main-footer">
                        <div class="container-fluid">
                            <div class="row">
                                <div class="col-sm-12 text-right">
                                    <p>&copy; 1990 - 2017 | Gaia Silva Gaede & Associados - Sociedade de Advogados</p>
                                </div>
                            </div>
                        </div>
                    </footer>
                </div>
            </div>
        </div>
    </body>
</html>