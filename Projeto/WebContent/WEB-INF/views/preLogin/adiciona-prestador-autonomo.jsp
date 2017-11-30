<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!-- Declaration to use JSTL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Pet Delivery - Cadastrar Prestador de Serviço</title>

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
					<h1>Cadastro de profissional autônomo</h1>
				</div>
			</div>			
		</div>
	</div>
	
	<form action="insert-prestador-autonomo"  class="form-horizontal" style="vertical-align: middle;" align="center"  method="post"
					enctype="multipart/form-data">
		<div class="form-group" style="vertical-align: middle;" align="center">
        	<div class="container" style="vertical-align: middle; margin-left:27%;" align="center">
        		<div class="col-sm-7 contact-form wow fadeInLeft" style="vertical-align: middle;" align="center">
        			<!-- 1 -->
	        		<div class="form-group col-sm-12">
							<label for="contact-name">Nome completo</label> <input type="text"
								name="nome" placeholder="Digite seu Nome..."
								class="contact-name form-control">
					</div>
					<!-- 2 -->
					<div class="form-group col-sm-6">
							<label for="contact-name">CPF</label> <input type="text"
								name="cpf" placeholder="12334567890"
								class="contact-name form-control">
					</div>
					<div class="form-group col-sm-2">
							<label for="contact-name">DDD</label> <input type="text"
								name="ddd" placeholder="11" class="contact-name form-control">
					</div>
					<div class="form-group col-sm-5">
							<label for="contact-name">Telefone</label> <input type="text"
								name="telefone" placeholder="934569879"
								class="contact-name form-control">
					</div>
					<!-- 3 -->
					<div class="form-group col-sm-6">
						<label for="contact-name">CEP</label> <input type="text"
							name="cep" placeholder="00000-000"
							class="contact-name form-control">
					</div>
					<div class="form-group col-sm-6">
							<label for="contact-name">Bairro</label> <input type="text"
								name="bairro" placeholder="Santana"
								class="contact-name form-control">
					</div>
					<!-- 4 -->
					<div class="form-group col-sm-6">
							<label for="contact-name">Rua</label> <input type="text"
								name="rua" placeholder="Rua XV de Maio"
								class="contact-name form-control">
					</div>
					<div class="form-group col-sm-2">
							<label for="contact-name">Número</label> <input type="text"
								name="numero" placeholder="245"
								class="contact-name form-control">
					</div>
					<div class="form-group col-sm-5">
							<label for="contact-name">Complemento</label> <input type="text"
								name="complemento" placeholder="Apt. 25 Bloco B"
								class="contact-name form-control">
					</div>
					<!-- 5 -->
					<div class="form-group col-sm-12">
							<label for="contact-email">Experiência</label>
                            <textarea name="experiencia" cols="30" rows="10" class="contact-email form-control" id="experiencia" placeholder="Sou formado em veterinária, trabalho há 5 anos com animais..."></textarea>
					</div>
					<!-- 6 -->
					<div class="form-group col-sm-12">
							<label for="img">Selecione sua foto (até 16 MB)</label>
							<input type="file" name="file" class="img form-control"  accept=".png"/> 
					</div>
					<!-- 7 -->
					<div class="form-group col-sm-12">
							<label for="contact-name">E-mail</label> <input type="text"
								name="email" placeholder="seu.nome@provedor.com.br"
								class="contact-name form-control">
					</div>
					<!-- 8 -->
					<div class="form-group col-sm-12">
						<label for="contact-email">Reinserir Email</label> <input type="text"
							name="" placeholder="jose.silva@gmail.com"
							class="contact-email form-control">
					</div>
					<!-- 9 -->
					<div class="form-group col-sm-12">
							<label for="contact-name">Senha</label> <input type="password"
								name="senha" placeholder="Digite sua senha..."
								class="contact-name form-control">
					</div>				
					
					<!-- input type="submit" class="btn" value="Registrar" /-->					
					<button type="submit" class="btn">Registrar</button>
				</div>
			</div>
		</div>
	</form>


	<!-- End Body -->

	<c:import url="../footer.jsp" />

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