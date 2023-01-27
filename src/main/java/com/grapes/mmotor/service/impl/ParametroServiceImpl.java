package com.grapes.mmotor.service.impl;

import com.grapes.mmotor.dao.IParametroDao;
import com.grapes.mmotor.model.Parametro;
import com.grapes.mmotor.service.IParametroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParametroServiceImpl implements IParametroService {
    @Autowired
    private IParametroDao dao;

    @Override
    public void registrar(Parametro parametro) {
        dao.save(parametro);

    }

    @Override
    public void modificar(Parametro parametro) {
        dao.save(parametro);

    }

    @Override
    public void eliminar(int id) {
        dao.deleteById(id);

    }

    @Override
    public Parametro listarId(int id) {
        Optional<Parametro> opt = dao.findById(id);
        return opt.isPresent() ? opt.get() : new Parametro();
    }

    @Override
    public List<Parametro> listar() {
        return dao.findAll();
    }
}
