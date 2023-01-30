package com.grapes.mmotor.service.impl;

import com.grapes.mmotor.dao.IMantenimientoDetalleDao;
import com.grapes.mmotor.model.MantenimientoDetalle;
import com.grapes.mmotor.service.IMantenimientoDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MantenimientoDetalleServiceImpl implements IMantenimientoDetalleService {
    @Autowired
    private IMantenimientoDetalleDao dao;

    @Override
    public void registrar(MantenimientoDetalle mantenimientoDetalle) {
        dao.save(mantenimientoDetalle);

    }

    @Override
    public void modificar(MantenimientoDetalle mantenimientoDetalle) {
        dao.save(mantenimientoDetalle);

    }

    @Override
    public void eliminar(Long id) {
        dao.deleteById(id);
    }

    @Override
    public MantenimientoDetalle listarId(Long id) {
        Optional<MantenimientoDetalle> opt = dao.findById((long) id);
        return opt.isPresent() ? opt.get() : new MantenimientoDetalle();
    }

    @Override
    public List<MantenimientoDetalle> listar() {
        return dao.findAll();
    }
}
