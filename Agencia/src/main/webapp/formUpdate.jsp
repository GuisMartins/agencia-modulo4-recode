<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Crud Agencia - Atualizar Cliente</title>
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
			<div class="col-md-7">
				<hr>
				<h2>Atualizar Cliente</h2>
				<hr>
				<form action="ClienteUpdate" method="POST">
					<div class="form-floating mb-3">
						<input value="${cliente.idCliente}" name="idCliente" class="d-none"> 
					</div>
					<div class="form-floating mb-3">
						<input value="${cliente.nome}" name="name" maxlength="40" type="text" class="form-control"
							id="floating"> <label>Nome Completo</label>
					</div>
					<div class="form-floating mb-3">
						<input value="${cliente.cpf}" name="cpf" maxlength="11" type="text" class="form-control">
						<label>CPF (somente números)</label>
					</div>
					<div class="form-floating mb-3">
						<input value="${cliente.idade}" name="idade" type="date" class="form-control"
							placeholder="Nascimento"> <label>Data de nascimento</label>
					</div>
					<div class="form-floating mb-3">
						<input value="${cliente.endereco}" name="endereco" maxlength="60" type="text"
							class="form-control"> <label>Endereço</label>
					</div>
					<div class="form-floating mb-3">
						<input value="${cliente.telefone}" name="telefone" maxlength="20" type="text"
							class="form-control"> <label>Telefone</label>
					</div>
					<div class="form-floating mb-3">
						<input value="${cliente.email}" name="email" maxlength="60" type="text"
							class="form-control"> <label>E-mail</label>
					</div>
					<button class="btn btn-success" type="submit">Atualizar
						Cliente</button>
					<a class="btn btn-secondary " href="CreateAndFind">Voltar</a>
				</form>
			</div>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>