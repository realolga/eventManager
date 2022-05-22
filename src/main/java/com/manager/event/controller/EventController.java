package com.manager.event.controller;

import com.manager.event.converter.EventConverter;
import com.manager.event.dto.EventRequest;
import com.manager.event.dto.EventResponse;
import com.manager.event.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/event")
@RequiredArgsConstructor
public class EventController {

    private final EventService service;
    private final EventConverter converter;

    @GetMapping(value = "/{id}")
    public EventResponse getEvent(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public EventResponse save(@RequestBody EventRequest request) {
        return service.save(request);
    }
}
