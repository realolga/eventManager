package com.manager.event.service;


import com.manager.event.TestUtils;
import com.manager.event.converter.EventConverter;
import com.manager.event.dto.EventRequest;
import com.manager.event.dto.EventResponse;
import com.manager.event.repository.EventEntity;
import com.manager.event.repository.EventRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest
public class EvantServiceIntegrationWithMockTest {

    public static final EventRequest EVENT_REQUEST_ONLINE = TestUtils.getTestEventRequestOnline();
    public static final EventEntity EVENT_ENTITY_ONLINE = TestUtils.getTestEventEntityOnline();
    public static final EventResponse EVENT_RESPONSE_ONLINE = TestUtils.getTestEventResponseOnline();

    @MockBean
    private EventRepository repository;
    @Autowired
    private EventConverter converter;
    @Autowired
    private EventService service;

    @BeforeEach
    void setUp() {
        when(repository.getById(anyLong())).thenReturn(EVENT_ENTITY_ONLINE);
    }

    @Test
    void getById() {
        EventResponse actualEventEntity = service.getById(1l);

        assertEquals(EVENT_RESPONSE_ONLINE, actualEventEntity);
    }

    @Test
    void saving() {
        service.save(EVENT_REQUEST_ONLINE);

        Mockito.verify(repository).save(EVENT_ENTITY_ONLINE);
    }
}
