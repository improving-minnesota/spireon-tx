<%@ page import="com.opi.Question" %>
<!DOCTYPE html>
<html>
<head>
	<meta name="layout" content="main">
	<g:set var="entityName" value="${message(code: 'question.label', default: 'Question')}" />
	<title><g:message code="default.show.label" args="[entityName]" /></title>
</head>

<body>
	<a href="#show-question" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;" /></a>

	<div class="nav" role="navigation">
		<ul>
			<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label" /></a></li>
			<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
			<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
		</ul>
	</div>

	<div id="show-question" class="content scaffold-show" role="main">
		<h1><g:message code="default.show.label" args="[entityName]" /></h1>
		<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
		</g:if>
		<ol class="property-list question">
			<g:if test="${questionInstance?.title}">
				<li class="fieldcontain">
					<span id="title-label" class="property-label"><g:message code="question.title.label" default="Title" /></span>

					<span id="titleValue" class="property-value" aria-labelledby="title-label"><g:fieldValue bean="${questionInstance}" field="title" /></span>

				</li>
			</g:if>

			<g:if test="${questionInstance?.text}">
				<li class="fieldcontain">
					<span id="text-label" class="property-label"><g:message code="question.text.label" default="Text" /></span>

					<span id="textValue" class="property-value" aria-labelledby="text-label"><g:fieldValue bean="${questionInstance}" field="text" /></span>

				</li>
			</g:if>

			<g:if test="${questionInstance?.answers}">
				<li class="fieldcontain">
					<span id="answers-label" class="property-label"><g:message code="question.answers.label" default="Answers" /></span>

					<g:each in="${questionInstance.answers}" var="a">
						<span class="property-value" aria-labelledby="answers-label"><g:link controller="answer" action="show" id="${a.id}">${a?.encodeAsHTML()}</g:link></span>
					</g:each>

				</li>
			</g:if>

			<g:if test="${questionInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="question.dateCreated.label" default="Date Created" /></span>

					<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${questionInstance?.dateCreated}" /></span>

				</li>
			</g:if>

			<g:if test="${questionInstance?.deleted}">
				<li class="fieldcontain">
					<span id="deleted-label" class="property-label"><g:message code="question.deleted.label" default="Deleted" /></span>

					<span class="property-value" aria-labelledby="deleted-label"><g:formatBoolean boolean="${questionInstance?.deleted}" /></span>

				</li>
			</g:if>

			<g:if test="${questionInstance?.lastUpdated}">
				<li class="fieldcontain">
					<span id="lastUpdated-label" class="property-label"><g:message code="question.lastUpdated.label" default="Last Updated" /></span>

					<span class="property-value" aria-labelledby="lastUpdated-label"><g:formatDate date="${questionInstance?.lastUpdated}" /></span>

				</li>
			</g:if>

			<g:if test="${questionInstance?.user}">
				<li class="fieldcontain">
					<span id="user-label" class="property-label"><g:message code="question.user.label" default="User" /></span>

					<span class="property-value" aria-labelledby="user-label"><g:link controller="user" action="show" id="${questionInstance?.user?.id}">${questionInstance?.user?.encodeAsHTML()}</g:link></span>
				</li>
			</g:if>

		</ol>
		<g:form url="[resource: questionInstance, action: 'delete']" method="DELETE">
			<fieldset class="buttons">
				<g:link class="edit" action="edit" resource="${questionInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
				<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
			</fieldset>
		</g:form>
	</div>
</body>
</html>
