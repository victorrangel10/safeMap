package br.com.safemap.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.safemap.entity.Event;
import br.com.safemap.service.EventService;

@RestController
@RequestMapping("/events")
public class EventController {
    private EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping
    public Event create(@RequestBody Event event) {
        return eventService.saveEvent(event);
    }

    @PostMapping("/update/{id}")
    public Optional<Event> update(@RequestBody Event event,@PathVariable("id") Long id) {
        return eventService.updateEvent(id,event);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@RequestBody Event event,@PathVariable("id") Long id) {
        return eventService.deleteEvent(id);
    }
}
