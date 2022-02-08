<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Crud Agencia - Lista de Clientes</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="index.html">Agencia</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="index.html">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="CreateAndFind">Lista
							de Clientes</a></li>
				</ul>
				<form action="CreateAndFind" method="get" class="d-flex">
					<input name="pesquisa" class="form-control me-2" type="search"
						placeholder="Digite um nome ou CPF" aria-label="Search">
					<button class="btn btn-outline-success" type="submit">Buscar</button>
				</form>
			</div>
		</div>
	</nav>
	<div class="container">
		<div class="row">
			<div class="col-sm-3 col-md-7 col-xl-12">
				<hr>
				<h2>Clientes Cadastrados</h2>
				<hr>
				<table class="table">
					<thead>
						<tr>
							<th>#</th>
							<th>Nome</th>
							<th>CPF</th>
							<th>Data Nasc.</th>
							<th>Telefone</th>
							<th>E-mail</th>
							<th>Endereço</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${clientes}" var="cliente">
							<tr>
								<td>${cliente.idCliente}</td>
								<td>${cliente.nome}</td>
								<td>${cliente.cpf}</td>
								<td>${cliente.idade}</td>
								<td>${cliente.telefone}</td>
								<td>${cliente.email}</td>
								<td>${cliente.endereco}</td>
								<td><a class="btn btn-danger" href="ClienteDestroy?clienteIdCliente=${cliente.idCliente}">Deletar </a></td>
								<td><a class="btn btn-primary" href="ClienteUpdate?clienteIdCliente=${cliente.idCliente}">Atualizar</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<a class="btn btn-outline-success" href="index.html">Voltar</a>
			</div>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>