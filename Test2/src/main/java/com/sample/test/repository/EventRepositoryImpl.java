package com.sample.test.repository;

import com.sample.test.model.Event;
import com.sample.test.model.Severity;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.stream.Stream;

@Repository
public class EventRepositoryImpl implements EventRepository {

    @Override
    public Stream<Event> findAllEvents() {
        return Stream.of(
                new Event(LocalDateTime.now().minusMinutes(1), "Event 1", Severity.CRITICAL),
                new Event(LocalDateTime.now().minusMinutes(5), "Event 2", Severity.MAJOR),
                new Event(LocalDateTime.now().minusMinutes(3), "Event 3", Severity.CRITICAL),
                new Event(LocalDateTime.now().minusMinutes(10), "Event 4", Severity.OK)
        );
    }
}
