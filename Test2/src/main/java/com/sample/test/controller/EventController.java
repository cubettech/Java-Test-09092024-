package com.sample.test.controller;

import com.sample.test.facade.EventFacade;
import com.sample.test.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class EventController {

    @Autowired
    EventFacade eventFacade;

    @GetMapping("/events")
    public Flux<Event> getSortedEvents() {
        return Flux.fromStream(eventFacade.getSortedEvents());
    }
}
