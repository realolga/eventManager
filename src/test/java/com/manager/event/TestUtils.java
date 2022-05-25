package com.manager.event;

import com.manager.event.dto.EventRequest;
import com.manager.event.dto.EventResponse;
import com.manager.event.dto.EventType;
import com.manager.event.repository.EventEntity;

public class TestUtils {

    public static EventEntity getTestEventEntityOnline() {
        return EventEntity.builder()
                          .name("Test")
                          .type(EventType.ONLINE)
                          .description("Description")
                          .build();
    }

    public static EventEntity getTestEventEntityOffline() {
        return EventEntity.builder()
                          .name("Test")
                          .type(EventType.OFFLINE)
                          .description("Description")
                          .build();
    }

    public static EventRequest getTestEventRequestOffline() {
        return EventRequest.builder()
                           .name("Test")
                           .type(EventType.OFFLINE)
                           .description("Description")
                           .build();
    }

    public static EventRequest getTestEventRequestOnline() {
        return EventRequest.builder()
                           .name("Test")
                           .type(EventType.ONLINE)
                           .description("Description")
                           .build();
    }

    public static EventResponse getTestEventResponseOnline() {
        return EventResponse.builder()
                            .name("Test")
                            .type(EventType.ONLINE)
                            .description("Description")
                            .build();
    }
}
