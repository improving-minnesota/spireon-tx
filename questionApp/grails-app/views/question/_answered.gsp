<div class="well">
	<div class="row answer">

		<div class="col-md-1" style="padding-left:20px;">
			<div class="row">
				<g:link controller="vote" action="voteUpAnswer" id="${answer.id}">
					<span class="glyphicon glyphicon-plus"></span>
				</g:link>
			</div>
			<h2>${answer.voteCount}</h2>

			<div class="row">
				<g:link controller="vote" action="voteDownAnswer" id="${answer.id}">
					<span class="glyphicon glyphicon-minus"></span>
				</g:link>
			</div>
		</div>

		<div class="col-md-7">
			<p>
				${answer.text}
				<bo:signature user="${answer.author}" />
			</p>
		</div>
	</div>
</div>


