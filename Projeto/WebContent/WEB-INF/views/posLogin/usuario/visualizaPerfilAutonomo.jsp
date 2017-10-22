<%@page import="com.sun.java.swing.plaf.windows.resources.windows"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="java.util.*,
        br.com.petdelivery.*,
        br.com.petdelivery.jdbc.dao.Raca_AnimalDAO"%>

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

	<div id="wrapper">
		<div class="navbar navbar-inverse navbar-fixed-top">
			<div class="adjust-nav">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".sidebar-collapse">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="home"><i class="fa fa-square-o "></i>&nbsp;Pet
						Delivery</a>
				</div>
				<div class="navbar-collapse collapse">
					<ul class="nav navbar-nav navbar-right">
						<li><a href="logout">Sair</a></li>
					</ul>
				</div>

			</div>
		</div>
	</div>

	<c:import url="menuUsuario.jsp" />
	
	<jsp:useBean id="daoServico"
		class="br.com.petdelivery.jdbc.dao.ServicoDAO" />
	<jsp:useBean id="daoServicoAutonomo"
		class="br.com.petdelivery.jdbc.dao.Servico_AutonomoDAO" />
		

	<!-- /. NAV SIDE  -->
	<div id="page-wrapper">
		<div id="page-inner">
			<div class="row">

				<div class="title col-sm-9 col-sm-offset-1 page-title wow fadeIn">
					<span aria-hidden="true"></span>
					<h1><c:out value="${perfilPrestadorAutonomo.nome}"/></h1>
				</div>

				<img src="assetsPosLogin/img/find-user.png"
					class="img-responsive img-rounded col-sm-4" width="260px" height="100px" />

				<div class="form-group col-sm-8">
					<div class="form-group col-sm-12">
						<label  for="contact-name">Nome:</label>
						<c:out value="${perfilPrestadorAutonomo.nome}"/>
					</div>
					
					<div class="form-group col-sm-12">
						<label for="contact-name">Experiência: </label>
						<c:out value="${perfilPrestadorAutonomo.experiencia}"/>
					</div>
					
					<div class="form-group col-sm-12">
						<label for="contact-name">Bairro: </label>
						<c:out value="${perfilPrestadorAutonomo.bairro}"/>
					</div>
					
					<div class="form-group col-sm-12">
						<label for="contact-name">Serviços oferecidos: </label>
						<table border="0" align="center" width="500px">
							<tr align="center">
								<th>Serviço</th>
								<th>Preço</th>
								<th>Condições</th>
								<th>Delivery</th>
								<th></th>
							</tr>
							<c:forEach var="servico"
								items="${daoServicoAutonomo.getServico(perfilPrestadorAutonomo.cpf)}">
								<tr>
									<td>${daoServico.getServicoById(servico.id_servico)}</td>
									<td>${servico.preco}</td>
									<td>${servico.condicoes}</td>
									<td>${servico.delivery}</td>
									<td><a href="agenda-servicoAutonomo?id=${perfilPrestadorAutonomo.cpf}&servico=${servico.id_servico}&delivery=${servico.delivery}">Agendar</a></td>
								</tr>
							</c:forEach>
						</table>
					</div>
					
					<div class="form-group col-sm-12">
						<label for="contact-name">Avalie esse prestador:</label>
						<form action="avaliar-PrestadorAutonomo" class="form-horizontal" method="get">
							<label class="">1
								<input	class="" type="radio" name="nota" value="1">
							</label>
							<label class="">2
								<input	class="" type="radio" name="nota" value="2">
							</label>
							<label class="">3
								<input	class="" type="radio" name="nota" value="3">
							</label>
							<label class="">4
								<input	class="" type="radio" name="nota" value="4">
							</label>
							<label class="">5
								<input	class="" type="radio" name="nota" value="5">
							</label>
							<input hidden type="text" name="id" value="${perfilPrestadorAutonomo.cpf}">
							<button type="submit" class="btn">Avaliar</button>
						</form>
					</div>
					
					<div class="form-group col-sm-12">						
						<button name="back" onclick="history.back()" class="btn">Voltar</button>
					</div>
				</div>

				
				
			</div>
		</div>
	</div>

	<c:import url="footer.jsp" />

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