<html>
<head>
<title>AJAX in Servlet using JQuery and JSON</title>
<!-- JQUERY SCRIPTS -->
<script src="assetsPosLogin/js/jquery-1.10.2.js"></script>
<!-- BOOTSTRAP SCRIPTS -->
<script src="assetsPosLogin/js/bootstrap.min.js"></script>
<!-- METISMENU SCRIPTS -->
<script src="assetsPosLogin/js/jquery.metisMenu.js"></script>
<!-- CUSTOM SCRIPTS -->
<script src="assetsPosLogin/js/custom.js"></script>

<!-- <script>
$(document).ready(function() {

$('#sports').change(function(event) {
        var sports = $("select#sports").val();
        $.get('JsonServlet', {
                sportsName : sports
        }, function(response) {

        var select = $('#player');
        select.find('option').remove();
          $.each(response, function(index, value) {
          $('<option>').val(value).text(value).appendTo(select);
      });
        });
        });
});
</script>
 -->
 <script>
$(document).ready(function() {

$('#id_tipo').change(function(event) {
        var sports = $("select#id_tipo").val();
        $.get('JsonServlet', {
                id_tipo : sports
        }, function(response) {

        var select = $('#id_raca');
        select.find('option').remove();
          $.each(response, function(index, value) {
          $('<option>').val(value).text(value).appendTo(select);
      });
        });
        });
});
</script>
</head>
<body>

	<label>Tipo de PET</label>
	<select name="id_tipo" id="id_tipo">
		<option selected disabled value="">Selecione um animal</option>
		<option value="1">Cachorro</option>
		<option value="2">Gato</option>
	</select>
	<select id="id_raca">
		<option>Select Raça</option>
	</select>
	<h3>AJAX in Servlet using JQuery and JSON</h3>
	Select Favorite Sports:
	<select id="sports">
		<option>Select Sports</option>
		<option value="Football">Football</option>
		<option value="Cricket">Cricket</option>
	</select>
	<br />
	<br /> Select Favorite Player:
	<select id="player">
		<option>Select Player</option>
	</select>
</body>
</html>