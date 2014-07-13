
<%@ page import="com.opi.Question" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'question.label', default: 'Question')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-question" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-question" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="title" title="${message(code: 'question.title.label', default: 'Title')}" />
					
						<g:sortableColumn property="text" title="${message(code: 'question.text.label', default: 'Text')}" />
					
						<g:sortableColumn property="dateCreated" title="${message(code: 'question.dateCreated.label', default: 'Date Created')}" />
					
						<g:sortableColumn property="deleted" title="${message(code: 'question.deleted.label', default: 'Deleted')}" />
					
						<g:sortableColumn property="lastUpdated" title="${message(code: 'question.lastUpdated.label', default: 'Last Updated')}" />
					
						<th><g:message code="question.user.label" default="User" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${questionInstanceList}" status="i" var="questionInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${questionInstance.id}">${fieldValue(bean: questionInstance, field: "title")}</g:link></td>
					
						<td>${fieldValue(bean: questionInstance, field: "text")}</td>
					
						<td><g:formatDate date="${questionInstance.dateCreated}" /></td>
					
						<td><g:formatBoolean boolean="${questionInstance.deleted}" /></td>
					
						<td><g:formatDate date="${questionInstance.lastUpdated}" /></td>
					
						<td>${fieldValue(bean: questionInstance, field: "user")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${questionInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
