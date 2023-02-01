package com.grapes.mmotor.service.impl;

import com.grapes.mmotor.dao.IOrdenTrabajoDao;
import com.grapes.mmotor.model.OrdenTrabajo;
import com.grapes.mmotor.service.IOrdenTrabajoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class OrdenTrabajoImpl implements IOrdenTrabajoService {
    @Autowired
    private IOrdenTrabajoDao dao;
    @Override
    public void registrar(OrdenTrabajo ordenTrabajo) {dao.save(ordenTrabajo);

    }

    @Override
    public void modificar(OrdenTrabajo ordenTrabajo) {dao.save(ordenTrabajo);

    }

    @Override
    public void eliminar(int id) {dao.deleteById(id);

    }

    @Override
    public OrdenTrabajo listarId(int id) {
        Optional<OrdenTrabajo> opt = dao.findById(id);
        return opt.isPresent() ? opt.get() : new OrdenTrabajo();
    }

    @Override
    public List<OrdenTrabajo> listar() {
        return dao.findAll();
    }
}
