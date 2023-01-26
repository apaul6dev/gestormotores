package com.grapes.mmotor.service.impl;

import com.grapes.mmotor.dao.IRolCategoriaDao;
import com.grapes.mmotor.model.RolCategoria;
import com.grapes.mmotor.service.IRolCategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class RolCategoriaServiceImpl implements IRolCategoriaService {
    @Autowired
    private IRolCategoriaDao dao;

    @Override
    public void registrar(RolCategoria rolCategoria) {
        dao.save(rolCategoria);
    }

    @Override
    public void modificar(RolCategoria rolCategoria) {
        dao.save(rolCategoria);
    }

    @Override
    public void eliminar(int id) {
        dao.deleteById(id);
    }

    @Override
    public RolCategoria listarId(int id) {
        Optional<RolCategoria> opt = dao.findById(id);
        return opt.isPresent() ? opt.get() : new RolCategoria();
    }

    @Override
    public List<RolCategoria> listar() {
        return dao.findAll();
    }
}
