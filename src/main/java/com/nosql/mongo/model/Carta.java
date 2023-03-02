package com.nosql.mongo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Data
@Getter
@Setter
@Document(collection = "Carta")
public class Carta implements Serializable{
    private String nombre;
    private String categoria;
    private int cantidad;

    private List<Plato> listaPlatos;

}