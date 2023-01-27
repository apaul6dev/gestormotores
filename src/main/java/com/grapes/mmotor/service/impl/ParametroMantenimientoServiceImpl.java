package com.grapes.mmotor.service.impl;

import com.grapes.mmotor.dao.IParametroMantenimientoDao;
import com.grapes.mmotor.model.ParametroMantenimiento;
import com.grapes.mmotor.service.IParametroMantenimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParametroMantenimientoServiceImpl implements IParametroMantenimientoService {
    @Autowired
    private IParametroMantenimientoDao dao;

    @Override
    public void registrar(ParametroMantenimiento parametroMantenimiento) {
        dao.save(parametroMantenimiento);

    }

    @Override
    public void modificar(ParametroMantenimiento parametroMantenimiento) {
        dao.save(parametroMantenimiento);

    }

    @Override
    public void eliminar(int id) {
        dao.deleteById(id);

    }

    @Override
    public ParametroMantenimiento listarId(int id) {
        Optional<ParametroMantenimiento> opt = dao.findById(id);
        return opt.isPresent() ? opt.get() : new ParametroMantenimiento();
    }

    @Override
    public List<ParametroMantenimiento> listar() {
        return dao.findAll();
    }
}

