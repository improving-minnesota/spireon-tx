package com.opi



import spock.lang.*

/**
 *
 */
class QuestionControllerSpec extends Specification {
	QuestionController controller

    def setup() {
		controller = new QuestionController()
	}

    def cleanup() {
    }

	void "Question Controller returns json"() {
		given:
		controller.response.format = 'json'
		controller.params.id = '1'

		when:
		controller.show()

		then:
		controller.response.status == 200
		controller.response.contentType == 'application/json;charset=UTF-8'
	}
}
