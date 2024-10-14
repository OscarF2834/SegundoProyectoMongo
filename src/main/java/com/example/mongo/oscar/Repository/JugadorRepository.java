package com.example.mongo.oscar.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.mongo.oscar.Entity.Jugador;

public interface JugadorRepository extends MongoRepository<Jugador,String>{

}
