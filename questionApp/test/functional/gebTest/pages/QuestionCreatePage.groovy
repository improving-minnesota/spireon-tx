package gebTest.pages

class QuestionCreatePage extends geb.Page {
	static url = "question/create"
	static at = { $("div#create-question").displayed }

	static content = {
		titleField(wait: true) { $("input#title") }
		descriptionField(wait: true) { $("textarea#text") }

		createButton(wait: true, to: QuestionShowPage) { $("input#create") }
	}

	QuestionShowPage createQuestion(String title, String description) {
		titleField.value(title)
		descriptionField.value(description)

		createButton.click()

		return browser.page
	}

	QuestionShowPage clickCreateButton() {
		createButton.click()

		return browser.page
	}

}