package com.example.gto.User;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository extends MongoRepository<User, String> {

    Role findByRole(String role);

}
