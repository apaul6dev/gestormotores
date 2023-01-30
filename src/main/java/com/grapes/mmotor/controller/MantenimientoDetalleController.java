package com.grapes.mmotor.controller;

import com.grapes.mmotor.exception.ModeloNotFoundException;
import com.grapes.mmotor.model.MantenimientoDetalle;
import com.grapes.mmotor.service.IMantenimientoDetalleService;
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
@RequestMapping("/mantenimientosdetalle")
public class MantenimientoDetalleController {

    @Autowired
    private IMantenimientoDetalleService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<MantenimientoDetalle>> listar() {
        List<MantenimientoDetalle> datos = new ArrayList<>();
        datos = service.listar();
        return new ResponseEntity<List<MantenimientoDetalle>>(datos, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MantenimientoDetalle> listarId(@PathVariable("id") Long id) {
        MantenimientoDetalle dato = new MantenimientoDetalle();
        dato = service.listarId(id);
        if (dato == null) {
            throw new ModeloNotFoundException("ID: " + id);
        }
        return new ResponseEntity<MantenimientoDetalle>(dato, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> registrar(@Validated @RequestBody MantenimientoDetalle data) {
        MantenimientoDetalle tmp = new MantenimientoDetalle();
        service.registrar(data);
        tmp = service.listarId(data.getIdMantenimientoDetalle());
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(tmp.getIdMantenimientoDetalle())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void eliminar(@PathVariable("id") Long id) {
        MantenimientoDetalle exa = service.listarId(id);
        if (exa == null) {
            throw new ModeloNotFoundException("ID: " + id);
        } else {
            service.eliminar(id);
        }
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> actualizar(@Validated @RequestBody MantenimientoDetalle data) {
        service.modificar(data);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }
}
