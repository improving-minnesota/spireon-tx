package com.opi

import com.opi.User
import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(User)
class UserSpec extends Specification {

	def "test User validation"() {
		given:
		mockForConstraintsTests(User)

		when:
		User u = new User(username: username, firstName: firstName, lastName: lastName, email: email)
		u.validate()

		then:
		u.hasErrors() == !valid

		where:
		username	| firstName		| lastName		| email					| valid
		"bobmarley"	| "Bob"			| "Marley"		| "bobmarley@opi.com"	| true
	}

//	// Tests the custom validator.
	@Unroll
	void "User  #username, #firstName, #lastName passes custom validation #valid"() {
		given:
		mockForConstraintsTests(User)

		when:
		User u = new User(username: username, firstName: firstName, lastName: lastName, email: email)
		u.validate()

		then:
		u.hasErrors() == !valid

		where:
		username	| firstName		| lastName		| email					| valid
		"theBiebs"	| "Justin"		| "Bieber"		| "justin@example.com"	| false
		"theBiebs"	| "JUsTin"		| "Bieber"		| "justin@example.com"	| false
		"theBiebs"	| "JUsTin"		| "BIeBeR"		| "justin@example.com"	| false
		"theBiebs"	| "Ryan"		| "Bieber"		| "justin@example.com"	| true

	}

}
