package com.nosql.mongo.controller;

import java.util.List;

import com.nosql.mongo.model.Restaurante;
import com.nosql.mongo.service.IRestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/restaurante")
public class RestauranteController {

    @Autowired
    IRestauranteService restauranteService;

    @GetMapping("/listar")
    public ResponseEntity<List<Restaurante>> listarRestaurantes() {
        return new ResponseEntity<>(restauranteService.findByAll(),
                HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Restaurante> crearRestaurante(
            @RequestBody Restaurante restaurante) {
        return new ResponseEntity<>(restauranteService.save(restaurante),
                HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Restaurante> actualizarRestaurante(@PathVariable Long id, @RequestBody Restaurante restaurante) {
        Restaurante restauranteFixed = restauranteService.findById(id);
        if (restauranteFixed == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                restauranteFixed.setNombre(restaurante.getNombre());
                restauranteFixed.setTelefono(restaurante.getTelefono());
                restauranteFixed.setCorreo(restaurante.getCorreo());
                restauranteFixed.setDireccion(restaurante.getDireccion());
                return new ResponseEntity<>(restauranteService.save(restaurante), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Restaurante> eliminarRestaurante(@PathVariable Long id) {
        restauranteService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
