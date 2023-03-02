package com.nosql.mongo.service;

import com.nosql.mongo.model.Restaurante;
import com.nosql.mongo.repository.IRestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class RestauranteServiceImplement extends GenericServiceImplement <Restaurante, Long> implements IRestauranteService{

    @Autowired
    IRestauranteRepository restauranteRepository;

    @Override
    public CrudRepository<Restaurante, Long> getDao(){
        return restauranteRepository;
    }

}
