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
<c:import url="../favicon.jsp" />
</head>

<body>

	<c:import url="headerUsuario.jsp" />
	<jsp:include page="menuUsuario.jsp">
	<jsp:param name="foto" value="${usuarioLogado.foto}"/>
</jsp:include>
	
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
									<label for="contact-name">Serviço a ser	agendado: </label>								
									<c:out value="${daoServico.getServicoById(id_servico)}" />									  								
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
								<div class="col-md-offset-2">
									<div class="form-group col-sm-5">
										<label for="contact-name">Data de Início:</label> 
										<input type="date" name="dataInicio" id="dataInicio" class="contact-name form-control" min="2017-11-30"> 
									</div>
									<div class="form-group col-sm-5">
										<label for="contact-name">Data de Fim:</label> 
										<input type="date" name="dataFim" id="dataFim" class="contact-name form-control" min="2017-11-30" disabled>
									</div>
									
									<br><br>
									
									<div class="form-group col-sm-10">
										<input type="radio" id="r1" name="radioTime" value="timeInicio" onChange="checkRadioTime()" checked>Apenas hora de início 
										<input type="radio" id="r2" name="radioTime" value="timeInicioFim" onChange="checkRadioTime()"> Hora de início e fim definidos <br>
									</div>
	
									<div class="form-group col-sm-5">
										<label for="contact-name">Hora de Início</label> 
										<input type="time" name="horaInicio" class="contact-name form-control" id="horaInicio" placeholder="hh:mm"> 
									</div>
									<div class="form-group col-sm-5">
										<label for="contact-name">Hora de Fim</label> 
										<input type="time" name="horaFim" class="contact-name form-control" id="horaFim" placeholder="hh:mm" disabled>
									</div>
								
									<br><br>
									
									<div class="form-group col-sm-10">
										<label for="contact-name">Observacões:</label> 
										<input	type="text" name="obsCliente" placeholder="Descreva as bservacoes sobre o servico" class="contact-name form-control">										
									</div>
	
									<c:if test= "${param.delivery eq 'true'}" >
										<div class="form-group col-sm-10">Deseja o serviço de delivery?</label> 
												<select name="delivery" id="delivery">
												<option value="true">Sim</option>
												<option value="false">Não</option>
												</select>
										</div>
									</c:if>						
	
									<input type="hidden" name="id_usuario"
										value="${usuarioLogado.cpf}" />
									
									<input type="hidden" name="id_prestador"
										value="${perfilPrestadorAutonomo.cpf}" />
										
									<input type="hidden" name="id_servico"
										value="${id_servico}" />
	
									<!-- input type="submit" class="btn" value="Registrar" /-->
									<br><br><br>
									
								</div>
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