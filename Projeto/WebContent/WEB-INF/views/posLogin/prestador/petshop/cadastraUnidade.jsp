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
<c:import url="../../favicon.jsp" />
</head>

<body>

	<c:import url="headerPetshop.jsp" />
	<jsp:include page="menuPetshop.jsp">
        <jsp:param name="foto" value="${prestadorPetshopLogado.logotipo}"/>
    </jsp:include>
	<!-- /. NAV SIDE  -->

	<div id="page-wrapper">
		<div id="page-inner">
			<div class="row">

				<div class="page-title-container">
					<div class="container">
						<div class="row">
							<div class="title col-sm-9 page-title wow fadeIn">
								<span aria-hidden="true" class="fa fa-home"></span>
								<h1>Cadastrar Unidade</h1>
							</div>
						</div>
					</div>
				</div>

				<form action="cadastro-unidade" class="form-horizontal col-md-offset-2"
					method="post">
					<div class="form-group">
						<div class="container"
							style="vertical-align: middle;" align="center">
							<div class="col-sm-7 contact-form wow">

								<div class="form-group col-sm-12">
									<label for="contact-name">Nome</label> 
									<input type="text" name="nome" placeholder="Digite o nome da unidade"
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
									<label for="contact-name">N�mero</label> <input type="text"
										name="numero" placeholder="245"
										class="contact-name form-control">
								</div>
								<div class="form-group col-sm-5">
									<label for="contact-name">Complemento</label> <input
										type="text" name="complemento" placeholder="Apt. 25 Bloco B"
										class="contact-name form-control">
								</div>
								
								<input type="hidden" name="cnpj"
									value="${prestadorPetshopLogado.cnpj}" />
								<div class="form-group col-sm-12">
								<!-- input type="submit" class="btn" value="Registrar" /-->
								<button type="submit" class="btn col-md-offset-2"
									onclick="confirmaCadastroUnidade()">Registrar</button>
								</div>	
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