package com.example.gto.Friends;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/")
public class FriendsController {

    @Autowired
    private FriendsRepository friends;


    @GetMapping("/friends")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<Friends> getFriends() {
        return friends.findAll();
    }



    @GetMapping("friends/findAllFriends/{email}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public Optional<Friends> getFriendByEmail(@PathVariable String email) {
        return friends.findByEmail(email);
    }

    @GetMapping("friends/findAllFriends/{username}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public Optional<Friends> getFriendByUsername(@PathVariable String username) {
        return friends.findByUsername(username);
    }

    @PostMapping("friends/addFriends")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public String addFriends(@Valid @RequestBody Friends friend) {
        friends.save(friend);
        return "Added user with username : " + friend.getUsername();
    }

    @DeleteMapping("friends/delete/{email}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public String deleteFriend(@PathVariable String username) {
        friends.deleteById(username);
        return "friend with username : " + username + " deleted";
    }
}