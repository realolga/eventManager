package com.manager.event.converter;

import com.manager.event.dto.EventRequest;
import com.manager.event.dto.EventResponse;
import com.manager.event.repository.EventEntity;
import org.springframework.stereotype.Component;

@Component
public class EventConverter {

    public EventEntity requestToEntity(EventRequest eventRequest) {
        EventEntity eventEntity = new EventEntity();
        eventEntity.setName(eventRequest.getName());
        eventEntity.setDescription(eventRequest.getDescription());
        eventEntity.setType(eventRequest.getType());

        return eventEntity;
    }

    public EventResponse entityToResponse(EventEntity eventEntity) {
        EventResponse eventResponse = new EventResponse();
        eventResponse.setName(eventEntity.getName());
        eventResponse.setDescription(eventEntity.getDescription());
        eventResponse.setType(eventEntity.getType());

        return eventResponse;
    }
}
