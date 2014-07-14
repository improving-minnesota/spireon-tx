package com.opi

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(VoteController)
class VoteControllerSpec extends Specification {

	void "vodUpQuestion is redirected to Question.show"() {
		given:
		def question = Mock(Question)
		controller.params.id = '42'

		when:
		controller.voteUpQuestion()

		then:
		response.redirectedUrl == '/question/show/42'


	}
}
