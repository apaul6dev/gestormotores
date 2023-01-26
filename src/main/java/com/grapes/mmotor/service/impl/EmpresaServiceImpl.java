package com.grapes.mmotor.service.impl;

import com.grapes.mmotor.dao.IEmpresaDao;
import com.grapes.mmotor.model.Empresa;
import com.grapes.mmotor.service.IEmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaServiceImpl implements IEmpresaService {
    @Autowired
    private IEmpresaDao dao;

    @Override
    public void registrar(Empresa data) {
        dao.save(data);
    }

    @Override
    public void modificar(Empresa data) {
        dao.save(data);
    }

    @Override
    public void eliminar(int idData) {
        dao.deleteById(idData);
    }

    @Override
    public Empresa listarId(int idData) {
        Optional<Empresa> opt = dao.findById(idData);
        return opt.isPresent() ? opt.get() : new Empresa();
    }

    @Override
    public List<Empresa> listar() {
        return dao.findAll();
    }
}
