package com.test.eventserviceimpl;

import com.test.eventserviceapi.EventService;
import com.test.eventservicedto.Event;
import com.test.eventservicedto.EventDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    @Override
    public EventDto createEvent(EventDto eventDto) {
        log.info("creating event:  " + eventDto);

        Event event = fromEventDTOtoEvent(eventDto);
        return fromEventToDTO(eventRepository.save(event));
    }

    @Transactional
    @Override
    public EventDto updateEvent(EventDto eventDto) {
        log.info("updating event " + eventDto);

        return getEvent(eventDto.getId())
                .setTitle(eventDto.getTitle())
                .setPlace(eventDto.getPlace())
                .setSpeaker(eventDto.getSpeaker())
                .setEventType(eventDto.getEventType())
                .setDateTime(eventDto.getDateTime());
    }

    @Override
    public EventDto getEvent(long eventId) {
        log.info("getting event by id " + eventId);

        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new EventNotFoundException("Event not found by id " + eventId));

        return fromEventToDTO(event);
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

    public EventDto fromEventToDTO(Event event) {
        return new EventDto(
                event.getId(),
                event.getTitle(),
                event.getPlace(),
                event.getSpeaker(),
                event.getEventType(),
                event.getDateTime());
    }

    public Event fromEventDTOtoEvent(EventDto eventDto) {
        return new Event(
                eventDto.getId(),
                eventDto.getTitle(),
                eventDto.getPlace(),
                eventDto.getSpeaker(),
                eventDto.getEventType(),
                eventDto.getDateTime());
    }
}
