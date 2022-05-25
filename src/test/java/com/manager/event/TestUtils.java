package com.manager.event;

import com.manager.event.dto.EventRequest;
import com.manager.event.dto.EventResponse;
import com.manager.event.dto.EventType;
import com.manager.event.repository.EventEntity;

public class TestUtils {

    public static EventEntity getTestEventEntity(EventType eventType) {
        return EventEntity.builder()
                          .name("Test")
                          .type(eventType)
                          .description("Description")
                          .build();
    }

    public static EventRequest getTestEventRequest(EventType eventType) {
        return EventRequest.builder()
                           .name("Test")
                           .type(eventType)
                           .description("Description")
                           .build();
    }

    public static EventResponse getTestEventResponse(EventType eventType) {
        return EventResponse.builder()
                            .name("Test")
                            .type(eventType)
                            .description("Description")
                            .build();
    }
}

