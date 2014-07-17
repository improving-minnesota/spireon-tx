<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title><g:layoutTitle default="Grails" /> | BufferOverflow.com</title>
	<meta name="description" content="">
	<meta name="author" content="">

	<!-- HTML5 shim, for IE6-8 support of HTML elements -->
	<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
	<style>
	body {
		padding-top: 60px; /* 60px to make the container go all the way to the bottom of the topbar */
	}
	</style>

	<!-- fav and touch icons -->
	<link rel="shortcut icon" href="images/favicon.ico">
	<link rel="apple-touch-icon" href="images/apple-touch-icon.png">

	<link rel="apple-touch-icon" sizes="72x72" href="images/apple-touch-icon-72x72.png">

	<link rel="apple-touch-icon" sizes="114x114" href="images/apple-touch-icon-114x114.png">
	<asset:stylesheet src="application.css" />
	<asset:javascript src="application.js" />

	<g:layoutHead />
</head>

<body>

	<nav class="navbar navbar-default" role="navigation">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<g:link class="navbar-brand" mapping="home">0xBuffer0verflow</g:link>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<bo:header action="${['list', '']}"><g:link mapping="home">Home</g:link></bo:header>
					<bo:header action="${['create']}"><g:link controller="question" action="create">Ask Questions</g:link></bo:header>
					<li><a href="#about">About</a></li>
					<li><a href="#contact">Contact</a></li>
				</ul>

				<form class="navbar-form navbar-left" role="search">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Search">
					</div>
				</form>
			</div><!-- /.navbar-collapse -->
		</div><!-- /.container-fluid -->
	</nav>

	<div class="container">

		<g:layoutBody />

	</div> <!-- /container -->

	<div class="footer" role="contentinfo"></div>

</body>
</html>
