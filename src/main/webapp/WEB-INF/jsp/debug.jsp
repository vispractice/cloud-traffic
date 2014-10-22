<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>VCloud Traffic Controller - Debug Info Panel</title>

<!-- Bootstrap core CSS -->
<link
	href="${pageContext.servletContext.contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Documentation extras -->
<link
	href="${pageContext.servletContext.contextPath}/resources/css/docs.min.css"
	rel="stylesheet">
<!--[if lt IE 9]><script src="../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script
	src="${pageContext.servletContext.contextPath}/resources/js/ie10-viewport-bug-workaround.js"></script>
<script
	src="${pageContext.servletContext.contextPath}/resources/js/ie-emulation-modes-warning.js"></script>

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<![endif]-->

</head>
<body class="bs-docs-home">
	<!-- Docs master nav -->
	<header class="navbar navbar-static-top bs-docs-nav" id="top"
		role="banner">
		<div class="container">
			<div class="navbar-header">
				<button class="navbar-toggle" type="button" data-toggle="collapse"
					data-target=".bs-navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a href="${pageContext.servletContext.contextPath}"
					class="navbar-brand">Traffic Controller</a>
			</div>
			<nav class="collapse navbar-collapse bs-navbar-collapse"
				role="navigation">
				<ul class="nav navbar-nav">
					<li><a
						href="${pageContext.servletContext.contextPath}/tc/traffic">Traffic</a></li>
					<li><a
						href="${pageContext.servletContext.contextPath}/tc/firewall">Firewall</a></li>
					<li><a href="${pageContext.servletContext.contextPath}/tc/terminal">Terminal</a></li>
					<li><a
						href="${pageContext.servletContext.contextPath}/tc/debug">Debug</a></li>
				</ul>
			</nav>
		</div>
	</header>

	<!-- Page content of course! -->
	<div class="container">
		<div class="row">
			<div class="col-md-12" role="main">
				<div class="bs-docs-section">
					<h1 id="overview" class="page-header">Traffic Controll</h1>
					<table class="table">
						<thead>
							<tr>
								<th>#</th>
								<th>Qdisc</th>
								<th>Class</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>eth0</td>
								<td>${debugInfo.eth0Qdisc.description }</td>
								<td>${debugInfo.eth0Class.description }</td>
							</tr>
							<tr>
								<td>eth1</td>
								<td>${debugInfo.eth1Qdisc.description }</td>
								<td>${debugInfo.eth1Class.description }</td>
							</tr>
							<tr>
								<td>eth2</td>
								<td>${debugInfo.eth2Qdisc.description }</td>
								<td>${debugInfo.eth2Class.description }</td>
							</tr>
						</tbody>
					</table>
				</div>
				
				<div class="bs-docs-section">
					<h1 id="overview" class="page-header">Iptables</h1>
					<table class="table">
						<thead>
							<tr>
								<th>#</th>
								<th>Rule</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>mangle</td>
								<td>${debugInfo.mangle.description }</td>
							</tr>
							<tr>
								<td>filter</td>
								<td>${debugInfo.filter.description }</td>
							</tr>
							<tr>
								<td>nat</td>
								<td>${debugInfo.nat.description }</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>

	<script
		src="${pageContext.servletContext.contextPath}/resources/js/jquery.min.js"></script>
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/bootstrap.min.js"></script>
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/docs.min.js"></script>

</body>
</html>
