package com.example.mongo.oscar.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.mongo.oscar.Entity.Competicion;

public interface CompeticionRepository extends MongoRepository<Competicion,String>{

}