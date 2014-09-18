package geb

import geb.spock.GebReportingSpec

import spock.lang.*

import geb.pages.QuestionCreatePage
import geb.pages.QuestionShowPage

class CreateQuestionFunctionalSpec extends GebReportingSpec {
	def "should create questions"() {
		given: "the question creation page"
		QuestionCreatePage questionCreatePage = to(QuestionCreatePage)

		when: "the user creates a new question"
		String title = "I have a great Question"
		String text = "Is this going to work?"

		QuestionShowPage questionShowPage = questionCreatePage.createQuestion(title, text)

		then: "should show the new question"
		assert questionShowPage.titleText == title
		assert questionShowPage.textText == text

	}
}

