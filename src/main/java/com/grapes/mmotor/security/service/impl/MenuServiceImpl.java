package com.grapes.mmotor.security.service.impl;

import com.grapes.mmotor.security.dao.MenuDao;
import com.grapes.mmotor.security.dao.RoleDao;
import com.grapes.mmotor.security.model.Menu;
import com.grapes.mmotor.security.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MenuServiceImpl implements IMenuService {
    @Autowired
    private MenuDao dao;
    @Override
    public List<Menu> listarMenuByUsername(String username) {
        return dao.listMenuByUsername(username);
    }
}
