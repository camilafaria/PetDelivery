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
<c:import url="../favicon.jsp" />
</head>
<body>
	<c:import url="headerUsuario.jsp" />

	<c:import url="menuUsuario.jsp" />

	<!-- /. NAV SIDE  -->
	<div id="page-wrapper">
		<div id="page-inner">
			<div class="row">

				<div class="title col-sm-9 col-sm-offset-1 page-title wow fadeIn">
	        		<span aria-hidden="true"></span><h1>Configurações de conta</h1>
	       		</div>

				<!-- form action="alteraUsuario" class="form-horizontal"-->
				<form action="update-usuario" class="form-horizontal">
					<div class="form-group" style="vertical-align: middle;" align="center">
						<div class="container col-sm-8" style="vertical-align: middle; "
							align="center">
							<div class="contact-form col-sm-10 wow fadeInLeft col-sm-offset-4"
								style="vertical-align: middle; ">
								<!-- 1 -->
								<div class="form-group col-sm-12">
									<label for="contact-name">Nome completo</label> <input
										type="text" name="nome" value="${usuarioLogado.nome}"
										class="contact-name form-control">
								</div>
								
								
								<div class="form-group col-sm-6">
									<label for="contact-name">CPF</label> <input type="text"
										name="cpf" value="${usuarioLogado.cpf}"
										class="contact-nameform-control" readonly>
								</div>
								
								<div class="form-group col-sm-2">
									<label for="contact-name">DDD</label> <input type="text"
										name="ddd" value="${usuarioLogado.ddd}" class="contact-nameform-control">
								</div>
								
								<div class="form-group col-sm-5">
									<label for="contact-name">Telefone</label> <input type="text"
										name="telefone"
										value="${usuarioLogado.telefone}"
										class="contact-nameform-control">
								</div>
								
								<div class="form-group col-sm-6">
									<label for="contact-name">CEP</label> <input type="text"
										name="cep" value="${usuarioLogado.cep}"
										class="contact-nameform-control">
								</div>
								
								<div class="form-group col-sm-6">
									<label for="contact-name">Bairro</label> <input type="text"
										name="bairro"
										value="${usuarioLogado.bairro}"
										class="contact-nameform-control">
								</div>
								
								<div class="form-group col-sm-6">
									<label for="contact-name">Rua</label> <input type="text"
										name="rua" value="${usuarioLogado.rua}"
										class="contact-nameform-control">
								</div>
								
								<div class="form-group col-sm-2">
									<label for="contact-name">Número</label> <input type="text"
										name="numero"
										value="${usuarioLogado.numero}"
										class="contact-nameform-control">
								</div>
								
								<div class="form-group col-sm-5">
									<label for="contact-name">Complemento</label> <input
										type="text" name="complemento"
										value="${usuarioLogado.complemento}"
										class="contact-nameform-control">
								</div>
								<!-- 5 -->
								<div class="form-group col-sm-6">
									<label for="contact-email">Email</label> <input type="text"
										name="email" value="${usuarioLogado.email}"
										class="contact-emailform-control">
								</div>
								<div class="form-group col-sm-6">
									<label for="contact-email">Senha</label> <input type="password"
										name="senha" value="${usuarioLogado.senha}"
										class="contact-email form-control">
								</div>
								<button type="submit" class="btn">Atualizar</button>
							</div>
						</div>
					</div>
				</form>





				<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
				<!-- JQUERY SCRIPTS -->
				<script src="assetsPosLogin/js/jquery-1.10.2.js"></script>
				<!-- BOOTSTRAP SCRIPTS -->
				<script src="assetsPosLogin/js/bootstrap.min.js"></script>
				<!-- METISMENU SCRIPTS -->
				<script src="assetsPosLogin/js/jquery.metisMenu.js"></script>
				<!-- CUSTOM SCRIPTS -->
				<script src="assetsPosLogin/js/custom.js"></script>
			</div>
		</div>
				
	</div>
	
	<c:import url="footer.jsp" />
				
</body>
</html>