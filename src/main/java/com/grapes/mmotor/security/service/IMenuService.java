package com.grapes.mmotor.security.service;

import com.grapes.mmotor.security.model.Menu;

import java.util.List;

public interface IMenuService {
    List<Menu> listarMenuByUsername(String username);

}
