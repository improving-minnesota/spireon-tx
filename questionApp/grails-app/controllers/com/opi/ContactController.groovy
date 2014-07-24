package com.opi

import grails.converters.JSON

class ContactController {

    def index() {
        [siteEmail: 'jeff.sheets@objectpartners.com', sitePhone: '+1(555)555-5555']
    }

    def data() {
        render ([msg: 'hi', questionCount: Question.count()] as JSON)
    }
}
