package com.test.eventservicerest;

import com.test.eventservicedto.Event;
import com.test.eventservicedto.EventDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Event management API")
@RequestMapping("/api/v1/events")
public interface EventApi {

    @ApiOperation("Create a new event")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    EventModel createEvent(@RequestBody EventDto eventDto);

    @ApiOperation("Update event")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping
    EventModel updateEvent(@RequestBody EventDto eventDto);

    @ApiOperation("Get event by id")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    EventModel getEventById(@PathVariable long id);

    @ApiOperation("Delete event by id")
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteEvent(@PathVariable long id);

    @ApiOperation("Get all events")
    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping("/all")
    ResponseEntity<List<Event>> getAllEvents();

    @ApiOperation("Get all events by title")
    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping("/get/{title}")
    ResponseEntity<List<Event>> getEventsByTitle(@PathVariable String title);

}
