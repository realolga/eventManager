package com.manager.event.service;


import com.manager.event.TestUtils;
import com.manager.event.converter.EventConverter;
import com.manager.event.dto.EventRequest;
import com.manager.event.dto.EventResponse;
import com.manager.event.dto.EventType;
import com.manager.event.repository.EventRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
public class EvantServiceIntegrationTest {

    private static final EventRequest EVENT_REQUEST_ONLINE = TestUtils.getTestEventRequest(EventType.ONLINE);
    private static final EventResponse EVENT_RESPONSE_ONLINE = TestUtils.getTestEventResponse(EventType.ONLINE);

    @Autowired
    private EventRepository repository;
    @Autowired
    private EventConverter converter;
    @Autowired
    private EventService service;


    @Test
    void getByIdTest() {
        service.save(EVENT_REQUEST_ONLINE);

        EventResponse eventResponse = service.getById(1l);
        assertEquals(EVENT_RESPONSE_ONLINE, eventResponse);
    }
}

