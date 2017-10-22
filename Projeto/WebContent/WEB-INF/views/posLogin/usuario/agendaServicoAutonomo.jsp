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
	
	<jsp:useBean id="daoAnimal"
		class="br.com.petdelivery.jdbc.dao.AnimalDAO" />
	<jsp:useBean id="daoServico"
		class="br.com.petdelivery.jdbc.dao.ServicoDAO" />
	<jsp:useBean id="daoServicoAutonomo"
		class="br.com.petdelivery.jdbc.dao.Servico_AutonomoDAO" />

	<!-- /. NAV SIDE  -->
	<div id="page-wrapper">
		<div id="page-inner">
			<div class="row">

				<div class="page-title-container">
					<div class="container">
						<div class="row">
							<div class="title col-sm-9 col-sm-offset-1 page-title wow fadeIn">
								<span aria-hidden="true" class="icon_profile"></span>
								<h1>Agendar Serviço</h1>
							</div>
						</div>
					</div>
				</div>

				<form action="agendaServico" class="form-horizontal" method="post">
					<div class="form-group">
						<div class="container"  style="vertical-align: middle; margin-left:20%;" align="center">
							<div class="col-sm-7 contact-form wow">
								<div class="form-group">
									<label for="contact-name">Selecione o serviço a ser agendado: </label>
									<select name="id_servico" id="id_servico">
									
										<option selected disabled value="">Selecione um serviço</option>									
										<c:forEach var="servico"
											items="${daoServicoAutonomo.getServico(perfilPrestadorAutonomo.cpf)}">
											<option value="${servico.id_servico}" }> ${daoServico.getServicoById(servico.id_servico)} </option>										
										</c:forEach>
																			
									</select>
								</div>
								
								<div class="form-group">
									<label for="contact-name">Selecione o animal para o qual o serviço será agendado: </label>
									<select name="id_animal" id="id_animal">
										<option selected disabled value="">Selecione um animal</option>
									
										<c:forEach var="animal"
											items="${daoAnimal.getAnimalUsuario(usuarioLogado.cpf)}">
											<option value="${animal.id_animal}" }> ${animal.nome} </option>										
										</c:forEach>									
										
									</select>
								</div>
							
								<div class="form-group">
									<label for="contact-name">Data</label><input type="text"
										name="datahora"
										placeholder="Descreva detalhes sobre as vacinas de seu PET"
										class="contact-name form-control">
								</div>
								
								<div class="form-group">
									<label for="contact-name">Observacoes</label><input type="text"
										name="observacoes"
										placeholder="Descreva quaisquer observacoes sobre o servico"
										class="contact-name form-control">
								</div>

								<input type="hidden" name="id_usuario"
									value="${usuarioLogado.cpf}" />

								<!-- input type="submit" class="btn" value="Registrar" /-->
								<button type="submit" class="btn" onclick="confirmaCadastroPet()">Registrar</button>
							</div>
						</div>
					</div>
				</form>
				
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