<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<title>Contact</title>
	</head>
	<body>

        <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
        </g:if>

        <div class="panel panel-primary">
            <div class="panel-heading">
                <h3 class="panel-title">Contact Us</h3>
            </div>
            <div class="panel-body">
                Please fill out this form to send us a message




                <g:form action="save" class="form-horizontal" role="form">
                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label">Full Name</label>
                        <div class="col-sm-10">

                            <!-- use this textField as reference for the next two -->
                            <g:textField name="fullName" value="" class="form-control"/>

                        </div>
                    </div>
                    <div class="form-group">
                        <label for="email" class="col-sm-2 control-label">Email</label>
                        <div class="col-sm-10">

                            <!-- textField email here -->
                            <g:textField name="email" value="" class="form-control"/>

                        </div>
                    </div>
                    <div class="form-group">
                        <label for="phone" class="col-sm-2 control-label">Phone</label>
                        <div class="col-sm-10">

                            <!-- textField phone here -->
                            <g:textField name="phone" value="" class="form-control"/>

                        </div>
                    </div>
                    <div class="form-group">
                        <label for="note" class="col-sm-2 control-label">Note</label>
                        <div class="col-sm-10">

                            <!-- textArea for note here -->
                            <g:textArea name="note" value="" class="form-control"/>

                        </div>
                    </div>
                    <g:submitButton name="create" class="save" value="Send" />
                </g:form>




            </div>
        </div>

        <div class="panel panel-primary">
            <div class="panel-heading">
                <h3 class="panel-title">0xBuffer0verflow Company Info</h3>
            </div>
            <div class="panel-body">
                Here is our contact information if you need to reach us directly!

                <div class="form-horizontal" role="form">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Email us at</label>
                        <div class="col-sm-10">
                            <p class="form-control-static">${siteEmail}</p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Call us at</label>
                        <div class="col-sm-10">
                            <p class="form-control-static">${sitePhone}</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
	</body>
</html>
