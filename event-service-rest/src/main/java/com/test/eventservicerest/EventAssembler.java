package com.test.eventservicerest;

import com.test.eventservicedto.EventDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

@Component
public class EventAssembler extends RepresentationModelAssemblerSupport<EventDto, EventModel> {

    public EventAssembler() {
        super(EventServiceController.class, EventModel.class);
    }

    @Override
    public EventModel toModel(EventDto entity) {
        EventModel eventModel = new EventModel(entity);

        Link update = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder
                        .methodOn(EventServiceController.class)
                        .updateEvent(entity))
                .withRel("getEventsByTitle");

        Link eventById = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder
                        .methodOn(EventServiceController.class)
                        .getEventById(entity.getId()))
                .withRel("getEventById");

        Link createEvent = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder
                        .methodOn(EventServiceController.class)
                        .createEvent(entity))
                .withRel("createEvent");

        Link deleteEvent = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder
                        .methodOn(EventServiceController.class)
                        .deleteEvent(entity.getId()))
                .withRel("deleteEvent");

        eventModel.add(createEvent, eventById, update, deleteEvent);
        return eventModel;
    }
}
