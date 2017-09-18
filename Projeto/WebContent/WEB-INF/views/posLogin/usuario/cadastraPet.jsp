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

	<!-- /. NAV SIDE  -->

	<div id="page-wrapper">
		<div id="page-inner">
			<div class="row">

				<div class="page-title-container">
					<div class="container">
						<div class="row">
							<div class="col-sm-10 col-sm-offset-1 page-title wow fadeIn">
								<span aria-hidden="true" class="icon_profile"></span>
								<h1>Cadastrar PET</h1>
							</div>
						</div>
					</div>
				</div>

				<form action="inserePet" class="form-horizontal" method="">
					<div class="form-group">
						<div class="container">
							<div class="col-sm-7 contact-form wow">
								<div class="form-group">
									<label for="contact-name">Nome</label><input type="text"
										name="nome" placeholder="Digite o nome do seu pet"
										class="contact-name form-control">
								</div>

								<div class="form-group">
									<label for="contact-name">Tipo de PET</label> <select
										name="id_tipo" id="id_tipo">
										<option selected disabled value="">Selecione...</option>
										<option value="1">Cachorro</option>
										<option value="2">Gato</option>
									</select>
								</div>

								<div class="form-group">
									<label for="contact-name">Raça</label> <select name="id_raca"
										id="id_raca">
										<option selected disabled value="">Selecione...</option>
										<option value="1">Vira-Lata</option>
										<option value="2">Oriental</option>
									</select>
								</div>

								<div class="form-group">
									<label for="contact-name">Gênero</label> <br> <input
										type="radio" name="genero" value="m"> Macho <br>
									<input type="radio" name="genero" value="f"> Fêmea <br>
								</div>

								<div class="form-group">
									<label for="contact-name">Pedigree</label> <br> <input
										type="radio" name="pedigree" value="true"> Sim <br>
									<input type="radio" name="pedigree" value="false"> Não
									<br>
								</div>

								<div class="form-group">
									<label for="contact-name">Porte</label> <select name="porte">
										<option value="">Selecione...</option>
										<option value="Pequeno">Pequeno</option>
										<option value="Médio">Médio</option>
										<option value="Grande">Grande</option>
									</select>
								</div>

								<div class="form-group">
									<label for="contact-name">Comportamento</label> <select
										name="comportamento">
										<option value="">Selecione...</option>
										<option value="Agitado">Agitado</option>
										<option value="Agressivo">Agressivo</option>
										<option value="Calmo">Calmo</option>
										<option value="Dócil">Dócil</option>
										<option value="Extrovertido">Extrovertido</option>
									</select>
								</div>

								<div class="form-group">
									<label for="contact-name">Vacinas</label><input type="text"
										name="vacinas"
										placeholder="Descreva detalhes sobre as vacinas de seu PET"
										class="contact-name form-control">
								</div>

								<div class="form-group">
									<label for="img">Selecione sua foto</label> <input type="file"
										name="foto" class="img form-control"
										accept="image/png, image/jpeg" multiple />
								</div>

								<input type="hidden" name="id_usuario"
									value="${usuarioLogado.cpf}" />

								<!-- input type="submit" class="btn" value="Registrar" /-->
								<button type="submit" class="btn" onclick="confirmaCadastro()">Registrar</button>
							</div>
						</div>
					</div>
				</form>

			</div>
		</div>
	</div>

	<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->

	<script language="javascript">
	function confirmaCadastro(){
		  alert('Cadastro realizado com sucesso!');  
	}
	
	</script>
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