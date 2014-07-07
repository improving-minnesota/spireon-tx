package com.opi

class Person {
	String username
	String firstName
	String lastName
	String email

	static constraints = {
		username nullable: false, blank: false, maxSize: 30
		firstName nullable: false, blank: false, maxSize: 30
		lastName nullable: false, blank: false, maxSize: 30
		email nullable: false, blank: false, email: true
	}
}
