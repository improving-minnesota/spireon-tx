package geb.pages

class QuestionShowPage extends geb.Page {
	static at = { $("div#show-question").displayed }

	static content = {
		titleValueElement(wait: true) { $("span#titleValue") }
		textValueElement(wait: true) { $("span#textValue") }
	}

	String getTitleText() {
		titleValueElement.text()
	}

	String getTextText() {
		textValueElement.text()
	}
}
