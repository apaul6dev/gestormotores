package com.grapes.mmotor.service.impl;

import com.grapes.mmotor.dao.IRolDao;
import com.grapes.mmotor.model.Rol;
import com.grapes.mmotor.service.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class RolServiceImpl implements IRolService {
    @Autowired
    private IRolDao dao;

    @Override
    public void registrar(Rol rol) {
        dao.save(rol);
    }

    @Override
    public void modificar(Rol rol) {
        dao.save(rol);
    }

    @Override
    public void eliminar(int id) {
        dao.deleteById(id);
    }

    @Override
    public Rol listarId(int id) {
        Optional<Rol> opt = dao.findById(id);
        return opt.isPresent() ? opt.get() : new Rol();
    }

    @Override
    public List<Rol> listar() {
        return dao.findAll();
    }
}
