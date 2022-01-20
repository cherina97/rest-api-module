package com.test.eventserviceapi;


import com.test.eventservicedto.Event;

import java.util.List;

public interface EventService {

    Event createEvent(Event event);

    Event updateEvent(Event event);

    Event getEvent(long eventId);

    void deleteEvent(long eventId);

    List<Event> getAllEvents();

    List<Event> getAllEventsByTitle(String title);
}
