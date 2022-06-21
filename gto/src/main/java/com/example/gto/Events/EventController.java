package com.example.gto.Events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/events")
public class EventController {

    @Autowired
    private EventRepository eventRepository;


    @GetMapping("")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<Event> getFriends() {
        return eventRepository.findAll();
    }



    @GetMapping("findEventByTitle/{title}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public Optional<Event> getEventByTitle(@PathVariable String title) {
        return eventRepository.findByTitle(title);
    }

    @GetMapping("findEventByUsername/{username}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public Optional<Event> getFriendByUsername(@PathVariable String username) {
        return eventRepository.findByUsername(username);
    }

    @PostMapping("addEvent")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public String addEvent(@Valid @RequestBody Event event) {
        eventRepository.save(event);
        return "Event " + event.getDescription() + " has been added by " + event.getUsername();
    }

    @DeleteMapping("delete/{title}")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public String deleteEvent(@PathVariable Event event) {
        eventRepository.delete(event);
        return "Event " + event.getTitle() + " deleted by: " +  event.getUsername();
    }
}
