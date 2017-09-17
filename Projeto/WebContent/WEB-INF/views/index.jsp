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
	
	<!-- Start Body -->
	<c:if test="${not empty usuarioLogado.nome}">
			<div class="collapse navbar-collapse" id="top-navbar-1">
				<p>Bem vindo, usuario: ${usuarioLogado.nome}</p>
			</div>
	</c:if>
	<c:if test="${not empty prestadorAutonomoLogado.nome}">
			<div class="collapse navbar-collapse" id="top-navbar-1">
				<p>Bem vindo, prestador autonomo: ${prestadorAutonomoLogado.nome}</p>
			</div>
	</c:if>
	<c:if test="${not empty prestadorPetshopLogado.nome}">
			<div class="collapse navbar-collapse" id="top-navbar-1">
				<p>Bem vindo, Petshop: ${prestadorPetshopLogado.nome}</p>
			</div>
	</c:if>
		
	<!-- Slider -->
        <div class="slider-container">
            <div class="slider">
                <div class="flexslider">
                    <ul class="slides">
                        <li>
                            <img src="assets/img/slider/3.jpg">
                            <div class="flex-caption">
                            	Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit 
                            	lobortis nisl ut aliquip ex ea commodo consequat.
                            </div>
                        </li>
                        <li>
                            <img src="assets/img/slider/2.jpg">
                            <div class="flex-caption">
                            	Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit 
                            	lobortis nisl ut aliquip ex ea commodo consequat.
                            </div>
                        </li>
                        <li>
                            <img src="assets/img/slider/1.jpg">
                            <div class="flex-caption">
                            	Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et. 
                            	Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et. 
                            	Lorem ipsum dolor sit amet, consectetur.
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
        </div>

        <!-- Presentation -->
        <div class="presentation-container">
        	<div class="container">
        		<div class="row">
	        		<div class="col-sm-12 wow fadeInLeftBig">
	            		<h1>This is <span class="colored-text">Gioia</span>, a Bootstrap business template.</h1>
	            		<p>
	            			Download this theme <a href="http://azmind.com" target="_blank">from here</a> for free, 
	            			use it and customize it as you like.
	            		</p>
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
		                    <div class="service-icon"><span aria-hidden="true" class="icon_gift"></span></div>
		                    <h3>Beautiful Websites</h3>
		                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et...</p>
		                    <a class="big-link-1" href="services.html">Read more</a>
		                </div>
					</div>
					<div class="col-sm-3">
		                <div class="service wow fadeInDown">
		                    <div class="service-icon"><span aria-hidden="true" class="icon_mobile"></span></div>
		                    <h3>Responsive Layout</h3>
		                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et...</p>
		                    <a class="big-link-1" href="services.html">Read more</a>
		                </div>
	                </div>
	                <div class="col-sm-3">
		                <div class="service wow fadeInUp">
		                    <div class="service-icon"><span aria-hidden="true" class="icon_pencil"></span></div>
		                    <h3>Awesome Logos</h3>
		                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et...</p>
		                    <a class="big-link-1" href="services.html">Read more</a>
		                </div>
	                </div>
	                <div class="col-sm-3">
		                <div class="service wow fadeInDown">
		                    <div class="service-icon"><span aria-hidden="true" class="icon_printer-alt"></span></div>
		                    <h3>High Res Prints</h3>
		                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et...</p>
		                    <a class="big-link-1" href="services.html">Read more</a>
		                </div>
	                </div>
	            </div>
	        </div>
        </div>

        <!-- Latest work -->
        <div class="work-container">
	        <div class="container">
	        	<div class="row">
		            <div class="col-sm-12 work-title wow fadeIn">
		                <h2>Our Latest Work</h2>
		            </div>
	            </div>
	            <div class="row">
	            	<div class="col-sm-3">
		                <div class="work wow fadeInUp">
		                    <img src="assets/img/portfolio/work1.jpg" alt="Lorem Website" data-at2x="assets/img/portfolio/work1.jpg">
		                    <h3>Lorem Website</h3>
		                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor...</p>
		                    <div class="work-bottom">
		                        <a class="big-link-2 view-work" href="assets/img/portfolio/work1.jpg"><span class="icon_search"></span></a>
		                        <a class="big-link-2" href="portfolio.html"><span class="icon_link"></span></a>
		                    </div>
		                </div>
	                </div>
	                <div class="col-sm-3">
		                <div class="work wow fadeInDown">
		                    <img src="assets/img/portfolio/work2.jpg" alt="Ipsum Logo" data-at2x="assets/img/portfolio/work2.jpg">
		                    <h3>Ipsum Logo</h3>
		                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor...</p>
		                    <div class="work-bottom">
		                        <a class="big-link-2 view-work" href="assets/img/portfolio/work2.jpg"><span class="icon_search"></span></a>
		                        <a class="big-link-2" href="portfolio.html"><span class="icon_link"></span></a>
		                    </div>
		                </div>
		            </div>
		            <div class="col-sm-3">
		                <div class="work wow fadeInUp">
		                    <img src="assets/img/portfolio/work3.jpg" alt="Dolor Prints" data-at2x="assets/img/portfolio/work3.jpg">
		                    <h3>Dolor Prints</h3>
		                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor...</p>
		                    <div class="work-bottom">
		                        <a class="big-link-2 view-work" href="assets/img/portfolio/work3.jpg"><span class="icon_search"></span></a>
		                        <a class="big-link-2" href="portfolio.html"><span class="icon_link"></span></a>
		                    </div>
		                </div>
		            </div>
		            <div class="col-sm-3">
		                <div class="work wow fadeInDown">
		                    <img src="assets/img/portfolio/work4.jpg" alt="Sit Amet Website" data-at2x="assets/img/portfolio/work4.jpg">
		                    <h3>Sit Amet Website</h3>
		                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor...</p>
		                    <div class="work-bottom">
		                        <a class="big-link-2 view-work" href="assets/img/portfolio/work4.jpg"><span class="icon_search"></span></a>
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
		                <h2>Testimonials</h2>
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
		                                	"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et. 
		                                	Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et. 
		                                	Lorem ipsum dolor sit amet, consectetur..."<br>
		                                	<a href="#">Lorem Ipsum, dolor.co.uk</a>
		                                </p>
	                                </div>
	                			</div>
	                			<div role="tabpanel" class="tab-pane fade" id="tab2">
	                				<div class="testimonial-image">
	                					<img src="assets/img/testimonials/2.jpg" alt="" data-at2x="assets/img/testimonials/2.jpg">
	                				</div>
	                				<div class="testimonial-text">
		                                <p>
		                                	"Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip 
		                                	ex ea commodo consequat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit 
		                                	lobortis nisl ut aliquip ex ea commodo consequat..."<br>
		                                	<a href="#">Minim Veniam, nostrud.com</a>
		                                </p>
	                                </div>
	                			</div>
	                			<div role="tabpanel" class="tab-pane fade" id="tab3">
	                				<div class="testimonial-image">
	                					<img src="assets/img/testimonials/3.jpg" alt="" data-at2x="assets/img/testimonials/3.jpg">
	                				</div>
	                				<div class="testimonial-text">
		                                <p>
		                                	"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et. 
		                                	Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et. 
		                                	Lorem ipsum dolor sit amet, consectetur..."<br>
		                                	<a href="#">Lorem Ipsum, dolor.co.uk</a>
		                                </p>
	                                </div>
	                			</div>
	                			<div role="tabpanel" class="tab-pane fade" id="tab4">
	                				<div class="testimonial-image">
	                					<img src="assets/img/testimonials/4.jpg" alt="" data-at2x="assets/img/testimonials/4.jpg">
	                				</div>
	                				<div class="testimonial-text">
		                                <p>
		                                	"Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip 
		                                	ex ea commodo consequat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit 
		                                	lobortis nisl ut aliquip ex ea commodo consequat..."<br>
		                                	<a href="#">Minim Veniam, nostrud.com</a>
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