package com.example.gto.Events;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface EventRepository extends MongoRepository<Event, String> {
    Optional<Event> findByUsername(String username);
    Optional<Event> findByTitle(String title);
    List<Event> findByTitleContaining(String title);

    Optional<Event> findById(String id);

}
