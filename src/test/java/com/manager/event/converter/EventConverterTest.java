package com.manager.event.converter;

import com.manager.event.TestUtils;
import com.manager.event.dto.EventRequest;
import com.manager.event.dto.EventResponse;
import com.manager.event.dto.EventType;
import com.manager.event.repository.EventEntity;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class EventConverterTest {

    private static final EventEntity EVENT_ENTITY_ONLINE = TestUtils.getTestEventEntity(EventType.ONLINE);
    private static final EventEntity EVENT_ENTITY_OFFLINE = TestUtils.getTestEventEntity(EventType.OFFLINE);
    private static final EventResponse EVENT_RESPONSE_ONLINE = TestUtils.getTestEventResponse(EventType.ONLINE);
    private static final EventRequest EVENT_REQUEST_OFFLINE = TestUtils.getTestEventRequest(EventType.OFFLINE);

    private static EventConverter eventConverter;

    @BeforeAll
    static void setUp() {
        eventConverter = new EventConverter();
    }

    @Test
    void whenConwertEntityToResponseTest() {
        EventResponse actualResponse = eventConverter.entityToResponse(EVENT_ENTITY_ONLINE);
        assertEquals(EVENT_RESPONSE_ONLINE, actualResponse);
    }

    @Test
    void whenConwertRequestToEntityTest() {
        EventEntity actualEntity = eventConverter.requestToEntity(EVENT_REQUEST_OFFLINE);
        assertEquals(EVENT_ENTITY_OFFLINE, actualEntity);
    }
}

