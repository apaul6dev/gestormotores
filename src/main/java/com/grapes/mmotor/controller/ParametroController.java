package com.grapes.mmotor.controller;

import com.grapes.mmotor.exception.ModeloNotFoundException;
import com.grapes.mmotor.model.Parametro;
import com.grapes.mmotor.service.IParametroService;
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
@RequestMapping("/api/v1/parametro")
public class ParametroController {

    @Autowired
    private IParametroService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Parametro>> listar() {
        List<Parametro> datos = new ArrayList<>();
        datos = service.listar();
        return new ResponseEntity<List<Parametro>>(datos, HttpStatus.OK);

    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Parametro> listarId(@PathVariable("id") Integer id) {
        Parametro dato = new Parametro();
        dato = service.listarId(id);
        if (dato == null) {
            throw new ModeloNotFoundException("ID: " + id);
        }
        return new ResponseEntity<Parametro>(dato, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> registrar(@Validated @RequestBody Parametro data) {
        Parametro tmp = new Parametro();
        service.registrar(data);
        tmp = service.listarId(data.getIdParametro());
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(tmp.getIdParametro())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void eliminar(@PathVariable("id") Integer id) {
        Parametro exa = service.listarId(id);
        if (exa == null) {
            throw new ModeloNotFoundException("ID: " + id);
        } else {
            service.eliminar(id);
        }
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> actualizar(@Validated @RequestBody Parametro data) {
        service.modificar(data);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }
}
