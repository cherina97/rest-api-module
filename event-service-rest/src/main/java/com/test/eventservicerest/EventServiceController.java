package com.test.eventservicerest;

import com.test.eventserviceapi.EventService;
import com.test.eventservicedto.Event;
import com.test.eventservicedto.EventDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventServiceController {

    private final EventService eventService;
    private final EventAssembler eventAssembler;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public EventModel createEvent(@RequestBody EventDto eventDto) {
        EventDto event = eventService.createEvent(eventDto);
        return eventAssembler.toModel(event);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping
    public EventModel updateEvent(@RequestBody EventDto eventDto) {
        EventDto event = eventService.updateEvent(eventDto);
        return eventAssembler.toModel(event);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public EventModel getEventById(@PathVariable long id) {
        EventDto event = eventService.getEvent(id);
        return eventAssembler.toModel(event);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable long id) {
        eventService.deleteEvent(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<Event>> getAllEvents() {
        List<Event> events = eventService.getAllEvents();
        return new ResponseEntity<>(events, HttpStatus.FOUND);
    }

    @GetMapping("/get/{title}")
    public ResponseEntity<List<Event>> getEventsByTitle(@PathVariable String title) {
        List<Event> eventsByTitle = eventService.getAllEventsByTitle(title);
        return new ResponseEntity<>(eventsByTitle, HttpStatus.FOUND);
    }
}
