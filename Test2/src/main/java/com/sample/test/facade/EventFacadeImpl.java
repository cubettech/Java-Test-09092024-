package com.sample.test.facade;

import com.sample.test.model.Event;
import com.sample.test.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class EventFacadeImpl implements EventFacade {

    @Autowired
    EventService eventService;

    @Override
    public Stream<Event> getSortedEvents() {
        return eventService.getSortedEvents();
    }
}
