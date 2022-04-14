package com.danz.danzevent.service.impl;

import com.danz.danzevent.service.AbstractService;
import com.danz.danzevent.service.IEventService;
import com.danz.danzevent.domain.Event;
import com.danz.danzevent.repository.EventRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@Slf4j
public class EventService extends AbstractService<Event> implements IEventService {

    @Autowired
    final  EventRepository repository;

    public EventService(EventRepository repository) {
        this.repository = repository;
    }

    @Override
    public Event findById(Long id) {
        return repository.findById(id);
    }

    @Override
    protected PagingAndSortingRepository<Event, Long> getDao() {
        return null;
    }
}
