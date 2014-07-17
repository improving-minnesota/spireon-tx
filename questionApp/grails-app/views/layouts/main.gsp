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
	<g:render template="/navbar" />

	<div class="container">
		<g:layoutBody />
	</div> <!-- /container -->

	<div class="footer" role="contentinfo"></div>

</body>
</html>
