package com.opi

import grails.transaction.Transactional

@Transactional
class EventService {

    Event createEvent(Date eventTime, String eventSource, Map<String, String> eventDetails) {

        Event event

        if ((eventTime && eventSource && eventDetails && eventDetails.size() > 0)) {

            event = new Event(eventTime: eventTime, eventSource: eventSource)

            eventDetails.each { k, v ->
                event.addToDetails(new EventDetail(name: k, value: v))
            }

            if (!event.save()) {
                log.error("Failed to create event. Errors: [$event.errors]")
            }
        } else {
            throw new IllegalArgumentException("Can't create an Event without all the required data!")
        }

        event
    }
}
