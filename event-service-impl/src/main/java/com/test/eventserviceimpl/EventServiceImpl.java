package com.test.eventserviceimpl;

import com.test.eventserviceapi.EventService;
import com.test.eventservicedto.Event;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    @Override
    public Event createEvent(Event event) {
        log.info("creating event:  " + event);
        return eventRepository.save(event);
    }

    @Transactional
    @Override
    public Event updateEvent(Event event) {
        log.info("updating event " + event);

        return getEvent(event.getId())
                .setTitle(event.getTitle())
                .setPlace(event.getPlace())
                .setSpeaker(event.getSpeaker())
                .setEventType(event.getEventType())
                .setDateTime(event.getDateTime());
    }

    @Override
    public Event getEvent(long eventId) {
        log.info("getting event by id " + eventId);

        return eventRepository.findById(eventId)
                .orElseThrow(() -> new EventNotFoundException("Event not found by id " + eventId));
    }

    @Override
    public void deleteEvent(long eventId) {
        log.info("deleting event by id " + eventId);
        eventRepository.deleteById(eventId);
    }

    @Override
    public List<Event> getAllEvents() {
        log.info("getting all events");
        return eventRepository.findAll();
    }

    @Override
    public List<Event> getAllEventsByTitle(String title) {
        log.info("getting all events by title " + title);
        return eventRepository.findAllByTitle(title);
    }
}
