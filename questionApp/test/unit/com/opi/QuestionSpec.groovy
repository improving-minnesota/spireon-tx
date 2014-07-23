package com.opi

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Question)
class QuestionSpec extends Specification {

	def setup() {
	}

	def cleanup() {
	}

	void "Question should validate"() {
		when:

		User u = new User(userName: 'bobmarley', firstName: 'Bob',
			lastName: 'Marley', email: 'bob@example.com')

		def q = new Question(title: 'What is def?',
			text: 'Please explain this thing called def.',
			user: u)
		q.validate()

		then:
        !q.hasErrors()
	}
}
