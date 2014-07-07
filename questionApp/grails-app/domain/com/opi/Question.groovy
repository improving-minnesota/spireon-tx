package com.opi

class Question {

	User user
	String title
	String text
	Date dateCreated
	Date lastUpdated

	static hasMany = [answers: Answer]

	static constraints = {
		title nullable: false, blank: false, maxSize: 200,
			validator: { val, obj ->
				if (val.contains('JVM')) {
					return "jvm.questions.not.allowed"
				}
			}
		text nullable: false, blank: false, maxSize: 10000
	}
}
