<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- Declaration to use JSTL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pet Delivery</title>

<!-- BOOTSTRAP STYLES-->
<link href="assetsPosLogin/css/bootstrap.css" rel="stylesheet" />
<!-- FONTAWESOME STYLES-->
<link href="assetsPosLogin/css/font-awesome.css" rel="stylesheet" />
<!-- CUSTOM STYLES-->
<link href="assetsPosLogin/css/custom.css" rel="stylesheet" />
<!-- GOOGLE FONTS-->
<link href="http://fonts.googleapis.com/css?family=Open+Sans"
	rel="stylesheet" type="text/css" />
</head>
<body>
	<c:import url="headerUsuario.jsp" />

	<c:import url="menuUsuario.jsp" />

	<!-- /. NAV SIDE  -->
	<div id="page-wrapper">
		<div id="page-inner">
			<div class="row">
				<div class="home col-md-12">

					<h2>Bem-vindo ao Pet Delivery, ${usuarioLogado.nome}!</h2>
					<br>
					<h4>Comece já sua experiência em nosso site! <br> Atualize o perfil do seu PET e busque por petlovers.</h2>
				</div>
			</div>
		</div>
	</div>
	
	
	
<!-- Footer -->
<footer>
	<div class="container">
		<div class="row">
			<div class="col-sm-3 footer-box wow fadeInUp">
				<h4>Sobre nós</h4>
				<div class="footer-box-text">
					<p>Somos uma família de apaixonados por animais focados em oferecer os melhores serviços para seus animais de estimação.</p>
				</div>
			</div>
			<div class="col-sm-6 footer-box wow fadeInDown">
				<h4>Inscreva-se no nosso newsletter</h4>
				<div class="footer-box-text footer-box-text-subscribe">
					<p>Insira seu e-mail abaixo e fique ligado nas novidades:</p>
					<form role="form" action="assets/subscribe.php" method="post">
						<div class="form-group">
							<label class="sr-only" for="subscribe-email">E-mail
								</label> <input type="text" name="email" placeholder="Email..."
								class="subscribe-email form-control" id="subscribe-email">
						</div>
						<button type="submit" class="btn">Inscrever</button>
					</form>
					<p class="success-message"></p>
					<p class="error-message"></p>
				</div>
			</div>
			<!--
			<div class="col-sm-3 footer-box wow fadeInUp">
				
				<h4>Flickr Photos</h4>
				 <div class="footer-box-text flickr-feed"></div>  
			</div>-->
			<div class="col-sm-3 footer-box wow fadeInDown">
				<h4>Fale conosco</h4>
				<div class="footer-box-text footer-box-text-contact">
					<!-- <p>
						<span aria-hidden="true" class="icon_pin"></span> Address: Via
						Principe Amedeo 9, 10100, Torino, TO, Italy
					</p> -->
					<p>
						<span aria-hidden="true" class="icon_phone"></span> Telefone: (11) 4321-9876
					</p>
					<!-- <p>
						<span aria-hidden="true" class="icon_profile"></span> Skype:
						Gioia_Business
					</p> -->
					<p>
						<span aria-hidden="true" class="icon_mail"></span> Email: <a
							href="#">contato@petdelivery.com</a>
					</p>
					<p>
					<!-- <div class="col-sm-12 footer-social wow fadeIn"> -->
					<a href="#"><span class="social_facebook"></span></a> 
					<a href="#"><span class="social_dribbble"></span></a> 
					<a href="#"><span class="social_twitter"></span></a> 
					<a href="#"><span class="social_pinterest"></span></a>
					<!-- </div>  -->
					</p>
				</div>
				
			</div>
		</div>
		
		<!-- 
		<div class="row">
			<div class="col-sm-12 wow fadeIn">
				<div class="footer-border"></div>
			</div>
		</div>-->
		 
		
	</div>
</footer>
	
	
	<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
	<!-- JQUERY SCRIPTS -->
	<script src="assetsPosLogin/js/jquery-1.10.2.js"></script>
	<!-- BOOTSTRAP SCRIPTS -->
	<script src="assetsPosLogin/js/bootstrap.min.js"></script>
	<!-- METISMENU SCRIPTS -->
	<script src="assetsPosLogin/js/jquery.metisMenu.js"></script>
	<!-- CUSTOM SCRIPTS -->
	<script src="assetsPosLogin/js/custom.js"></script>

</body>
</html>