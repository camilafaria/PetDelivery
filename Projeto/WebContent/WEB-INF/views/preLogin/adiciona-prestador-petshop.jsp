<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!-- Declaration to use JSTL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Pet Delivery - Cadastrar Petshop</title>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- CSS -->
<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,400">
<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Montserrat:700,400">
<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/elegant-font/code/style.css">
<link rel="stylesheet" href="assets/css/animate.css">
<link rel="stylesheet" href="assets/css/magnific-popup.css">
<link rel="stylesheet" href="assets/flexslider/flexslider.css">
<link rel="stylesheet" href="assets/css/form-elements.css">
<link rel="stylesheet" href="assets/css/style.css">
<link rel="stylesheet" href="assets/css/media-queries.css">

<!-- Favicon and touch icons -->
<link rel="shortcut icon" href="assets/ico/favicon.png">
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="assets/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="assets/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="assets/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="assets/ico/apple-touch-icon-57-precomposed.png">
</head>
<body>
	<c:import url="../header.jsp" />

	<!-- Start Body -->

	<!-- Page Title -->
	<div class="page-title-container">
		<div class="container">
			<div class="row">
				<div class="title col-sm-10 col-sm-offset-1 page-title wow fadeIn">
					<span aria-hidden="true" class="icon_profile"></span>
					<h1>Cadastro de Petshop</h1>
				</div>
			</div>
		</div>
	</div>
	
	<form action="insert-prestador-petshop"  class="form-horizontal" style="vertical-align: middle;" align="center" method="post">
		<div class="form-group" style="vertical-align: middle;" align="center">
        	<div class="container" style="vertical-align: middle; margin-left:27%;" align="center">
        		<div class="col-sm-7 contact-form wow fadeInLeft" style="vertical-align: middle;" align="center">
        			<!-- 1 -->
	        		<div class="form-group">
							<label for="contact-name">Nome</label> <input type="text"
								name="nome" placeholder="Digite seu Nome..."
								class="contact-name form-control" placeholder="Lion">
					</div>
					<div class="form-group">
							<label for="contact-name">CNPJ</label> <input type="text"
								name="cnpj" placeholder="12334567890"
								class="contact-name form-control" placeholder="12345">
					</div>
					<div class="form-group">
							<label for="contact-name">E-mail</label> <input type="text"
								name="email" placeholder="seu.nome@provedor.com.br"
								class="contact-name form-control" placeholder="lion@a.com">
					</div>
					<div class="form-group">
							<label for="contact-name">Senha</label> <input type="password"
								name="senha" placeholder="Digite sua senha..."
								class="contact-name form-control" placeholder="123">
					</div>
					<div class="form-group">
							<label for="contact-email">Descricao</label>
                            <textarea name="descricao" cols="30" rows="10" class="contact-email form-control" id="experiencia" placeholder="Somos especialistas na venda de produtos para animais..."></textarea>
					</div>
					<div class="form-group">
							<label for="img">Logotipo</label>
							<input type="file" name="logotipo" class="img form-control"  accept="image/png, image/jpeg"  multiple /> 
					</div>			
					
					<button type="submit" class="btn" onclick="confirmaCadastroPetshop()">Registrar</button>
				</div>
			</div>
		</div>
	</form>


	<!-- End Body -->

	<c:import url="../footer.jsp" />

	<!-- Javascript -->
	<script language="javascript">
	function confirmaCadastroPetshop(){
		  alert('Cadastro realizado com sucesso!');  
	}
	</script>
	<script src="assets/js/jquery-1.11.1.min.js"></script>
	<script src="assets/bootstrap/js/bootstrap.min.js"></script>
	<script src="assets/js/bootstrap-hover-dropdown.min.js"></script>
	<script src="assets/js/wow.min.js"></script>
	<script src="assets/js/retina-1.1.0.min.js"></script>
	<script src="assets/js/jquery.magnific-popup.min.js"></script>
	<script src="assets/flexslider/jquery.flexslider-min.js"></script>
	<script src="assets/js/jflickrfeed.min.js"></script>
	<script src="assets/js/masonry.pkgd.min.js"></script>
	<script src="http://maps.google.com/maps/api/js?sensor=true"></script>
	<script src="assets/js/jquery.ui.map.min.js"></script>
	<script src="assets/js/scripts.js"></script>
</body>
</html>