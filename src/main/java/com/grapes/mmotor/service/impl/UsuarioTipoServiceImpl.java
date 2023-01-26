package com.grapes.mmotor.service.impl;

import com.grapes.mmotor.dao.IUsuarioTipoDao;
import com.grapes.mmotor.model.UsuarioTipo;
import com.grapes.mmotor.service.IUsuarioTipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UsuarioTipoServiceImpl implements IUsuarioTipoService {
    @Autowired
    private IUsuarioTipoDao dao;

    @Override
    public void registrar(UsuarioTipo usuarioTipo) {
        dao.save(usuarioTipo);
    }

    @Override
    public void modificar(UsuarioTipo usuarioTipo) {
        dao.save(usuarioTipo);
    }

    @Override
    public void eliminar(int id) {
        dao.deleteById(id);
    }

    @Override
    public UsuarioTipo listarId(int id) {
        Optional<UsuarioTipo> opt = dao.findById(id);
        return opt.isPresent() ? opt.get() : new UsuarioTipo();
    }

    @Override
    public List<UsuarioTipo> listar() {
        return dao.findAll();
    }
}
