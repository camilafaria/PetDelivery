<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="utf-8"%>
<!-- Declaration to use JSTL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Pet Delivery</title>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- CSS -->
<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,400">
<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Montserrat:700,400">
<link rel="stylesheet"
	href='<c:url value="assets/bootstrap/css/bootstrap.min.css"/>' />
<link rel="stylesheet"
	href='<c:url value="assets/elegant-font/code/style.css"/>' />
<link rel="stylesheet" href='<c:url value="assets/css/animate.css"/>' />
<link rel="stylesheet"
	href='<c:url value="assets/css/magnific-popup.css"/>' />
<link rel="stylesheet"
	href='<c:url value="assets/flexslider/flexslider.css"/>' />
<link rel="stylesheet"
	href='<c:url value="assets/css/form-elements.css"/>' />
<link rel="stylesheet" href='<c:url value="assets/css/style.css"/>' />
<link rel="stylesheet"
	href='<c:url value="assets/css/media-queries.css"/>' />

<!-- Favicon and touch icons -->
<link rel="shortcut icon" href="assets/ico/favicon.png">
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href='<c:url value="assets/ico/apple-touch-icon-144-precomposed.png"/>' />
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href='<c:url value="assets/ico/apple-touch-icon-114-precomposed.png"/>' />
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href='<c:url value="assets/ico/apple-touch-icon-72-precomposed.png"/>' />
<link rel="apple-touch-icon-precomposed"
	href='<c:url value="assets/ico/apple-touch-icon-57-precomposed.png"/>' />
</head>
<body>
	<c:import url="header.jsp" />

	<!-- Start Body -->
	<!-- <h1>${errorMsg}</h1> -->
	<h2>Ops, um erro aconteceu. Faça o <a href="login">LOGIN</a> novamente, por favor.</h2>

	<!-- End Body -->

	<c:import url="footer.jsp" />

	<!-- Javascript -->
	<script src='<c:url value="assets/js/jquery-1.11.1.min.js"/>'></script>
	<script src='<c:url value="assets/bootstrap/js/bootstrap.min.js"/>'></script>
	<script
		src='<c:url value="assets/js/bootstrap-hover-dropdown.min.js"/>'></script>
	<script src='<c:url value="assets/js/wow.min.js"/>'></script>
	<script src='<c:url value="assets/js/retina-1.1.0.min.js"/>'></script>
	<script src='<c:url value="assets/js/jquery.magnific-popup.min.js"/>'></script>
	<script
		src='<c:url value="assets/flexslider/jquery.flexslider-min.js"/>'></script>
	<script src='<c:url value="assets/js/jflickrfeed.min.js"/>'></script>
	<script src='<c:url value="assets/js/masonry.pkgd.min.js"/>'></script>
	<script src="http://maps.google.com/maps/api/js?sensor=true"></script>
	<script src='<c:url value="assets/js/jquery.ui.map.min.js"/>'></script>
	<script src='<c:url value="assets/js/scripts.js"/>'></script>
</body>
</html>