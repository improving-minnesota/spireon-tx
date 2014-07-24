<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
	<meta content="main" name="layout" />
	<title>Most Recent Questions</title>
</head>

<body>

    <%-- Uncomment the below section for the 'flash' message lab --%>
    <%--
    <g:if test="${flash.message}">
        <div class="alert alert-warning" role="alert">${flash.message}</div>
    </g:if>
    --%>

<div class="page-header">
		<h2>Recent questions</h2>
	</div>

	<div class="fourteen columns offset-by-one">
		<div class="well well-lg">


				<h3><g:link controller="question" action="show" id="${questionInstanceList[0].id}">${questionInstanceList[0].title}</g:link></h3>


		</div>
	</div>
</body>
</html>