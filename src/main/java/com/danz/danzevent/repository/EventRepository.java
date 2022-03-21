package com.danz.danzevent.repository;

import com.danz.danzevent.domain.Event;
import com.danz.danzevent.repository.common.IOperations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends IOperations<Event> {

    Page<Event> findPaginated(Pageable pageable);
}
