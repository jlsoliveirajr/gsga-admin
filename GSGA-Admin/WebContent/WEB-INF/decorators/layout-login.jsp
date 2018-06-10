<!DOCTYPE html>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="robots" content="all,follow">

	<link rel="shortcut icon" href="<s:url value="/includes/img/favicon.png"/>">
    <link rel="stylesheet" href="<s:url value="/includes/vendor/bootstrap/css/bootstrap.min.css "/>">
    <link rel="stylesheet" href="<s:url value="/includes/vendor/font-awesome/css/font-awesome.min.css "/>">
    <link rel="stylesheet" href="<s:url value="/includes/css/fontastic.css "/>">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins:300,400,700">
    <link rel="stylesheet" href="<s:url value="/includes/css/style.default.css "/>" id="theme-stylesheet">
    <link rel="stylesheet" href="<s:url value="/includes/css/custom.css "/>">
    <link rel="stylesheet" href="<s:url value="/includes/css/gsga.css "/>">

    <script src="<s:url value='/includes/vendor/jquery/jquery.min.js'/>"></script>
    <script src="<s:url value='/includes/vendor/popper.js/umd/popper.min.js'/>"> </script>
    <script src="<s:url value='/includes/vendor/bootstrap/js/bootstrap.min.js'/>"></script>
    <script src="<s:url value='/includes/vendor/jquery.cookie/jquery.cookie.js'/>"> </script>
    <script src="<s:url value='/includes/vendor/chart.js/Chart.min.js'/>"></script>
    <script src="<s:url value='/includes/vendor/jquery-validation/jquery.validate.min.js'/>"></script>
    <script src="<s:url value='/includes/js/front.js'/>"></script>
    <title>
        <decorator:title default="GAIA SILVA GAEDE ADVOGADOS" />
    </title>
    <decorator:head />
</head>
	<body>
    	<decorator:body/>    
 	</body>
</html>