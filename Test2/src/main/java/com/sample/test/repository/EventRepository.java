package com.sample.test.repository;

import com.sample.test.model.Event;

import java.util.stream.Stream;

public interface EventRepository {
    Stream<Event> findAllEvents();
}
