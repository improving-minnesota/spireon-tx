package com.opi

class EventDetail {
    String name
    String value

    static constraints = {
        name size: 4..200, blank: false
        value size: 1..200, blank: false
    }
}
