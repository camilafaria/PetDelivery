<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=utf-8"
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
 	<jsp:useBean id="daoServico"
		class="br.com.petdelivery.jdbc.dao.ServicoDAO" />
	<jsp:useBean id="daoUsuario"
		class="br.com.petdelivery.jdbc.dao.UsuarioDAO" />
	<jsp:useBean id="daoAnimal"
		class="br.com.petdelivery.jdbc.dao.AnimalDAO" />
		
 	<c:import url="headerAutonomo.jsp" />
 	<jsp:include page="menuAutonomo.jsp">
        <jsp:param name="foto" value="${prestadorAutonomoLogado.foto}"/>
    </jsp:include>
	
	
	<!-- /. NAV SIDE  -->
	<div id="page-wrapper">
		<div id="page-inner">
			<div class="row">

				<div class="page-title-container">
					<div class="container">
						<div class="title col-sm-9 page-title wow fadeIn">
							<span aria-hidden="true" class="fa fa-gear"></span>
							<h1>Detalhe do Serviço</h1>
						</div>
					</div>
				</div>
 				
			 	<label for="contact-name" class="table-header"> Serviço: </label>
			 		<c:out value="${daoServico.getServicoById(servicoSelecionado.id_servico)}"/>
			 		
				<br><label for="contact-name" class="table-header"> Nome do cliente: </label>
					<c:out value="${daoUsuario.getNameById(servicoSelecionado.id_usuario)}"/>
					
				<br><label for="contact-name" class="table-header"> E-mail do cliente: </label>
					<c:out value="${daoUsuario.getEmailById(servicoSelecionado.id_usuario)}"/>
					
				<br><label for="contact-name" class="table-header"> Nome do animal: </label>
					<c:out value="${daoAnimal.getAnimalById(servicoSelecionado.id_animal)}"/>
					
				<br><label for="contact-name" class="table-header"> Data de início: </label>
					<c:out value="${servicoSelecionado.dataInicio}"/>
					
				<br><label for="contact-name" class="table-header"> Data de fim: </label>
					<c:out value="${servicoSelecionado.dataFim eq null? 'Não informado' : servicoSelecionado.dataFim}"/>
				
				<br><label for="contact-name" class="table-header"> Horário de início: </label>
					<c:out value="${servicoSelecionado.horaInicio}"/>
					
				<br><label for="contact-name" class="table-header"> Horário de fim: </label>
					<c:out value="${servicoSelecionado.horaFim eq null? 'Não informado' : servicoSelecionado.horaFim}"/>
				
				<br><label for="contact-name" class="table-header"> Observação: </label>
					<c:out value="${servicoSelecionado.obsCliente}"/>
				
				<br><label for="contact-name" class="table-header"> Delivery? </label>
					<c:out value="${servicoSelecionado.delivery eq 'true'? 'Sim' : 'Não'}"/>
				
				<br><label for="contact-name" class="table-header"> Status: </label>
					<c:out value="${servicoSelecionado.status}"/>
				
				<c:if test="${servicoSelecionado.status eq 'a confirmar'}">
					<br><br><button type="submit" class="btn" onclick="confirmaServico()"> Confirmar serviço </button>
					<button type="submit" class="btn" onclick="confirmaCancelamento()">Cancelar serviço</button>								
				</c:if>
						
				<c:if test="${servicoSelecionado.status eq 'confirmado'}">				
					<br><br><button type="submit" class="btn" onclick="confirmaServico()"> Alterar serviço </button>
					<button type="submit" class="btn" onclick="confirmaCancelamento()">Cancelar serviço</button>								
				</c:if> 	 	
			 	 	
			 	 <!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
				<script language="javascript">
				function confirmaServico(){	
					var obs = prompt("Escreva aqui quaisquer observações sobre o serviço agendado:");
			
					if (obs == null || obs == "")
						window.location = 'updateStatus?id=' + ${servicoSelecionado.id_agendamento} + '&status=confirmado&obsPrestador=null';		
					else
						window.location = 'updateStatus?id=' + ${servicoSelecionado.id_agendamento} + '&status=confirmado&obsPrestador=' + obs;		
				}
				
				function confirmaCancelamento(){
					var obs = prompt("Justificativa para cancelamento do serviço:");
			
					if (obs == null || obs == "")
						window.alert("Insira uma justificativa!")	
					else
						window.location = 'updateStatus?id=' + ${servicoSelecionado.id_agendamento} + '&status=cancelado&obsPrestador=' + obs;
				}	
				</script> 	
				
			</div>
		</div>

	</div>
 
</body>
</html>