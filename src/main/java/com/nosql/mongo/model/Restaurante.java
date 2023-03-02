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
@Document(collection = "Restaurante")
public class Restaurante implements Serializable{
    @Id
    private Long restaurante_id;
    private String nombre;
    private String telefono;
    private String correo;
    private String direccion;

    private List<Cliente> listaClientes;
    private Carta carta;

}
