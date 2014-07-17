<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
	<meta content="main" name="layout">
	<title>Question</title>
</head>

<body>
	<bo:row>
		<div class="col-md-1">
			<div class="row">
				<g:link controller="vote" action="voteUpQuestion" id="${questionInstance.id}">
					<span class="glyphicon glyphicon-plus"></span>
				</g:link>
			</div>
			<h2>${questionInstance.voteCount}</h2>

			<div class="row">
				<g:link controller="vote" action="voteDownQuestion" id="${questionInstance.id}">
					<span class="glyphicon glyphicon-minus"></span>
				</g:link>
			</div>
		</div>

		<div class="col-md-10">
			<div class="row">
				<div class="col-md-9">
					<h2>${questionInstance.title}</h2>
				</div>

			</div>

			<p>${questionInstance.text}</p>

			<div class="row">
				<div class="offset8">
					<bo:signature user="${questionInstance.user}" />
				</div>
			</div>

			<g:render template="answered" collection="${answers}" var="answer" />

		</div>
	</bo:row>

	<div class="row">
		<div class="col-md-8 col-md-offset-2">
			<g:if test="${flash.message}">
				<div class="alert alert-error">${flash.message}</div>
			</g:if>

			<g:hasErrors bean="${answer}">
				<g:renderErrors bean="${answer}" as="list" />
			</g:hasErrors>

			<g:form class="form" controller="answer" action="answer" id="${questionInstance.id}">
				<div class="form-group">
					<label for="answer">Your Answer</label>
				</div>

				<div class="form-group">
					<g:textArea name="answer" rows="10" cols="80" />
				</div>

				<div class="form-group">
					<g:submitButton class="btn" name="postAnswer" value="Post Answer" />
				</div>
			</g:form>
		</div>
	</div>

</body>
</html>
