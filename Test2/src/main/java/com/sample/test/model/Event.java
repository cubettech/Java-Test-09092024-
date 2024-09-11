package com.sample.test.model;

import java.time.LocalDateTime;

public class Event {
    private LocalDateTime timestamp;
    private String eventText;
    private Severity severity;

    public Event(LocalDateTime timestamp, String eventText, Severity severity) {
        this.timestamp = timestamp;
        this.eventText = eventText;
        this.severity = severity;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getEventText() {
        return eventText;
    }

    public Severity getSeverity() {
        return severity;
    }
}