<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="utf-8"%>
<!-- Declaration to use JSTL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
</head>
<body>
	<h3>Buscar Servicos<h3>
		
			<jsp:useBean id="dao" class="br.com.petdelivery.jdbc.dao.ServicoDAO" />

			<form>
				<h4>Tipos de serviços</h4>
				<c:forEach var="servico" items="${dao.lista}">
					<div class="form-check form-check-inline">
						<label class="form-check-label"> <input
							class="form-check-input" type="checkbox" id="inlineCheckbox1"
							value="${servico.id_servico}">${servico.nome}
						</label>
					</div>
				</c:forEach>
				<br>
				<h4>Faixa de preço</h4>
				<!-- TODO -->>
				<h4>Bairro</h4>
				<!-- TODO -->>
				<h4>Delivery</h4>
				<!-- TODO -->>
				<h4>Petshop ou autonomo?</h4>
				<!-- TODO -->>
				
				
				<button type="submit" class="btn btn-primary">Submit</button>
			</form>


			<!-- Javascript -->
			<script src='<c:url value="assets/js/jquery-1.11.1.min.js"/>'></script>
			<script src='<c:url value="assets/bootstrap/js/bootstrap.min.js"/>'></script>
			<script
				src='<c:url value="assets/js/bootstrap-hover-dropdown.min.js"/>'></script>
			<script src='<c:url value="assets/js/wow.min.js"/>'></script>
			<script src='<c:url value="assets/js/retina-1.1.0.min.js"/>'></script>
			<script src='<c:url value="assets/js/jquery.magnific-popup.min.js"/>'></script>
			<script
				src='<c:url value="assets/flexslider/jquery.flexslider-min.js"/>'></script>
			<script src='<c:url value="assets/js/jflickrfeed.min.js"/>'></script>
			<script src='<c:url value="assets/js/masonry.pkgd.min.js"/>'></script>
			<script src="http://maps.google.com/maps/api/js?sensor=true"></script>
			<script src='<c:url value="assets/js/jquery.ui.map.min.js"/>'></script>
			<script src='<c:url value="assets/js/scripts.js"/>'></script>
</body>
</html>