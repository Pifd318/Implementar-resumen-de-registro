<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="cl.talentodigital.entidades.*"%>
<!DOCTYPE html>
<%
	String nombreAtt = (String) request.getAttribute("nombreAtt");
	String telefonoAtt = (String) request.getAttribute("telefonoAtt");
	String idCursoAtt = (String) request.getAttribute("idCursoAtt");
	String idFormaPagoAtt = (String) request.getAttribute("idFormaPagoAtt");
	%>
<html>
<head>
<meta charset="ISO-8859-1">
<!--  css bootstrap 5 -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<title>Confirmacion</title>

</head>
	

<body>

	<!-- barra con menu -->
	<nav class="navbar navbar-expand-lg navbar-light  bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Mantenedor Cursos</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link"
						href="preListarInscripciones">Listado de cursos</a></li>
					<li class="nav-item"><a class="nav-link" href="preInscripcion">Inscribir en curso</a></li>
							
				</ul>
			</div>
		</div>
	</nav>






	<div class="card text-center">

		<div class="card-header">Datos de Inscripción</div>

	</div>

	<div class=container>
		<div class="card mb-3 border-light" style="max-width: 740px;">
			<div class="row g-0">
				<div class="col-md-4">
					<img
						src="https://cursosvirtualesgratis.com/wp-content/uploads/2020/09/curso-de-programacion-java-curso-java-web-java-programacion.jpg"
						class="img-fluid rounded-start" alt="...">
				</div>
				<div class="col-md-8">
					<div class="card-body">
						<h5 class="card-title">¡Felicidades, inscripción correcta!</h5>
						<p>
							Nombre:
							<%=nombreAtt%></p>
						<p>
							Teléfono:
							<%=telefonoAtt%></p>
						<p>
							ID Curso:
							<%=idCursoAtt%></p>
						<p>
							ID Forma de Pago:
							<%=idFormaPagoAtt%></p>
						<a href="preInscripcion" class="btn btn-success mt-3">Ir al
							inicio</a>

					</div>
				</div>
			</div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>
</body>
</html>