package com.sample.test.facade;

import com.sample.test.model.Event;

import java.util.stream.Stream;

public interface EventFacade {

    Stream<Event> getSortedEvents();
}
