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
		
 	<h1> Detalhe do Servi�o </h1>
 	<br><br>
 	
 	<label for="contact-name" class="table-header"> Servi�o: </label>
 		<c:out value="${daoServico.getServicoById(servicoSelecionado.id_servico)}"/>
 		
	<br><label for="contact-name" class="table-header"> Nome do prestador: </label>
		<c:out value="${daoPrestador.getTipoById(servicoSelecionado.id_prestador) eq 0? daoAutonomo.getNomeById(servicoSelecionado.id_prestador) : daoPetshop.getNomeById(servicoSelecionado.id_prestador)}"/>
				
	<br><label for="contact-name" class="table-header"> E-mail do prestador: </label>
		<c:out value="${daoPrestador.getEmailById(servicoSelecionado.id_prestador)}"/>
		
	<br><label for="contact-name" class="table-header"> Nome do animal: </label>
		<c:out value="${daoAnimal.getAnimalById(servicoSelecionado.id_animal)}"/>
		
	<br><label for="contact-name" class="table-header"> Data de in�cio: </label>
		<c:out value="${servicoSelecionado.dataInicio}"/>
		
	<br><label for="contact-name" class="table-header"> Data de fim: </label>
		<c:out value="${servicoSelecionado.dataFim eq null? 'N�o informado' : servicoSelecionado.dataFim}"/>
	
	<br><label for="contact-name" class="table-header"> Hor�rio de in�cio: </label>
		<c:out value="${servicoSelecionado.horaInicio}"/>
		
	<br><label for="contact-name" class="table-header"> Hor�rio de fim: </label>
		<c:out value="${servicoSelecionado.horaFim eq null? 'N�o informado' : servicoSelecionado.horaFim}"/>
	
	<br><label for="contact-name" class="table-header"> Observa��o do Cliente: </label>
		<c:out value="${servicoSelecionado.obsCliente}"/>
	
	<br><label for="contact-name" class="table-header"> Delivery? </label>
		<c:out value="${servicoSelecionado.delivery eq 'true'? 'Sim' : 'N�o'}"/>
		
	<br><br><label for="contact-name" class="table-header"> Status: </label>
		<c:out value="${servicoSelecionado.status}"/>
		
	<br><label for="contact-name" class="table-header"> Observa��o do Prestador: </label>
	<c:out value="${servicoSelecionado.obsPrestador eq null? 'N�o informado' : servicoSelecionado.obsPrestador}"/>	
	
	<c:if test="${servicoSelecionado.status ne 'cancelado'}">
		<br><br><button type="submit" class="btn" onclick="editaServico()"> Editar Servi�o </button>
		<button type="submit" class="btn" onclick="confirmaCancelamento()">Cancelar Servi�o </button>										
	</c:if>
	
	<c:if test="${servicoSelecionado.status eq 'cancelado'}">
		<br><br><button type="submit" class="btn" onclick="excluiServico()"> Excluir Servi�o </button>												
	</c:if>	
		 
 	<script language="javascript">
	function editaServico(){	
		window.location = 'editaServico?id=' + ${servicoSelecionado.id_agendamento};				
	}
	
	function confirmaCancelamento(){
		if (confirm("Tem certeza que deseja cancelar este servi�o?"))
			window.location = 'cancelaServico?id=' + ${servicoSelecionado.id_agendamento}		
	}
	
	function excluiServico(){
		if (confirm("Tem certeza que deseja cancelar este servi�o?"))
			window.location = 'cancelaServico?id=' + ${servicoSelecionado.id_agendamento}		
	}
	</script>
 
</body>
</html>