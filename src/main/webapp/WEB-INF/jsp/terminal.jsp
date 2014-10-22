<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>VCloud Traffic Controller - Firewall Panel</title>

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
				<div class="bs-docs-section">
					<h1 id="overview" class="page-header">Terminal</h1>
					<form role="form" onsubmit="return TC.execSimpleScript();">
						<div class="form-group">
							<textarea id="script" class="form-control" rows="3" name="script"></textarea>
						</div>
						<button type="submit" class="btn btn-primary">Execute</button>
					</form>
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
