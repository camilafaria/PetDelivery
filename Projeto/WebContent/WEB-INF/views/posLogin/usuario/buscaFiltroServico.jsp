<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="utf-8"%>
<!-- Declaration to use JSTL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
</head>
<body>
	<h3>
		Buscar Servicos
		<h3>

			<jsp:useBean id="daoServico"
				class="br.com.petdelivery.jdbc.dao.ServicoDAO" />
			<jsp:useBean id="daoHelper"
				class="br.com.petdelivery.jdbc.dao.HelperDAO" />

			<form>
				<div class="form-group row">
					<label for="inputEmail3" class="col-sm-2 col-form-label">Lista
						de Serviços</label>
					<c:forEach var="servico" items="${daoServico.lista}">
						<div class="form-check form-check-inline">
							<label class="form-check-label"> <input
								class="form-check-input" type="checkbox" id="inlineCheckbox1"
								name="servico" value="${servico.id_servico}">${servico.nome}
							</label>
						</div>
					</c:forEach>
				</div>

				<div class="form-group row">
					<label for="inputEmail3" class="col-sm-2 col-form-label">
						Faixa de Preço </label>
					<div class="col-sm-5">
						<input type="text" class="form-control" name="precoDe"
							placeholder="De..">
					</div>
					<div class="col-sm-5">
						<input type="text" class="form-control" name="precoAte"
							placeholder="Até..">
					</div>
				</div>

				<div class="form-group row">
					<label for="inputEmail3" class="col-sm-2 col-form-label">Bairro</label>
					<select id="inputBairro" class="form-control" name="bairro">
						<option value="">...</option>
						<c:forEach var="bairro" items="${daoHelper.getTodosBairros()}">
							<option value="${bairro}">${bairro}</option>
						</c:forEach>
					</select>
				</div>

				<h4>Delivery</h4>
				<!-- TODO -->
				<fieldset class="form-group">
					<div class="row">
						<legend class="col-form-legend col-sm-2">Petshop ou
							autonomo?</legend>
						<div class="col-sm-10">
							<div class="form-check">
								<label class="form-check-label"> <input
									class="form-check-input" type="radio" name="autonomoOuPetshop"
									id="gridRadios1" value="" checked> Indiferente
								</label>
							</div>
							<div class="form-check">
								<label class="form-check-label"> <input
									class="form-check-input" type="radio" name="autonomoOuPetshop"
									id="gridRadios2" value="autonomo"> Autonomos
								</label>
							</div>
							<div class="form-check disabled">
								<label class="form-check-label"> <input
									class="form-check-input" type="radio" name="autonomoOuPetshop"
									id="gridRadios3" value="petshop"> Petshops
								</label>
							</div>
						</div>
					</div>
				</fieldset>


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