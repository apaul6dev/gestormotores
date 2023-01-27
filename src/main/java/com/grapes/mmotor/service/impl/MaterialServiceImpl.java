package com.grapes.mmotor.service.impl;

import com.grapes.mmotor.dao.IMaterialDao;
import com.grapes.mmotor.model.Material;
import com.grapes.mmotor.service.IMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaterialServiceImpl implements IMaterialService {
    @Autowired
    private IMaterialDao dao;

    @Override
    public void registrar(Material material) {
        dao.save(material);

    }

    @Override
    public void modificar(Material material) {
        dao.save(material);

    }

    @Override
    public void eliminar(int id) {
        dao.deleteById(id);

    }

    @Override
    public Material listarId(int id) {
        Optional<Material> opt = dao.findById(id);
        return opt.isPresent() ? opt.get() : new Material();
    }

    @Override
    public List<Material> listar() {
        return dao.findAll();
    }
}
