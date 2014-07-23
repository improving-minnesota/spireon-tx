package com.opi

import grails.transaction.Transactional
import grails.validation.ValidationException

@Transactional(readOnly = true)
class AnswerController {

    static allowedMethods = [comment: 'POST']

    def answer(AnswerCommand cmd) {
        if (cmd.hasErrors()) {
            if (cmd.id) {
                flash.message = "There was an issue adding your answer. Please try again"
                redirect(controller: 'question', action: 'show', id: cmd.id.id)
            } else {
                flash.message = "The Question was not found"
                redirect(controller: 'question', action: 'index')
            }
        } else {
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
        }
    }

}
