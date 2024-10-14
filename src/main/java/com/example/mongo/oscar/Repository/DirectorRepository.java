package com.example.mongo.oscar.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.mongo.oscar.Entity.Director;

public interface DirectorRepository extends MongoRepository<Director,String>{

}
