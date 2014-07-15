package com.opi

class Vote {
	static final UP_VOTE = 1
	static final DOWN_VOTE = -1

	User user
	Integer vote

	static constraints = {
		vote validator: { it in [DOWN_VOTE, UP_VOTE] }
	}
}
