package com.grapes.mmotor.controller;

import com.grapes.mmotor.exception.ModeloNotFoundException;
import com.grapes.mmotor.model.Menu;
import com.grapes.mmotor.service.IMenuService;
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
@RequestMapping("/empresas")
public class MenuController {
    @Autowired
    private IMenuService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Menu>> listar() {
        List<Menu> dato = new ArrayList<>();
        dato = service.listar();
        return new ResponseEntity<List<Menu>>(dato, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Menu> listarId(@PathVariable("id") Integer id) {
        Menu dato = new Menu();
        dato = service.listarId(id);
        if (dato == null) {
            throw new ModeloNotFoundException("ID: " + id);
        }
        return new ResponseEntity<Menu>(dato, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> registrar(@Validated @RequestBody Menu data) {
        Menu tmp = new Menu();
        service.registrar(data);
        tmp = service.listarId(data.getIdMenu());
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(tmp.getIdMenu())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void eliminar(@PathVariable("id") Integer id) {
        Menu exa = service.listarId(id);
        if (exa == null) {
            throw new ModeloNotFoundException("ID: " + id);
        } else {
            service.eliminar(id);
        }
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> actualizar(@Validated @RequestBody Menu dato) {
        service.modificar(dato);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }
}
