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

	<c:import url="headerAutonomo.jsp" />
	<jsp:include page="menuAutonomo.jsp">
        <jsp:param name="foto" value="${prestadorAutonomoLogado.foto}"/>
    </jsp:include>
	
	<jsp:useBean id="daoServico"
		class="br.com.petdelivery.jdbc.dao.ServicoDAO" />
	
	<!-- /. NAV SIDE  -->

	<div id="page-wrapper">
		<div id="page-inner">
			<div class="row">

				<div class="page-title-container">
					<div class="container">
						<div class="row">
							<div class="title col-sm-9 page-title wow fadeIn">
								<span aria-hidden="true" class="fa fa-heart"></span>
								<h1>Meu Servico</h1>
							</div>
						</div>
					</div>
				</div>

				<form action="confirmaEdicaoServicoAutonomo" class="form-horizontal" method="post">
					<div class="form-group">
						<div class="container col-md-offset-2"  style="vertical-align: middle;" align="center">
							<div class="col-sm-7 contact-form wow">
								<div class="form-group">
									<label for="contact-name">Serviço oferecido: </label>
									<select name="id_servico" id="id_servico">
										<option selected disabled value="${servicoSelecionado.id_servico}"> ${daoServico.getServicoById(servicoSelecionado.id_servico)} </option>
									</select>
								</div>
								
								<div class="form-group">
									<label for="contact-name ">Preço: R$</label>
									<input type="number" step="0.01" name="preco" class="contact-name form-control" style="width:150px;" value="${servicoSelecionado.preco}">
								</div>
								
								<div class="form-group">
									<label for="contact-name col-md-12">Para esse serviço, você oferece delivery?</label>
									<select name="delivery" id="delivery">
										<option selected value="${servicoSelecionado.delivery}"> ${servicoSelecionado.delivery eq true ? 'Sim' : 'Não'} </option>
										
										<c:if test="${servicoSelecionado.delivery eq true}">
											<option value="false">Não</option>
										</c:if>
										
										<c:if test="${servicoSelecionado.delivery eq false}">
											<option value="true">Sim</option>
										</c:if>								
									</select>
								</div>

								<div class="form-group col-md-12">
									<label for="contact-name">Condições do serviço oferecido</label>
									<input type="text" name="condicoes" value="${servicoSelecionado.condicoes}"
										class="contact-name form-control">
								</div>												
								
								<input type="hidden" name="cpf"	value="${servicoSelecionado.cpf}" />
								<input type="hidden" name="id_servicoAutonomo"	value="${servicoSelecionado.id_servicoAutonomo}" />
								<input type="hidden" name="id_servico" value="${servicoSelecionado.id_servico}" />

								<button type="submit" class="btn">Atualizar</button>								
							</div>
						</div>
					</div>
				</form>

			</div>
		</div>
	</div>

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