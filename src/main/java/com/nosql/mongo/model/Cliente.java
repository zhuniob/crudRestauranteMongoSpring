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
@Document(collection = "Cliente")
public class Cliente implements Serializable{
    private String nombre;
    private String apellido;
    private String correo;
    private String cedula;
}