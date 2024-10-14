package com.example.mongo.oscar.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.mongo.oscar.Entity.Equipo;

public interface EquipoRepository extends MongoRepository<Equipo,String>{

}
