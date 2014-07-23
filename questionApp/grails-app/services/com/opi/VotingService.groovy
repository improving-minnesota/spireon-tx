package com.opi

import grails.transaction.Transactional

@Transactional
class VotingService {

    def eventService

	Vote addVoteToQuestion(Question question, User votingUser, Integer vote) {
		if (!question) {
			throw new IllegalArgumentException()
		}
		def userVote = question.votes.find { it.user == votingUser }
		userVote = userVote ?: new Vote(user: votingUser)
		userVote.vote = vote
		userVote.save(failOnError: true)

		question.addToVotes(userVote)
		question.save(failOnError: true)

        def eventDetails = [:]
        eventDetails << ['eventType':'addVoteToQuestion']
        eventDetails << ['questionId': "${question.id}"]
        eventDetails << ['votingUserId': "${votingUser.id}"]
        eventDetails << ['vote': "$vote"]

        eventService.createEvent(new Date(), 'questionApp', eventDetails)

        return userVote
	}

	Vote addVoteToAnswer(Answer answer, User votingUser, Integer vote) {
		if (!answer) {
			throw new IllegalArgumentException()
		}
		def userVote = answer.votes.find { it.user == votingUser }
		userVote = userVote ?: new Vote(user: votingUser)
		userVote.vote = vote
		userVote.save(failOnError: true)

		answer.addToVotes(userVote)
		answer.save(failOnError: true)

        def eventDetails = [:]
        eventDetails << ['eventType':'addVoteToAnswer']
        eventDetails << ['answerId': "${answer.id}"]
        eventDetails << ['votingUserId': "${votingUser.id}"]
        eventDetails << ['vote': "$vote"]

        eventService.createEvent(new Date(), 'questionApp', eventDetails)
		return userVote
	}

}
