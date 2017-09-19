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
<link rel="stylesheet" href='<c:url value="assets/bootstrap/css/bootstrap.min.css"/>'/>
<link rel="stylesheet" href='<c:url value="assets/elegant-font/code/style.css"/>'/>
<link rel="stylesheet" href='<c:url value="assets/css/animate.css"/>'/>
<link rel="stylesheet" href='<c:url value="assets/css/magnific-popup.css"/>'/>
<link rel="stylesheet" href='<c:url value="assets/flexslider/flexslider.css"/>'/>
<link rel="stylesheet" href='<c:url value="assets/css/form-elements.css"/>'/>
<link rel="stylesheet" href='<c:url value="assets/css/style.css"/>'/>
<link rel="stylesheet" href='<c:url value="assets/css/media-queries.css"/>'/>

<!-- Favicon and touch icons -->
<link rel="shortcut icon" href="assets/ico/favicon.png">
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href='<c:url value="assets/ico/apple-touch-icon-144-precomposed.png"/>'/>
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href='<c:url value="assets/ico/apple-touch-icon-114-precomposed.png"/>'/>
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href='<c:url value="assets/ico/apple-touch-icon-72-precomposed.png"/>'/>
<link rel="apple-touch-icon-precomposed"
	href='<c:url value="assets/ico/apple-touch-icon-57-precomposed.png"/>'/>
