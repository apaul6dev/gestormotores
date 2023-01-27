package com.grapes.mmotor.controller;

import com.grapes.mmotor.model.MantenimientoTipo;
import com.grapes.mmotor.service.IMantenimientoTipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/mantenimientostipo")
public class MantenimientoTipoController {

    @Autowired
    private IMantenimientoTipoService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<MantenimientoTipo>> listar() {
        List<MantenimientoTipo> datos = new ArrayList<>();
        datos = service.listar();
        return new ResponseEntity<List<MantenimientoTipo>>(datos, HttpStatus.OK);

    }

}
