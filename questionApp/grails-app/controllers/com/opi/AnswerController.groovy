package com.opi

import grails.validation.ValidationException

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class AnswerController {

	static allowedMethods = [comment: 'POST']

	def answer() {
		Question question = params.id ? Question.get(params.id) : null
		User user = User.get(1)
		if (!question) {
			flash.message = "Question Not Found"
			redirect(controller: 'question', action: 'list')
		} else if (!user) {
			flash.message = "You must be logged in to submit an answer"
			redirect(controller: 'question', action: 'list')
		} else {
			println "params: $params"
			def answer = new Answer(text: params.answer, author: user)
			question.addToAnswers(answer)
			try {
				answer.save(failOnError: true)
				question.save(failOnError: true)
			} catch (ValidationException ex) {
				flash.error = "There was an issue adding your answer. Please try again"
			}
			redirect controller: "question", action: "show", id: question.id
		}
	}

}
