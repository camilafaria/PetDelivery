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
						<div class="container"
							style="vertical-align: middle; margin-left: 20%;" align="center">
							<div class="col-sm-7 contact-form wow">
								<div class="form-group">
									<label for="contact-name">Serviço a ser
										agendado: </label> <select name="id_servico" id="id_servico" onChange="checkDelivery()">

										<option selected disabled value="">Selecione um serviço</option>
										<c:forEach var="servico"
											items="${daoServicoAutonomo.getServico(perfilPrestadorAutonomo.cpf)}">
											<option value="${servico.id_servico}"}> ${daoServico.getServicoById(servico.id_servico)} </option>
										</c:forEach>

									</select>
								</div>

								<div class="form-group">
									<label for="contact-name">Selecione o animal para o
										qual o serviço será agendado: </label> <select name="id_animal"
										id="id_animal">
										<option selected disabled value="">Selecione um animal</option>

										<c:forEach var="animal"
											items="${daoAnimal.getAnimalUsuario(usuarioLogado.cpf)}">
											<option value="${animal.id_animal}"}> ${animal.nome} </option>
										</c:forEach>

									</select>
								</div>

								<div class="form-group">
									<input type="radio" id="r1" name="radioData" value="dataInicio" onChange="checkRadioData()" checked>Apenas data de início 
									<input type="radio" id="r2" name="radioData" value="dataInicioFim" onChange="checkRadioData()"> Data de início e fim definidos <br>
								</div>
								
								<div class="form-group col-sm-5">
									<label for="contact-name">Data de Início:</label> 
									<input type="date" name="dataInicio" id="dataInicio" class="contact-name form-control" min="2017-10-26"> 
								</div>
								<div class="form-group col-sm-5">
									<label for="contact-name">Data de Fim:</label> 
									<input type="date" name="dataFim" id="dataFim" class="contact-name form-control" min="2017-10-26" disabled>
								</div>
								
								<br><br>
								
								<div class="form-group col-sm-10">
									<input type="radio" id="r1" name="radioTime" value="timeInicio" onChange="checkRadioTime()" checked>Apenas hora de início 
									<input type="radio" id="r2" name="radioTime" value="timeInicioFim" onChange="checkRadioTime()"> Hora de início e fim definidos <br>
								</div>

								<div class="form-group col-sm-5">
									<label for="contact-name">Hora de Início</label> 
									<input type="time" name="horaInicio" class="contact-name form-control" id="horaInicio"> 
								</div>
								<div class="form-group col-sm-5">
									<label for="contact-name">Hora de Fim</label> 
									<input type="time" name="horaFim" class="contact-name form-control" id="horaFim" disabled>
								</div>
								
								<br><br>
								
								<div class="form-group col-sm-10">
									<label for="contact-name">Observacões:</label> <input
										type="text" name="observacoes"
										placeholder="Descreva quaisquer observacoes sobre o servico"
										class="contact-name form-control">
								</div>

								<div class="form-group">
									<label for="contact-name">Se disponível, deseja o
										serviço de delivery?</label> <select name="delivery" id="id_servico">
										<option value="1">Sim</option>
										<option value="2">Não</option>
									</select>
								</div>

								<input type="hidden" name="id_usuario"
									value="${usuarioLogado.cpf}" />

								<!-- input type="submit" class="btn" value="Registrar" /-->
								<button type="submit" class="btn">Agendar servico</button>
							</div>
						</div>
					</div>
				</form>

			</div>
		</div>
	</div>

	<c:import url="footer.jsp" />

	<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
	<script language="javascript">
	function checkRadioData(){
		var selectedValue = document.querySelector('input[name="radioData"]:checked').value;
		if(selectedValue=="dataInicio"){			
			document.getElementById("dataFim").setAttribute('disabled',true);
		}else{			
			document.getElementById("dataFim").removeAttribute('disabled');
		}
	}
	
	function checkRadioTime(){
		var selectedValue = document.querySelector('input[name="radioTime"]:checked').value;
		if(selectedValue=="timeInicio"){			
			document.getElementById("horaFim").setAttribute('disabled',true);
		}else{			
			document.getElementById("horaFim").removeAttribute('disabled');
		}
	}
	
	</script><!-- JQUERY SCRIPTS -->
	<script src="assetsPosLogin/js/jquery-1.10.2.js"></script>
	<!-- BOOTSTRAP SCRIPTS -->
	<script src="assetsPosLogin/js/bootstrap.min.js"></script>
	<!-- METISMENU SCRIPTS -->
	<script src="assetsPosLogin/js/jquery.metisMenu.js"></script>
	<!-- CUSTOM SCRIPTS -->
	<script src="assetsPosLogin/js/custom.js"></script>

</body>
</html>