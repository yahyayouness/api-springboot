package com.socgen.agence.fgad.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.socgen.agence.fgad.entity.User;

public interface UserRepository extends MongoRepository<User, String> {

    public User findByFirstName(String firstName);
    public List<User> findByLastName(String lastName);

}
