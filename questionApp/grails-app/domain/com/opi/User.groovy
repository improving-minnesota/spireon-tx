package com.opi

//	Uncomment for composite primary key.
//import org.apache.commons.lang.builder.HashCodeBuilder
//class User implements Serializable {
import grails.rest.*

@Resource(uri='/users')
class User {
	String username
	String firstName
	String lastName
	String email
	Date dateCreated
	Date lastUpdated

	static constraints = {
		username nullable: false, blank: false, maxSize: 30, unique: true
		firstName nullable: false, blank: false, maxSize: 30,
			validator: { val, obj ->
				if ((val?.toLowerCase() == 'justin')
					&& (obj.lastName?.toLowerCase() == 'bieber')) {
					return 'no.biebers.allowed'
				}
			}
		lastName nullable: false, blank: false, maxSize: 30
		email nullable: false, blank: false, email: true
	}

	String toString() {
		return "$firstName $lastName"
	}

	static mapping = {
		username index: 'username_idx'
//		Uncomment for composite primary key.
//		id composite: ['email', 'username']
	}
//
//	boolean equals(other) {
//		if (!(other instanceof User)) {
//			return false
//		}
//
//		other.email == email && other.username == username
//	}
//
//	int hashCode() {
//		def builder = new HashCodeBuilder()
//		builder.append email
//		builder.append username
//		builder.toHashCode()
//	}

}
