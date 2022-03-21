package com.danz.danzevent.controller;

import com.danz.danzevent.configuration.service.IEventService;
import com.danz.danzevent.domain.Event;
import com.google.common.base.Preconditions;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@XSlf4j
@RequestMapping("/v1")
public class EventsController {

    @Autowired
    private IEventService service;

    @GetMapping(value = "/events")
    public List<Event> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/event/{id}")
    public Event findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Event create(@RequestBody final Event resource, final HttpServletResponse response) {
        Preconditions.checkNotNull(resource);
        final Event event = service.create(resource);

        return event;
    }
}
