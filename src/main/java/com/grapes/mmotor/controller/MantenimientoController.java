package com.grapes.mmotor.controller;

import com.grapes.mmotor.exception.ModeloNotFoundException;
import com.grapes.mmotor.model.Generador;
import com.grapes.mmotor.model.Mantenimiento;
import com.grapes.mmotor.service.IGeneradorService;
import com.grapes.mmotor.service.IMantenimientoService;
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
@RequestMapping("/api/v1/mantenimiento")
public class MantenimientoController {

    @Autowired
    private IMantenimientoService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Mantenimiento>> listar() {
        List<Mantenimiento> datos = new ArrayList<>();
        datos = service.listar();
        return new ResponseEntity<List<Mantenimiento>>(datos, HttpStatus.OK);

    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Mantenimiento> listarId(@PathVariable("id") Integer id) {
        Mantenimiento dato = new Mantenimiento();
        dato = service.listarId(id);
        if (dato == null) {
            throw new ModeloNotFoundException("ID: " + id);
        }
        return new ResponseEntity<Mantenimiento>(dato, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> registrar(@Validated @RequestBody Mantenimiento data) {
        Mantenimiento tmp = new Mantenimiento();
        service.registrar(data);
        tmp = service.listarId(data.getIdMantenimiento());
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(tmp.getIdMantenimiento())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void eliminar(@PathVariable("id") Integer id) {
        Mantenimiento exa = service.listarId(id);
        if (exa == null) {
            throw new ModeloNotFoundException("ID: " + id);
        } else {
            service.eliminar(id);
        }
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> actualizar(@Validated @RequestBody Mantenimiento data) {
        service.modificar(data);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

}
