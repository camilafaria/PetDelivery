<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> <!-- Declaration to use JSTL -->

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Lista Usuários</title>

<!-- CSS -->
<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,400">
<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Montserrat:700,400">
<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/elegant-font/code/style.css">
<link rel="stylesheet" href="assets/css/animate.css">
<link rel="stylesheet" href="assets/css/magnific-popup.css">
<link rel="stylesheet" href="assets/flexslider/flexslider.css">
<link rel="stylesheet" href="assets/css/form-elements.css">
<link rel="stylesheet" href="assets/css/style.css">
<link rel="stylesheet" href="assets/css/media-queries.css">

<!-- Favicon and touch icons -->
<link rel="shortcut icon" href="assets/ico/favicon.png">
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="assets/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="assets/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="assets/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="assets/ico/apple-touch-icon-57-precomposed.png">
</head>

<!-- Imports to use Scriplet -->
<%@ page
	import="java.util.*,
        br.com.petdelivery.*,
        br.com.petdelivery.jdbc.dao.UsuarioDAO,
        br.com.petdelivery.jdbc.modelo.Usuario"%>
       
</head>

<!-- CSS definition -->
<style>
table, th, td {
	border: 1px solid black;
}
</style>

<body>
	<c:import url="../header.jsp" />
	<h1>Escolha a melhor opção para o desenvolvimento :D</h1>
	<h1>Lista de Usuários com TagLib</h1>
	<table border="0">
		<jsp:useBean id="dao" class="br.com.petdelivery.jdbc.dao.UsuarioDAO" />
		<tr>
			<th>CPF</th>
			<th>Nome</th>
			<th>DDD</th>
			<th>Telefone</th>
			<th>Rua</th>
			<th>Numero</th>
			<th>Complemento</th>
			<th>Bairro</th>
			<th>Email</th>
			<th>Senha</th>
		</tr>
		<c:forEach var="usuario" items="${dao.lista}">
			<tr>
				<td>${usuario.cpf}</td>
				<td>${usuario.nome}</td>
				<td>${usuario.ddd}</td>
				<td>${usuario.telefone}</td>
				<td>${usuario.rua}</td>
				<td>${usuario.numero}</td>
				<td>${usuario.complemento}</td>
				<td>${usuario.bairro}</td>
				<td>${usuario.email}</td>
				<td>${usuario.senha}</td>
			</tr>
		</c:forEach>
	</table>

	<h1>Lista de Usuários com Scriplet</h1>
	<table border="0">
		<tr>
			<th>CPF</th>
			<th>Nome</th>
			<th>DDD</th>
			<th>Telefone</th>
			<th>Rua</th>
			<th>Numero</th>
			<th>Complemento</th>
			<th>Bairro</th>
			<th>Email</th>
			<th>Senha</th>
		</tr>
		<%
			UsuarioDAO usrDao = new UsuarioDAO();
			List<Usuario> usuarios = usrDao.getLista();

			for (Usuario usuario : usuarios) {
		%>
		<tr>
			<td><%=usuario.getCpf()%></td>
			<td><%=usuario.getNome()%></td>
			<td><%=usuario.getDdd()%></td>
			<td><%=usuario.getTelefone()%></td>
			<td><%=usuario.getRua()%></td>
			<td><%=usuario.getNumero()%></td>
			<td><%=usuario.getComplemento()%></td>
			<td><%=usuario.getBairro()%></td>
			<td><%=usuario.getEmail()%></td>
			<td><%=usuario.getSenha()%></td>
		</tr>
		<%
			}
		%>
	</table>
	<c:import url="../footer.jsp" />
</body>
</html>