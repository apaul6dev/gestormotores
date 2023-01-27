package com.grapes.mmotor.service.impl;

import com.grapes.mmotor.dao.IGeneradorDao;
import com.grapes.mmotor.model.Generador;
import com.grapes.mmotor.model.MantenimientoTipo;
import com.grapes.mmotor.service.IGeneradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GeneradorServiceImpl implements IGeneradorService {
    @Autowired
    private IGeneradorDao dao;

    @Override
    public void registrar(Generador generador) {
        dao.save(generador);
    }

    @Override
    public void modificar(Generador generador) {
        dao.save(generador);
    }

    @Override
    public void eliminar(int id) {
        dao.deleteById(id);
    }

    @Override
    public Generador listarId(int id) {
        Optional<Generador> opt = dao.findById(id);
        return opt.isPresent() ? opt.get() : new Generador();
    }

    @Override
    public List<Generador> listar() {return dao.findAll();
    }
}
