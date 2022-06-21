package com.example.gto.Friends;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface FriendsRepository extends MongoRepository<Friends, String> {
    Optional<Friends> findByUsername(String username);
    Optional<Friends> findByEmail(String email);

    List<Friends> findAll();
}
