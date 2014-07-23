package com.opi

class Event {
    Date eventTime
    String eventSource

    static hasMany = [details: EventDetail]
    static constraints = {
        eventSource size: 4..100, blank: false
        details size: 1..50
    }
}
