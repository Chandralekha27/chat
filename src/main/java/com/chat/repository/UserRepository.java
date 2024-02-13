package com.chat.repository;

import com.chat.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {

    Optional<User> findByNameAndEmail(String name, String email);

    Optional<User> findByName(String name);
}
