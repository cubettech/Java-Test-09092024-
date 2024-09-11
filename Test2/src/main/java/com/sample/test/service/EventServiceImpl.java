package com.sample.test.service;

import com.sample.test.model.Event;
import com.sample.test.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.stream.Stream;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    EventRepository eventRepository;

    @Override
    public Stream<Event> getSortedEvents() {
        return eventRepository.findAllEvents()
                .sorted(Comparator.comparing(Event::getSeverity)
                .reversed()
                .thenComparing(Event::getTimestamp).reversed());
    }
}