</head>
<body>
	<c:import url="header.jsp" />
	
	<!-- Slider -->
        <div class="slider-container">
            <div class="slider">
                <div class="flexslider">
                    <ul class="slides">
                        <li>
                            <img src="assets/img/slider/4.jpg">
                            <!-- <div class="flex-caption">
                            	
                            </div>  -->
                        </li>
                        
                    </ul>
                </div>
            </div>
        </div>
        
        <!-- call to action -->
        <div class="call-to-action-container" style="background-color:white; color:white;">

	        <div class="container">
        		<div class="row">
	        		<div class="col-sm-12">
	            		<h1>Seu <span class="colored-text">PET</span> merece ser tratado com carinho.</h1>
	            		<p>
	            			Encontre os melhores profissionais da sua região e solicite serviços sem sair de casa.
	            		</p>
	            	</div>
            	</div>
        	</div>
        </div>

        <!-- Presentation -->
        <div class="presentation-container">
        	<div class="container">
        		<div class="row">
	        		<div class="col-sm-12">
	            		<a class="big-link-3" href="adiciona-usuario">EXPERIMENTE</a>
	            	</div>
            	</div>
        	</div>
        </div>

        <!-- Services -->
        <div class="services-container">
	        <div class="container">
	            <div class="row">
	            	<div class="col-sm-3">
		                <div class="service wow fadeInUp">
		                    <div class="service-icon"><i class="demo-icon icon-heart-filled">&#x61;</i></div>
		                    <h3>Conheça nossos <br>Petlovers</h3>
		                    
		                    <p>Nossos Petlovers oferecem os melhores serviços e cuidam do seu Pet como filhos</p>
		                    <a class="big-link-1" href="#">Ler mais</a>
		                </div>
					</div>
					<div class="col-sm-3">
		                <div class="service wow fadeInDown">
		                    <div class="service-icon"><i class="demo-icon icon-paw">&#x32;</i></div>
		                    <h3>Dê ao seu pet o cuidado que ele precisa </h3>
		                    <p>Busque por Petlovers perto de você e contrate seus serviços sem sair de casa</p>
		                    <a class="big-link-1" href="#">Ler mais</a>
		                </div>
	                </div>
	                <div class="col-sm-3">
		                <div class="service wow fadeInUp">
		                    <div class="service-icon"><i class="demo-icon icon-calendar">&#x33;</i></div>
		                    <h3>Adaptável à sua <br> agenda</h3>
		                    <p>Escolha o melhor horário para você e a gente busca seu Pet na sua casa</p>
		                    <a class="big-link-1" href="#">Ler mais</a>
		                </div>
	                </div>
	                <div class="col-sm-3">
		                <div class="service wow fadeInDown">
		                    <div class="service-icon"><i class="demo-icon icon-smile">&#x34;</i></div>
		                    <h3>Compartilhe sua experiência</h3>
		                    <p>Conte para a gente como foi fazer parte da família que mais ama os animaizinhos!</p>
		                    <a class="big-link-1" href="#">Ler mais</a>
		                </div>
	                </div>
	            </div>
	        </div>
        </div>

        <!-- Latest work -->
        <div class="work-container">
	        <div class="container">
	        	 <div class="row">
		            <div class="col-sm-12 wow fadeIn"> 
		                <h2>Alguns dos serviços oferecidos</h2>
		            </div>
	            </div>  
	            <div class="row">
	            	<div class="col-sm-3">
		                <div class="work wow fadeInUp">
		                    <img src="assets/img/portfolio/work01.jpg" alt="Dog Walker" data-at2x="assets/img/portfolio/work1.jpg">
		                    <h3>Dog walker</h3>
		                    <p></p>
		                    <div class="work-bottom">
		                        <a class="big-link-2 view-work" href="assets/img/portfolio/work01.jpg"><span class="icon_search"></span></a>
		                        <a class="big-link-2" href="portfolio.html"><span class="icon_link"></span></a>
		                    </div>
		                </div>
	                </div>
	                <div class="col-sm-3">
		                <div class="work wow fadeInDown">
		                    <img src="assets/img/portfolio/work02.jpg" alt="Banho e tosa" data-at2x="assets/img/portfolio/work2.jpg">
		                    <h3>Banho e tosa</h3>
		                    <p></p>
		                    <div class="work-bottom">
		                        <a class="big-link-2 view-work" href="assets/img/portfolio/work02.jpg"><span class="icon_search"></span></a>
		                        <a class="big-link-2" href="portfolio.html"><span class="icon_link"></span></a>
		                    </div>
		                </div>
		            </div>
		            <div class="col-sm-3">
		                <div class="work wow fadeInUp">
		                    <img src="assets/img/portfolio/work03.jpg" alt="Hotel e babá" data-at2x="assets/img/portfolio/work3.jpg">
		                    <h3>Hotel e babá</h3>
		                    <p></p>
		                    <div class="work-bottom">
		                        <a class="big-link-2 view-work" href="assets/img/portfolio/work03.jpg"><span class="icon_search"></span></a>
		                        <a class="big-link-2" href="portfolio.html"><span class="icon_link"></span></a>
		                    </div>
		                </div>
		            </div>
		            <div class="col-sm-3">
		                <div class="work wow fadeInDown">
		                    <img src="assets/img/portfolio/work04.jpg" alt="Veterinário" data-at2x="assets/img/portfolio/work4.jpg">
		                    <h3>Veterinário</h3>
		                    <p></p>
		                    <div class="work-bottom">
		                        <a class="big-link-2 view-work" href="assets/img/portfolio/work04.jpg"><span class="icon_search"></span></a>
		                        <a class="big-link-2" href="portfolio.html"><span class="icon_link"></span></a>
		                    </div>
		                </div>
		            </div>
	            </div>
	        </div>
        </div>

        <!-- Testimonials -->
        <div class="testimonials-container">
	        <div class="container">
	        	<div class="row">
		            <div class="col-sm-12 testimonials-title wow fadeIn">
		                <h2>Depoimentos</h2>
		            </div>
	            </div>
	            <div class="row">
	                <div class="col-sm-10 testimonial-list wow fadeInLeft">
	                	<div role="tabpanel">
	                		<!-- Tab panes -->
	                		<div class="tab-content">
	                			<div role="tabpanel" class="tab-pane fade in active" id="tab1">
	                				<div class="testimonial-image">
	                					<img src="assets/img/testimonials/1.jpg" alt="" data-at2x="assets/img/testimonials/1.jpg">
	                				</div>
	                				<div class="testimonial-text">
		                                <p>
		                                	"Minha vida mudou depois que comecei a usar o Petdelivery! Meu cachorro Bob passava a tarde toda sozinho em casa, agora ele passeia todos os dias! Ele é sempre muito bem cuidado e sempre volta para casa muito feliz! "<br>
		                                	<a href="#">Gustavo - Bob (Cão Beagle)</a>
		                                </p>
	                                </div>
	                			</div>
	                			<div role="tabpanel" class="tab-pane fade" id="tab2">
	                				<div class="testimonial-image">
	                					<img src="assets/img/testimonials/2.jpg" alt="" data-at2x="assets/img/testimonials/2.jpg">
	                				</div>
	                				<div class="testimonial-text">
		                                <p>
		                                	"Eu estava desempregado e triste com a partida do meu amigão, e o Petdelivery foi muito mais que um emprego, me ajudou a sair da depressão e a encontrar minha paixão."<br>
		                                	<a href="#">Luiz - Petlover há 3 meses</a>
		                                </p>
	                                </div>
	                			</div>
	                			<div role="tabpanel" class="tab-pane fade" id="tab3">
	                				<div class="testimonial-image">
	                					<img src="assets/img/testimonials/3.jpg" alt="" data-at2x="assets/img/testimonials/3.jpg">
	                				</div>
	                				<div class="testimonial-text">
		                                <p>
		                                	"Eu viajo bastante a trabalho e a Lili ficava bastante sozinha em casa, depois do Pet Delivery ela sempre fica num Hotel ou vem alguém dar água e comida para ela!"<br>
		                                	<a href="#">Roberto - Lili (Cão Salsicha)</a>
		                                </p>
	                                </div>
	                			</div>
	                			<div role="tabpanel" class="tab-pane fade" id="tab4">
	                				<div class="testimonial-image">
	                					<img src="assets/img/testimonials/4.jpg" alt="" data-at2x="assets/img/testimonials/4.jpg">
	                				</div>
	                				<div class="testimonial-text">
		                                <p>
		                                	"Se eu pudesse eu teria um milhão de animais! Só com o Pet Delivery isso foi possível!"<br>
		                                	<a href="#">Miriam - Petlover há 6 meses</a>
		                                </p>
	                                </div>
	                			</div>
	                		</div>
	                		<!-- Nav tabs -->
	                		<ul class="nav nav-tabs" role="tablist">
	                			<li role="presentation" class="active">
	                				<a href="#tab1" aria-controls="tab1" role="tab" data-toggle="tab"></a>
	                			</li>
	                			<li role="presentation">
	                				<a href="#tab2" aria-controls="tab2" role="tab" data-toggle="tab"></a>
	                			</li>
	                			<li role="presentation">
	                				<a href="#tab3" aria-controls="tab3" role="tab" data-toggle="tab"></a>
	                			</li>
	                			<li role="presentation">
	                				<a href="#tab4" aria-controls="tab4" role="tab" data-toggle="tab"></a>
	                			</li>
	                		</ul>
	                	</div>
	                </div>
	                <div class="col-sm-2 testimonial-icon wow fadeInUp">
	                	<div>
	                		<span aria-hidden="true" class="icon_pushpin"></span>
	                	</div>
	                </div>
	            </div>
	        </div>
        </div>
	<!-- End Body -->
	
	<c:import url="footer.jsp" />

	<!-- Javascript -->
	<script src='<c:url value="assets/js/jquery-1.11.1.min.js"/>'></script>
	<script src='<c:url value="assets/bootstrap/js/bootstrap.min.js"/>'></script>
	<script src='<c:url value="assets/js/bootstrap-hover-dropdown.min.js"/>'></script>
	<script src='<c:url value="assets/js/wow.min.js"/>'></script>
	<script src='<c:url value="assets/js/retina-1.1.0.min.js"/>'></script>
	<script src='<c:url value="assets/js/jquery.magnific-popup.min.js"/>'></script>
	<script src='<c:url value="assets/flexslider/jquery.flexslider-min.js"/>'></script>
	<script src='<c:url value="assets/js/jflickrfeed.min.js"/>'></script>
	<script src='<c:url value="assets/js/masonry.pkgd.min.js"/>'></script>
	<script src="http://maps.google.com/maps/api/js?sensor=true"></script>
	<script src='<c:url value="assets/js/jquery.ui.map.min.js"/>'></script>
	<script src='<c:url value="assets/js/scripts.js"/>'></script>
	</body>
</html>