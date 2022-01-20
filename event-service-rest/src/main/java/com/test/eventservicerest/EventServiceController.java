package com.test.eventservicerest;

import com.test.eventserviceapi.EventService;
import com.test.eventservicedto.Event;
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

    @PostMapping
    public ResponseEntity<Event> createEvent(@RequestBody Event event) {
        Event created = eventService.createEvent(event);

        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Event> updateEvent(@RequestBody Event event) {
        Event updatedEvent = eventService.updateEvent(event);

        return new ResponseEntity<>(updatedEvent, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable long id) {
        Event eventById = eventService.getEvent(id);

        return new ResponseEntity<>(eventById, HttpStatus.FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteEvent(@PathVariable long id) {
        eventService.deleteEvent(id);

        return ResponseEntity.ok(HttpStatus.OK);
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
