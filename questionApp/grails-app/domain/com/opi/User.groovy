package com.opi

class User {

	transient springSecurityService

	String username

	String firstName = 'Unknown'
	String lastName = 'Unknown'
	String email

	String password
	boolean enabled = true
	boolean accountExpired = false
	boolean accountLocked = false
	boolean passwordExpired = false

	Date dateCreated = new Date()
	Date lastUpdated = new Date()

	static transients = ['springSecurityService']

	static constraints = {
		username nullable: false, blank: false, unique: true, maxSize: 30
		password blank: false
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


	static mapping = {
		password column: '`password`'
	}

	Set<Role> getAuthorities() {
		UserRole.findAllByUser(this).collect { it.role }
	}

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	String toString() {
		return "$firstName $lastName"
	}

	protected void encodePassword() {
		password = springSecurityService?.passwordEncoder ? springSecurityService.encodePassword(password) : password
	}
}
