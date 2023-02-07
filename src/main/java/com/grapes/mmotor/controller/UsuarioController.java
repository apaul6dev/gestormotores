package com.grapes.mmotor.controller;

import com.grapes.mmotor.exception.ModeloNotFoundException;
import com.grapes.mmotor.model.Usuario;
import com.grapes.mmotor.service.IUsuarioService;
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
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {
    @Autowired
    private IUsuarioService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Usuario>> listar() {
        List<Usuario> dato = new ArrayList<>();
        dato = service.listar();
        return new ResponseEntity<List<Usuario>>(dato, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuario> listarId(@PathVariable("id") Integer id) {
        Usuario dato = new Usuario();
        dato = service.listarId(id);
        if (dato == null) {
            throw new ModeloNotFoundException("ID: " + id);
        }
        return new ResponseEntity<Usuario>(dato, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> registrar(@Validated @RequestBody Usuario data) {
        Usuario tmp = new Usuario();
        service.registrar(data);
        tmp = service.listarId(data.getIdUsuario());
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(tmp.getIdUsuario())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void eliminar(@PathVariable("id") Integer id) {
        Usuario exa = service.listarId(id);
        if (exa == null) {
            throw new ModeloNotFoundException("ID: " + id);
        } else {
            service.eliminar(id);
        }
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> actualizar(@Validated @RequestBody Usuario dato) {
        service.modificar(dato);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }
}
