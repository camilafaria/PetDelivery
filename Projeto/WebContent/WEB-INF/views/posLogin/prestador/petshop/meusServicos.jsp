<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- Declaration to use JSTL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page
	import="java.util.*,
        br.com.petdelivery.*,
        br.com.petdelivery.jdbc.dao.AnimalDAO,
        br.com.petdelivery.jdbc.modelo.Animal"%>

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

	<c:import url="menuPetshop.jsp" />

	<jsp:useBean id="daoServico"
		class="br.com.petdelivery.jdbc.dao.ServicoDAO" />	
	<jsp:useBean id="daoServico_Petshop"
		class="br.com.petdelivery.jdbc.dao.Servico_PetshopDAO" />
	<jsp:useBean id="daoUnidade"
		class="br.com.petdelivery.jdbc.dao.Unidade_PetshopDAO" />
	
	<!-- /. NAV SIDE  -->
	<div id="page-wrapper">
		<div id="page-inner">
			<div class="row">

											
					<div class=" title col-md-12 col-sm-offset-1 page-title wow fadeIn">
					<span aria-hidden="true" ></span>
					<h1 align="center">Servicos oferecidos por ${prestadorPetshopLogado.nome}! </h1>
					<br>
					<br>
					<br>			
					<c:if test="${not empty Servico_Petshop.getServico(prestadorPetshopLogado.cnpj)}">					
						<table border="0" align="center" width="700px">
							<tr align="center">
								<th>Unidade</th>
								<th>Serviço</th>
								<th>Preço</th>
								<th>Condições</th>
								<th>Delivery</th>
							</tr>					
						
							<c:forEach var="servico"
								items="${daoServico_Petshop.getServico(prestadorPetshopLogado.cnpj)}">
								<tr>
									<td>${daoUnidade.getUnidadeById(servico.id_unidade) };</td>									
									<td>${daoServico.getServicoById(servico.id_servico)}</td>
									<td>R$ ${servico.preco}</td>
									<td>${servico.condicoes}</td>
									<td>${servico.delivery}</td>
								</tr>
							</c:forEach>			
						
						</table>
					</c:if>				
					
					<br><br>
					<form action="cadastro-servico-petshop">
						<button type="submit" class="btn">Cadastrar Serviço</button>
					</form>
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
	
	<c:import url="footer.jsp" />
	
</body>
</html>