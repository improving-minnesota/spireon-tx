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
