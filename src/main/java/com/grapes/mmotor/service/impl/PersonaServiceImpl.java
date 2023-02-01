package com.grapes.mmotor.service.impl;

import com.grapes.mmotor.dao.IPersonaDao;
import com.grapes.mmotor.model.Persona;
import com.grapes.mmotor.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImpl implements IPersonaService {
    @Autowired
    private IPersonaDao dao;
    @Override
    public void registrar(Persona persona) {dao.save(persona);

    }

    @Override
    public void modificar(Persona persona) {dao.save(persona);

    }

    @Override
    public void eliminar(int id) {dao.deleteById(id);

    }

    @Override
    public Persona listarId(int id) {
        Optional<Persona> opt = dao.findById(id);
        return opt.isPresent() ? opt.get() : new Persona();
    }

    @Override
    public List<Persona> listar() {
        return dao.findAll();
    }
}
