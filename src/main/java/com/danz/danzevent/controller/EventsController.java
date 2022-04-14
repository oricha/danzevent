package com.danz.danzevent.controller;

import com.danz.danzevent.service.impl.EventService;
import com.danz.danzevent.domain.Event;
import com.google.common.base.Preconditions;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/v1")
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class EventsController {

    private final EventService service;

    @GetMapping(value = "/events")
    public List<Event> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/event/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id) {

        try {
            return  ResponseEntity.ok().body(service.findById(id));
        } catch (Exception njf) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Event create(@RequestBody final Event resource, final HttpServletResponse response) {
        Preconditions.checkNotNull(resource);
        return service.create(resource);
    }
}
