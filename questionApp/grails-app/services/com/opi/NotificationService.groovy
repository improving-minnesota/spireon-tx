package com.opi

import grails.transaction.Transactional

@Transactional
class NotificationService {

    boolean send(String name, String phone, String email, String note) {
        log.debug "send() called with $name, $phone, $email, $note"

        //just return true for now
        //change to false to 'simulate' a failed send
        false
    }
}
