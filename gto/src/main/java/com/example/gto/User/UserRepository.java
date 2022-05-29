package com.example.gto.User;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
//    public User findByEmail(String email);
//    public List<User> findByUserName(String userName);

    @Query("{username:'?0'}")
    User findUserByUsername(String username);


}

