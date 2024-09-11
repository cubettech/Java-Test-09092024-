package com.sample.test.service;

import com.sample.test.model.Event;

import java.util.stream.Stream;

public interface EventService {

    Stream<Event> getSortedEvents();
}
