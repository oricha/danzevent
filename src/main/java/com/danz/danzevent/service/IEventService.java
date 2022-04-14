package com.danz.danzevent.service;

import com.danz.danzevent.domain.Event;
import com.danz.danzevent.repository.common.IOperations;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IEventService extends IOperations<Event> {


    Event findById(Long id);

    List<Event> findAll();
}
