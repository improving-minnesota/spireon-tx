package com.opi

class Answer {
	String text
	Date dateCreated
	Date lastUpdated
	User author
	boolean accepted=false

	static belongsTo = [question: Question]
	static hasMany = [votes: Vote]

	static constraints = {
		text nullable: false, blank: false, maxSize: 10000
	}

	Integer getVoteCount() {
     votes?.vote?.sum()?:0
 }

}
