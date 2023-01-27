package com.grapes.mmotor.service.impl;

import com.grapes.mmotor.dao.IMantenimientoTipoDao;
import com.grapes.mmotor.model.MantenimientoTipo;
import com.grapes.mmotor.service.IMantenimientoTipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MantenimientoTipoServiceImpl implements IMantenimientoTipoService {
    @Autowired
    private IMantenimientoTipoDao dao;

    @Override
    public void registrar(MantenimientoTipo mantenimientoTipo) {
        dao.save(mantenimientoTipo);
    }

    @Override
    public void modificar(MantenimientoTipo mantenimientoTipo) {
        dao.save(mantenimientoTipo);
    }

    @Override
    public void eliminar(int id) {
        dao.deleteById(id);

    }

    @Override
    public MantenimientoTipo listarId(int id) {
        Optional<MantenimientoTipo> opt = dao.findById(id);
        return opt.isPresent() ? opt.get() : new MantenimientoTipo();
    }

    @Override
    public List<MantenimientoTipo> listar() {
        return dao.findAll();
    }
}
