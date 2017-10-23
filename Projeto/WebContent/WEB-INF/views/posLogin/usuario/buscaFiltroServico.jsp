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

	<c:import url="headerUsuario.jsp" />

	<c:import url="menuUsuario.jsp" />

	<!-- /. NAV SIDE  -->
	
	
	<div id="page-wrapper">
		<div id="page-inner">
			<div class="row">

				<div class="page-title-container">
					<div class="container">
						<div class="row">
							<div class="title col-sm-9 col-sm-offset-1 page-title wow fadeIn">
								<span aria-hidden="true" class="icon_search"></span>
								<h1>Buscar Serviços</h1>
							</div>
						</div>
					</div>
				</div>

				<jsp:useBean id="daoServico"
				class="br.com.petdelivery.jdbc.dao.ServicoDAO" />
				<jsp:useBean id="daoHelper"
					class="br.com.petdelivery.jdbc.dao.HelperDAO" />
					<br>
					<br>
	
				<form action="buscar-servico" class="form-horizontal" method="get">
					<div class="form-group row">
						<label for="inputEmail3" class="col-sm-4 col-form-label">Serviços disponíveis</label>
						<div class="col-sm-8">
						<c:forEach var="servico" items="${daoServico.lista}">
							<div class="col-sm-2 col-form-label">
								<label class="form-check-label"> <input
									class="form-check-input" type="checkbox" id="inlineCheckbox1"
									name="servico" value="${servico.id_servico}">${servico.nome}
								</label>
							</div>
						</c:forEach>
						</div>
					</div>
	
					<div class="form-group row">
						<label for="inputEmail3" class="col-sm-4 col-form-label">
							Faixa de Preço </label>
						<div class="col-sm-2">
							<input type="text" class="form-control" name="precoDe"	placeholder="De..">
						</div>
						<div class="col-sm-2">
							<input type="text" class="form-control" name="precoAte"
								placeholder="Até..">
						</div>
					</div>
	
					<div class="form-group row">
						<label for="inputEmail3" class="col-sm-4 col-form-label">Bairro</label>
						<div class="col-sm-2">
						<select id="inputBairro" class="form-control" name="bairro">
							<option value="">...</option>
							<c:forEach var="bairro" items="${daoHelper.getTodosBairros()}">
								<option value="${bairro}">${bairro}</option>
							</c:forEach>
						</select>
						</div>
					</div>
	
					<div class="form-group row">
						<label for="inputEmail3" class="col-sm-4 col-form-label">Delivery</label>
						<div class="col-sm-2">
						<select id="inputBairro" class="form-control" name="delivery">
							<option value="">...</option>
							<option value="true">Sim</option>
							<option value="false">Não</option>
						</select>
						</div>
					</div>
					
					<fieldset class="form-group">
						<div class="row">
							<legend class="col-form-legend col-sm-6">Petshop ou autonomo?</legend>
							<div class="col-sm-12">
							
								<div class="form-check">
									<label class="form-check-label"> <input
										class="form-check-input" type="radio" name="autonomoOuPetshop"
										id="gridRadios1" value="" checked> Indiferente
									</label>
								</div>
								<div class="form-check">
									<label class="form-check-label"> <input
										class="form-check-input" type="radio" name="autonomoOuPetshop"
										id="gridRadios2" value="autonomo"> Autônomo
									</label>
								</div>
								<div class="form-check disabled">
									<label class="form-check-label"> <input
										class="form-check-input" type="radio" name="autonomoOuPetshop"
										id="gridRadios3" value="petshop"> Petshop
									</label>
								</div>
							</div>
						</div>
					</fieldset>
					<button type="submit" class="btn btn-primary">Buscar</button>
				</form>
				
			</div>
		</div>
	</div>


	<c:import url="footer.jsp" />

	<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->

	<script language="javascript">
	function confirmaCadastroPet(){
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