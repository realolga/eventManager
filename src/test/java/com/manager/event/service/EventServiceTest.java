package com.manager.event.service;

import com.manager.event.TestUtils;
import com.manager.event.converter.EventConverter;
import com.manager.event.dto.EventRequest;
import com.manager.event.dto.EventResponse;
import com.manager.event.dto.EventType;
import com.manager.event.repository.EventEntity;
import com.manager.event.repository.EventRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class EventServiceTest {

    private static final EventEntity EVENT_ENTITY_OFFLINE = TestUtils.getTestEventEntity(EventType.OFFLINE);
    private static final EventRequest EVENT_REQUEST_OFFLINE = TestUtils.getTestEventRequest(EventType.OFFLINE);
    private static final EventResponse EVENT_RESPONSE_OFFLINE = TestUtils.getTestEventResponse(EventType.OFFLINE);

    private EventRepository repository;
    private EventConverter converter;
    private EventService eventService;

    @BeforeEach
    void setUp() {
        repository = mock(EventRepository.class);
        converter = new EventConverter();
        eventService = new EventService(repository, converter);
        when(repository.getById(anyLong())).thenReturn(EVENT_ENTITY_OFFLINE);
    }

    @Test
    void testGettingByIdTest() {
        EventResponse eventResponse = eventService.getById(1l);
        assertEquals(EVENT_RESPONSE_OFFLINE, eventResponse);
    }

    @Test
    void testSavingTest() {
        eventService.save(EVENT_REQUEST_OFFLINE);
        verify(repository).save(EVENT_ENTITY_OFFLINE);
    }

}
