package com.opi

class Answer {
	String text
	Date dateCreated
	Date lastUpdated
	User author
	boolean accepted

	static belongsTo = [question: Question]

	static constraints = {
		text nullable: false, blank: false, maxSize: 10000
	}
}
