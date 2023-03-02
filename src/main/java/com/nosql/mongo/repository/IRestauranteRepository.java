package com.nosql.mongo.repository;

import com.nosql.mongo.model.Restaurante;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IRestauranteRepository  extends MongoRepository<Restaurante, Long>{
}
