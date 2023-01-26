package com.grapes.mmotor.service.impl;

import com.grapes.mmotor.dao.IMenuDao;
import com.grapes.mmotor.model.Empresa;
import com.grapes.mmotor.model.Menu;
import com.grapes.mmotor.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MenuServiceImpl implements IMenuService {
    @Autowired
    private IMenuDao dao;

    @Override
    public void registrar(Menu menu) {
        dao.save(menu);
    }

    @Override
    public void modificar(Menu menu) {
        dao.save(menu);
    }

    @Override
    public void eliminar(int id) {
        dao.deleteById(id);
    }

    @Override
    public Menu listarId(int id) {
        Optional<Menu> opt = dao.findById(id);
        return opt.isPresent() ? opt.get() : new Menu();
    }

    @Override
    public List<Menu> listar() {
        return dao.findAll();
    }
}
