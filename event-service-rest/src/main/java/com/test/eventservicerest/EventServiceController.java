package com.test.eventservicerest;

import com.test.eventserviceapi.EventService;
import com.test.eventservicedto.Event;
import com.test.eventservicedto.EventDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EventServiceController implements EventApi {

    private final EventService eventService;
    private final EventAssembler eventAssembler;

    @Override
    public EventModel createEvent(EventDto eventDto) {
        EventDto event = eventService.createEvent(eventDto);
        return eventAssembler.toModel(event);
    }

    @Override
    public EventModel updateEvent(EventDto eventDto) {
        EventDto event = eventService.updateEvent(eventDto);
        return eventAssembler.toModel(event);
    }

    @Override
    public EventModel getEventById(long id) {
        EventDto event = eventService.getEvent(id);
        return eventAssembler.toModel(event);
    }

    @Override
    public ResponseEntity<Void> deleteEvent(long id) {
        eventService.deleteEvent(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<Event>> getAllEvents() {
        List<Event> events = eventService.getAllEvents();
        return new ResponseEntity<>(events, HttpStatus.FOUND);
    }

    @Override
    public ResponseEntity<List<Event>> getEventsByTitle(String title) {
        List<Event> eventsByTitle = eventService.getAllEventsByTitle(title);
        return new ResponseEntity<>(eventsByTitle, HttpStatus.FOUND);
    }
}
