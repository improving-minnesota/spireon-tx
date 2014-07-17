package com.opi

import grails.validation.ValidationException

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class AnswerController {

	static allowedMethods = [comment: 'POST']

	def answer(AnswerCommand cmd) {
		if (cmd.validate()) {
			def question = cmd.id
			User user = User.get(1)

			def answer = new Answer(text: params.answer, author: user)
			question.addToAnswers(answer)
			try {
				answer.save(failOnError: true)
				question.save(failOnError: true)
				flash.message = "Your answer was created successfully."
			} catch (ValidationException ex) {
				flash.message = "There was an issue adding your answer. Please try again"
			}
			redirect controller: "question", action: "show", id: question.id
		} else {
			if (cmd.id) {
				flash.message = "There was an issue adding your answer. Please try again"
				redirect(controller: 'question', action: 'show', id: cmd.id)
			} else {
				flash.message = "Question Not Found"
				redirect(controller: 'question', action: 'list')
			}
		}
	}

}
