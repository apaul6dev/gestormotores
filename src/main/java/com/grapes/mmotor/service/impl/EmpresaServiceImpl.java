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
    public void registrar(Empresa empresa) {
        dao.save(empresa);
    }

    @Override
    public void modificar(Empresa empresa) {
        dao.save(empresa);
    }

    @Override
    public void eliminar(int id) {
        dao.deleteById(id);
    }

    @Override
    public Empresa listarId(int id) {
        Optional<Empresa> opt = dao.findById(id);
        return opt.isPresent() ? opt.get() : new Empresa();
    }

    @Override
    public List<Empresa> listar() {
        return dao.findAll();
    }
}
