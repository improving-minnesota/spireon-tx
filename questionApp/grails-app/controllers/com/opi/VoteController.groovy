package com.opi

class VoteController {

	def voteUpQuestion(int id) {
		redirect(controller: 'question', action: 'show', id: id)
	}

	def voteDownQuestion(int id) {
		redirect(controller: 'question', action: 'show', id: id)
	}

}
