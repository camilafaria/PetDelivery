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
	<c:import url="../../favicon.jsp" />
</head>

<body>
 	<jsp:useBean id="daoServico"
		class="br.com.petdelivery.jdbc.dao.ServicoDAO" />
	<jsp:useBean id="daoAnimal"
		class="br.com.petdelivery.jdbc.dao.AnimalDAO" />
	<jsp:useBean id="daoAutonomo"
		class="br.com.petdelivery.jdbc.dao.AutonomoDAO" />
	<jsp:useBean id="daoPetshop"
		class="br.com.petdelivery.jdbc.dao.PetshopDAO" />
	<jsp:useBean id="daoPrestador"
		class="br.com.petdelivery.jdbc.dao.PrestadorDAO" />
	<jsp:useBean id="daoServicoAutonomo"
		class="br.com.petdelivery.jdbc.dao.Servico_AutonomoDAO" />
	<jsp:useBean id="daoServicoPetshop"
		class="br.com.petdelivery.jdbc.dao.Servico_PetshopDAO" />
		
 	<c:import url="headerUsuario.jsp" />

	<jsp:include page="menuUsuario.jsp">
	<jsp:param name="foto" value="${usuarioLogado.foto}"/>
	</jsp:include>

	<!-- /. NAV SIDE  -->
	<div id="page-wrapper">
		<div id="page-inner">
			<div class="row" align="center">

				<div
					class="page-title-container title col-sm-12 col-sm-offset-1 page-title wow fadeIn">
					<span aria-hidden="true" class="fa fa-gear"></span>
					<h1>Editar Serviço</h1>
				</div>
 	
			 	<form action="confirmaEdicaoServico">
			 	
			 		<input hidden type="text" name="id_agendamento" value="${servicoSelecionado.id_agendamento}"/>
			 		<input hidden type="text" name="id_usuario" value="${servicoSelecionado.id_usuario}"/>
			 		<input hidden type="text" name="id_prestador" value="${servicoSelecionado.id_prestador}"/>
			 		<input hidden type="text" name="obsPrestador" value="${servicoSelecionado.obsPrestador}"/>
			 		<input hidden type="text" name="status" value="${servicoSelecionado.status}"/>
			 		
				 	<label for="contact-name" class="table-header"><br>
			 		<br> Serviço: </label>
				 	<select name="id_servico">
				 		<option selected value="${servicoSelecionado.id_servico}"> ${daoServico.getServicoById(servicoSelecionado.id_servico)} </option>
				 		<c:forEach var="servico" items="${daoPrestador.getTipoById(servicoSelecionado.id_prestador) eq 0? daoServicoAutonomo.getServico(servicoSelecionado.id_prestador) : daoServicoPetshop.getServico(servicoSelecionado.id_prestador)}">;
				 			<c:if test="${servico.id_servico ne servicoSelecionado.id_servico}">
				 				<option value="${servico.id_servico}"}> ${daoServico.getServicoById(servico.id_servico)} </option>
				 			</c:if>
						</c:forEach>
					</select>
					
					<br><label for="contact-name" class="table-header"><br> Nome do prestador: </label>
						<input type="text" name="" style=" width: 400px" class="contact-name form-control" value="${daoPrestador.getTipoById(servicoSelecionado.id_prestador) eq 0? daoAutonomo.getNomeById(servicoSelecionado.id_prestador) : daoPetshop.getNomeById(servicoSelecionado.id_prestador)}" readonly/>
								
					<br><label for="contact-name" class="table-header"> E-mail do prestador: </label>
						<input type="text" name="" style=" width: 400px" class="contact-name form-control" value="${daoPrestador.getEmailById(servicoSelecionado.id_prestador)}" readonly/>
						
					<br><label for="contact-name" class="table-header"> Nome do animal: </label>
						<select name="id_animal">
							<option selected value="${servicoSelecionado.id_animal}"> ${daoAnimal.getAnimalById(servicoSelecionado.id_animal)} </option>
							<c:forEach var="animal"	items="${daoAnimal.getAnimalUsuario(servicoSelecionado.id_usuario)}">	
								<c:if test="${animal.id_animal ne servicoSelecionado.id_animal}">
									<option value="${animal.id_animal}"> ${animal.nome} </option>
								</c:if>
							</c:forEach>
						</select>
			
					<br><br>
					
					<input type="radio" id="r1" name="radioData" value="dataInicio" onChange="checkRadioData()" checked>Apenas data de início 
					<input type="radio" id="r2" name="radioData" value="dataInicioFim" onChange="checkRadioData()"> Data de início e fim definidos <br>
					
					<br>
					<label for="contact-name">Data de Início:</label> 
						<input type="date" name="dataInicio" style=" width: 400px" id="dataInicio" class="contact-name form-control" min="2017-11-30" value="${servicoSelecionado.dataInicio}">
					
					<label for="contact-name">Data de Fim:</label> 
						<input type="date" name="dataFim" style=" width: 400px" id="dataFim" class="contact-name form-control" min="2017-10-30" value="${servicoSelecionado.dataFim}" disabled >
						
					<br><br>				
					<input type="radio" id="r1" name="radioTime" value="timeInicio" onChange="checkRadioTime()" checked>Apenas hora de início 
					<input type="radio" id="r2" name="radioTime" value="timeInicioFim" onChange="checkRadioTime()"> Hora de início e fim definidos <br>
									
					<label for="contact-name">Hora de Início</label> 
						<input type="text" name="horaInicio" style=" width: 400px" class="contact-name form-control" id="horaInicio" placeholder="hh:mm" value="${servicoSelecionado.horaInicio}"> 
					
					<label for="contact-name">Hora de Fim</label> 
						<input type="text" name="horaFim" style=" width: 400px" class="contact-name form-control" id="horaFim" placeholder="hh:mm" value="${servicoSelecionado.horaFim eq null? '' : servicoSelecionado.horaFim}" disabled>
						
					<br><label for="contact-name" class="table-header"> Observação: </label>
						<input type="text" name="obsCliente" style=" width: 400px" class="contact-name form-control" value="${servicoSelecionado.obsCliente}"/>
					
					<br><label for="contact-name" class="table-header"> Delivery? </label>
						<select name="delivery" id="delivery">
							<option value="true">Sim</option>
							<option value="false">Não</option>
						</select>
												
					<br><br><button type="submit" class="btn"> Atualizar </button>
						
				</form>
				
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
				</script>
	
			</div>
		</div>

	</div>

	<c:import url="footer.jsp" />
 
</body>
</html>