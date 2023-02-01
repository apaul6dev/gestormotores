package com.grapes.mmotor.service.impl;

import com.grapes.mmotor.dao.IMantenimientoDao;
import com.grapes.mmotor.model.Mantenimiento;
import com.grapes.mmotor.service.IMantenimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MantenimientoServiceImpl implements IMantenimientoService {
    @Autowired
    private IMantenimientoDao dao;
    @Override
    public void registrar(Mantenimiento mantenimiento) {dao.save(mantenimiento);

    }

    @Override
    public void modificar(Mantenimiento mantenimiento) {dao.save(mantenimiento);

    }

    @Override
    public void eliminar(int id) {
        dao.deleteById(id);
    }

    @Override
    public Mantenimiento listarId(int id) {
        Optional<Mantenimiento> opt = dao.findById(id);
        return opt.isPresent() ? opt.get() : new Mantenimiento();
    }

    @Override
    public List<Mantenimiento> listar() {
        return dao.findAll();
    }
}
