<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>VCloud Traffic Controller - Traffic Panel</title>

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

<script type="text/javascript">
	var _root = "${pageContext.servletContext.contextPath}";
</script>

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
					<li><a
						href="${pageContext.servletContext.contextPath}/tc/terminal">Terminal</a></li>
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
				<c:choose>
					<c:when test="${serviceReseted}">
						<div class="bs-docs-section">
							<div class="alert alert-danger" role="alert">
								<strong>WARNNING</strong>
								Traffic Control Service Was Reseted! Must Setup Again !!!
							</div>
						</div>
					</c:when>
				</c:choose>
					
				<div class="bs-docs-section">
					<h1 id="overview" class="page-header">clearTrafficNics</h1>
					<form class="form-inline" role="form" onsubmit="return TC.clearTrafficNics();">
						<button type="submit" class="btn btn-default">clearTrafficNics</button>
					</form>
				</div>
				
				<div class="bs-docs-section">
					<h1 id="overview" class="page-header">preSetupTrafficNics</h1>
					<form class="form-inline" role="form" onsubmit="return TC.preSetupTrafficNics();">
						<div class="form-group">
							<div class="input-group">
								<div class="input-group-addon">Nic</div>
								<input type="text" class="form-control" id="pstnNic">
							</div>
						</div>
						<div class="form-group">
							<div class="input-group">
								<div class="input-group-addon">Start</div>
								<input class="form-control" type="text" id="pstnStart">
							</div>
						</div>
						<div class="form-group">
							<div class="input-group">
								<div class="input-group-addon">Stop</div>
								<input type="text" class="form-control" id="pstnStop">
							</div>
						</div>
						<div class="form-group">
							<div class="input-group">
								<div class="input-group-addon">Step</div>
								<input type="text" class="form-control" id="pstnStep">
							</div>
						</div>
						<button type="submit" class="btn btn-default">preSetupTrafficNics</button>
					</form>
				</div>
				
				<div class="bs-docs-section">
					<h1 id="overview" class="page-header">limitTrafficFromIp</h1>
					<form class="form-inline" role="form" onsubmit="return TC.limitTrafficFromIp();">
						<div class="form-group">
							<div class="input-group">
								<div class="input-group-addon">fromIp</div>
								<input type="text" class="form-control" id="ltfiIp">
							</div>
						</div>
						<div class="form-group">
							<div class="input-group">
								<div class="input-group-addon">bandwidth</div>
								<input class="form-control" type="text" id="ltfiBw">
							</div>
						</div>
						<button type="submit" class="btn btn-default">limitTrafficFromIp</button>
					</form>
				</div>
				
				<div class="bs-docs-section">
					<h1 id="overview" class="page-header">unlimitTrafficFromIp</h1>
					<form class="form-inline" role="form" onsubmit="return TC.unlimitTrafficFromIp();">
						<div class="form-group">
							<div class="input-group">
								<div class="input-group-addon">fromIp</div>
								<input type="text" class="form-control" id="ultfiIp">
							</div>
						</div>
						<div class="form-group">
							<div class="input-group">
								<div class="input-group-addon">bandwidth</div>
								<input class="form-control" type="text" id="ultfiBw">
							</div>
						</div>
						<button type="submit" class="btn btn-default">unlimitTrafficFromIp</button>
					</form>
				</div>
				
				<div class="bs-docs-section">
					<h1 id="overview" class="page-header">limitTrafficToIp</h1>
					<form class="form-inline" role="form" onsubmit="return TC.limitTrafficToIp();">
						<div class="form-group">
							<div class="input-group">
								<div class="input-group-addon">toIp</div>
								<input type="text" class="form-control" id="lttiIp">
							</div>
						</div>
						<div class="form-group">
							<div class="input-group">
								<div class="input-group-addon">bandwidth</div>
								<input class="form-control" type="text" id="lttiBw">
							</div>
						</div>
						<button type="submit" class="btn btn-default">limitTrafficToIp</button>
					</form>
				</div>
				
				<div class="bs-docs-section">
					<h1 id="overview" class="page-header">unlimitTrafficToIp</h1>
					<form class="form-inline" role="form" onsubmit="return TC.unlimitTrafficToIp();">
						<div class="form-group">
							<div class="input-group">
								<div class="input-group-addon">toIp</div>
								<input type="text" class="form-control" id="ulttiIp">
							</div>
						</div>
						<div class="form-group">
							<div class="input-group">
								<div class="input-group-addon">bandwidth</div>
								<input class="form-control" type="text" id="ulttiBw">
							</div>
						</div>
						<button type="submit" class="btn btn-default">unlimitTrafficToIp</button>
					</form>
				</div>
				<div class="bs-docs-section">
					<br/>
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
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/tc.js"></script>

</body>
</html>
