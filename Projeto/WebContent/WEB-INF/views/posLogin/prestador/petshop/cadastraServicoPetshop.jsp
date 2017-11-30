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
	
	<jsp:useBean id="daoUnidade"
		class="br.com.petdelivery.jdbc.dao.Unidade_PetshopDAO" />

	<!-- /. NAV SIDE  -->

	<div id="page-wrapper">
		<div id="page-inner">
			<div class="row">

				<div class="page-title-container">
					<div class="container">
						<div class="row">
							<div class="title col-sm-9 page-title wow fadeIn">
								<span aria-hidden="true" class="fa fa-heart"></span>
								<h1>Cadastro de Serviços</h1>
							</div>
						</div>
					</div>
				</div>

				<form action="cadastroServicoPetshop" class="form-horizontal" method="post">
					<div class="form-group">
						<div class="container"  style="vertical-align: middle; margin-left:20%;" align="center">
							<div class="col-sm-6 contact-form wow">
															
								<div class="form-group">
									<label for="contact-name">Selecione a unidade: </label>
									
									<select name="id_unidade" id="id_unidade">
										<option selected disabled value="">Selecione uma unidade</option>
									
										<c:forEach var="unidade"
											items="${daoUnidade.getUnidadesByCNPJ(prestadorPetshopLogado.cnpj)}">
											<option value="${unidade.id_unidade}" }> ${unidade.nome} </option>										
										</c:forEach>
													
									</select>
									
								</div>
								
								<div class="form-group">
									<label for="contact-name">Selecione o serviço oferecido: </label>
									<select name="id_servico" id="id_servico">
										<option selected disabled value="">Selecione um serviço</option>
										<option value="1">Babá em Domicílio</option>
										<option value="2">Banho e Tosa</option>
										<option value="3">Dog Walker</option>
										<option value="4">Hotel</option>
										<option value="5">Veterinário</option>									
									</select>
								</div>
									
								<div class="form-group">
										<label for="contact-name">Preço: R$</label>
									<input type="number" step="0.01" name="preco" class="contact-name form-control" style="width:150px;">
								</div>

								<!-- podia ser só um checkbox -->
								<div class="form-group">
									<label for="contact-name">Para esse serviço, você oferece delivery?</label>
									<select name="delivery" id="delivery">
										<option selected disabled value=""></option>
										<option value="true">Sim</option>
										<option value="false">Não</option>								
									</select>
								</div>
								
								<div class="form-group">
									<label for="contact-name">Condições do serviço oferecido</label>
									<input type="text" name="condicoes" placeholder="Ex.: Pagamento antecipado"
										class="contact-name form-control">
								</div>
								
								<input type="hidden" name="cnpj"
									value="${prestadorPetshopLogado.cnpj}" />

								<!-- input type="submit" class="btn" value="Registrar" /-->
								<button type="submit" class="btn" onclick="confirmaCadastroServico()">Registrar</button>
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