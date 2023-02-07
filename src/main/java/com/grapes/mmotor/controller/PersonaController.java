package com.grapes.mmotor.controller;

import com.grapes.mmotor.exception.ModeloNotFoundException;
import com.grapes.mmotor.model.Persona;
import com.grapes.mmotor.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private IPersonaService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Persona>> listar() {
        List<Persona> datos = new ArrayList<>();
        datos = service.listar();
        return new ResponseEntity<List<Persona>>(datos, HttpStatus.OK);

    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Persona> listarId(@PathVariable("id") Integer id) {
        Persona dato = new Persona();
        dato = service.listarId(id);
        if (dato == null) {
            throw new ModeloNotFoundException("ID: " + id);
        }
        return new ResponseEntity<Persona>(dato, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> registrar(@Validated @RequestBody Persona data) {
        Persona tmp = new Persona();
        service.registrar(data);
        tmp = service.listarId(data.getIdPersona());
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(tmp.getIdPersona()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void eliminar(@PathVariable("id") Integer id) {
        Persona exa = service.listarId(id);
        if (exa == null) {
            throw new ModeloNotFoundException("ID: " + id);
        } else {
            service.eliminar(id);
        }
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> actualizar(@Validated @RequestBody Persona data) {
        service.modificar(data);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }
}