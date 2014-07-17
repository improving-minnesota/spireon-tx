<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
	<meta content="main" name="layout" />
	<title>Most Recent Questions</title>
</head>

<body>
	<div class="page-header">
		<h2>Recent questions</h2>
	</div>

	<div class="fourteen columns offset-by-one">
		<div class="well well-lg">
			<g:each in="${questionInstanceList}" var="question">
				<h3><g:link controller="question" action="show" id="${question.id}">${question.title}</g:link></h3>
				<div> <question:summary question="${question}" /> </div>
			</g:each>

		</div>
	</div>
</body>
</html>