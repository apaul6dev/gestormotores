package com.grapes.mmotor.service.impl;

import com.grapes.mmotor.dao.IMaterialCategoriaDao;
import com.grapes.mmotor.model.MaterialCategoria;
import com.grapes.mmotor.service.IMaterialCategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaterialCategoriaServiceImpl implements IMaterialCategoriaService {
    @Autowired
    private IMaterialCategoriaDao dao;
    @Override
    public void registrar(MaterialCategoria materialCategoria) {dao.save(materialCategoria);

    }

    @Override
    public void modificar(MaterialCategoria materialCategoria) {dao.save(materialCategoria);

    }

    @Override
    public void eliminar(int id) {dao.deleteById(id);

    }

    @Override
    public MaterialCategoria listarId(int id) {
        Optional<MaterialCategoria> opt = dao.findById(id);
        return opt.isPresent() ? opt.get() : new MaterialCategoria();
    }

    @Override
    public List<MaterialCategoria> listar() {
        return dao.findAll();
    }
    }

