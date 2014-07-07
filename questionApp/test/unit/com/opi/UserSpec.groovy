package com.opi

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(User)
class UserSpec extends Specification {

	def setup() {
	}

	def cleanup() {
	}

	def "test person validation"() {
		User person = new User(userName: 'bobmarley', firstName: 'Bob',
			lastName: 'Marley', email: 'bob@example.com')

		assert person.validate()
	}

    // Tests the custom validator.
    void "test custom validator for no people with the name Justin Bieber"() {
        User person = new User(userName:'justin', firstName: 'Justin',
            lastName: 'Bieber', email:'justin@example.com')

        assert !person.validate()

        person.firstName = 'jUsTiN'         // case insensitive
        assert !person.validate()

        person.lastName = 'TV'
        assert person.validate()
    }
}
