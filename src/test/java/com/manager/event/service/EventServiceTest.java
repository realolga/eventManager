package com.manager.event.service;

import com.manager.event.TestUtils;
import com.manager.event.converter.EventConverter;
import com.manager.event.dto.EventRequest;
import com.manager.event.dto.EventResponse;
import com.manager.event.repository.EventEntity;
import com.manager.event.repository.EventRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class EventServiceTest {

    public static final EventEntity EVENT_ENTITY_OFFLINE = TestUtils.getTestEventEntityOnline();
    public static final EventRequest EVENT_REQUEST_OFFLINE = TestUtils.getTestEventRequestOnline();
    public static final EventResponse EVENT_RESPONSE_ONLINE = TestUtils.getTestEventResponseOnline();

    EventRepository repository;
    EventConverter converter;
    EventService eventService;

    @BeforeEach
    void setUp() {
        repository = mock(EventRepository.class);
        converter = new EventConverter();
        eventService = new EventService(repository, converter);
        when(repository.getById(anyLong())).thenReturn(EVENT_ENTITY_OFFLINE);
    }

    @Test
    void testGettingById() {
        EventResponse eventResponse = eventService.getById(1l);
        assertEquals(EVENT_RESPONSE_ONLINE, eventResponse);
    }

    @Test
    void testSaving() {
        eventService.save(EVENT_REQUEST_OFFLINE);
        Mockito.verify(repository).save(EVENT_ENTITY_OFFLINE);
    }

}