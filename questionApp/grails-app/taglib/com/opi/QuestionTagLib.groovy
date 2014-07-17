package com.opi

class QuestionTagLib {
	static namespace = "question"

	def summary = { attrs, body ->
		Question question = attrs.question

		String title = question.title
		int textEndIndex = Math.min(question.text?.length(), 15)
		String textSummary = question.text?.substring(0, textEndIndex - 1) ?: ""

		out << "${title}: ${textSummary}..."
	}
}
