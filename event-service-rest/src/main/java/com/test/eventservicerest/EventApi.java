package com.test.eventservicerest;

import com.test.eventservicedto.Event;
import com.test.eventservicedto.EventDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Event management API")
@RequestMapping("/api/v1/events")
public interface EventApi {

    @ApiOperation("Create a new event")
    @ApiResponses({
            @ApiResponse(code = 201, message = "User created"),
            @ApiResponse(code = 404, message = "User not found"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    EventModel createEvent(@RequestBody EventDto eventDto);

    @ApiOperation("Update event")
    @ApiResponses({
            @ApiResponse(code = 200, message = "User updated"),
            @ApiResponse(code = 404, message = "User not found"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    @ResponseStatus(HttpStatus.OK)
    @PutMapping
    EventModel updateEvent(@RequestBody EventDto eventDto);

    @ApiOperation("Get event by id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "User was found by id"),
            @ApiResponse(code = 404, message = "User not found"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    EventModel getEventById(@PathVariable long id);

    @ApiOperation("Delete event by id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "User deleted"),
            @ApiResponse(code = 404, message = "User not found"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteEvent(@PathVariable long id);

    @ApiOperation("Get all events")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Getting all users successfully"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/all")
    ResponseEntity<List<Event>> getAllEvents();

    @ApiOperation("Get all events by title")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Getting all users by title successfully"),
            @ApiResponse(code = 404, message = "Users not found"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/get/{title}")
    ResponseEntity<List<Event>> getEventsByTitle(@PathVariable String title);

}
