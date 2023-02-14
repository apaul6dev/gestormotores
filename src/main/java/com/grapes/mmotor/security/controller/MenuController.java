package com.grapes.mmotor.security.controller;

import com.grapes.mmotor.exception.ModeloNotFoundException;
import com.grapes.mmotor.security.model.Menu;
import com.grapes.mmotor.security.service.IMenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/menus")
public class MenuController {
    @Autowired
    private IMenuService service;

    @GetMapping(value = "/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Menu>> menuByUsername(@PathVariable("username") String username) {
        List<Menu> dato = new ArrayList<>();
        dato = service.listarMenuByUsername(username);
        if (dato == null) {
            throw new ModeloNotFoundException("USERNAME: " + username);
        }
        return new ResponseEntity<List<Menu>>(dato, HttpStatus.OK);
    }

}
