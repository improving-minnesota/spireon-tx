package com.opi

class VoteController {
    def votingService

    def voteUpQuestion() {
        saveVoteToQuestion(Vote.UP_VOTE)
    }

    def voteDownQuestion() {
        saveVoteToQuestion(Vote.DOWN_VOTE)
    }

    private saveVoteToQuestion(Integer vote) {

        User votingUser = User.get(1)
        Question question = Question.get(params.id)
        if (!question) {
            redirect(controller: 'question', action: 'index')
        } else {
            votingService.addVoteToQuestion(question, votingUser, vote)
            redirect(controller: 'question', action: 'show', id: question.id)
        }
    }

    def voteDownAnswer() {
        saveVoteToAnswer(Vote.DOWN_VOTE)
    }

    def voteUpAnswer() {
        saveVoteToAnswer(Vote.UP_VOTE)
    }

    private saveVoteToAnswer(Integer vote) {
        User votingUser = User.get(1)
        Answer answer = Answer.get(params.id)

        votingService.addVoteToAnswer(answer, votingUser, vote)

        redirect(controller:"question", action:'show', id: answer.question.id )
    }
}