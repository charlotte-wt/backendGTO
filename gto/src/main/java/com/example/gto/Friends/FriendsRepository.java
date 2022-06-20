package com.example.gto.Friends;

import com.example.gto.Role.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface FriendsRepository extends MongoRepository<Friends, String> {
    Optional<Role> findByName(String username);
    Optional<Role> findByEmail(String email);
}
