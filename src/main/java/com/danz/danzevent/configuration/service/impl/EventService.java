package com.danz.danzevent.configuration.service.impl;

import com.danz.danzevent.configuration.service.AbstractService;
import com.danz.danzevent.configuration.service.IEventService;
import com.danz.danzevent.domain.Event;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class EventService extends AbstractService<Event> implements IEventService {


    @Override
    public Event findById(Long id) {
        return null;
    }

    @Override
    protected PagingAndSortingRepository<Event, Long> getDao() {
        return null;
    }
}
