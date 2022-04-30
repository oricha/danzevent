package com.danz.danzevent.controller;

import com.danz.danzevent.domain.Event;
import com.danz.danzevent.service.impl.EventService;
import com.google.common.base.Preconditions;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.List;

@RestController

@Slf4j
@RequestMapping("/v1/events/")
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class EventsController {

    private final EventService service;

    @GetMapping(value = "/")
    public List<Event> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id) {
        try {
            return  ResponseEntity.ok().body(service.findById(id));
        } catch (Exception njf) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(value = "/")
    public ResponseEntity<?> create(@RequestBody Event event, HttpServletResponse response) {
        Preconditions.checkNotNull(event);
        Event created = service.create(event);
        URI uri = URI.create(String.format("/v1/events/%d", created.getId()));
        return ResponseEntity.created(uri).body(created);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        try {
            service.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception njf) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody final Event event) {
        Preconditions.checkNotNull(event);
        return ResponseEntity.ok().body(service.update(event));
    }
}
