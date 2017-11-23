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
	<jsp:useBean id="daoUsuario"
		class="br.com.petdelivery.jdbc.dao.UsuarioDAO" />
	<jsp:useBean id="daoAnimal"
		class="br.com.petdelivery.jdbc.dao.AnimalDAO" />
		
 	<h1> Detalhe do Serviço </h1>
 	<br><br>
 	
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
		<c:out value="${servicoSelecionado.observacao}"/>
	
	<br><label for="contact-name" class="table-header"> Delivery? </label>
		<c:out value="${servicoSelecionado.delivery eq 'true'? 'Sim' : 'Não'}"/>
	
	<form action="updateStatus" class="form-horizontal" method="post">
		<label for="contact-name" class="table-header"> Status: </label>
			<select name="status" id="status">
				<option value="confirmado">Confirmado</option>
				<option value="cancelado">Cancelado</option>
			</select>
		
		<input hidden type="text" name="id_agendamento" value="${servicoSelecionado.id_agendamento}">
		<button type="submit" class="btn">Atualizar status</button>
	</form> 	
 	 	
</body>
</html>