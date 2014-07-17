package com.opi

import grails.validation.Validateable

@Validateable
class AnswerCommand {
	Question id
	String answer

	static constraints = {
		id nullable: false, blank: false
		answer nullable: false, blank: false
	}
}
