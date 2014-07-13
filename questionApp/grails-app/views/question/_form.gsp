<%@ page import="com.opi.Question" %>



<div class="fieldcontain ${hasErrors(bean: questionInstance, field: 'title', 'error')} required">
	<label for="title">
		<g:message code="question.title.label" default="Title" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="title" maxlength="200" required="" value="${questionInstance?.title}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: questionInstance, field: 'text', 'error')} required">
	<label for="text">
		<g:message code="question.text.label" default="Text" />
		<span class="required-indicator">*</span>
	</label>
	<g:textArea name="text" cols="40" rows="5" maxlength="10000" required="" value="${questionInstance?.text}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: questionInstance, field: 'answers', 'error')} ">
	<label for="answers">
		<g:message code="question.answers.label" default="Answers" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${questionInstance?.answers?}" var="a">
    <li><g:link controller="answer" action="show" id="${a.id}">${a?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="answer" action="create" params="['question.id': questionInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'answer.label', default: 'Answer')])}</g:link>
</li>
</ul>


</div>

<div class="fieldcontain ${hasErrors(bean: questionInstance, field: 'deleted', 'error')} ">
	<label for="deleted">
		<g:message code="question.deleted.label" default="Deleted" />
		
	</label>
	<g:checkBox name="deleted" value="${questionInstance?.deleted}" />

</div>

<div class="fieldcontain ${hasErrors(bean: questionInstance, field: 'user', 'error')} required">
	<label for="user">
		<g:message code="question.user.label" default="User" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="user" name="user.id" from="${com.opi.User.list()}" optionKey="id" required="" value="${questionInstance?.user?.id}" class="many-to-one"/>

</div>

