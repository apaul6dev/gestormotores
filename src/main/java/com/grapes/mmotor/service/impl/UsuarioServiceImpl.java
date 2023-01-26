package com.grapes.mmotor.service.impl;

import com.grapes.mmotor.dao.IUsuarioDao;
import com.grapes.mmotor.model.Rol;
import com.grapes.mmotor.model.Usuario;
import com.grapes.mmotor.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UsuarioServiceImpl implements IUsuarioService {
    @Autowired
    private IUsuarioDao dao;

    @Override
    public void registrar(Usuario usuario) {
        dao.save(usuario);
    }

    @Override
    public void modificar(Usuario usuario) {
        dao.save(usuario);
    }

    @Override
    public void eliminar(int id) {
        dao.deleteById(id);
    }

    @Override
    public Usuario listarId(int id) {
        Optional<Usuario> opt = dao.findById(id);
        return opt.isPresent() ? opt.get() : new Usuario();
    }

    @Override
    public List<Usuario> listar() {
        return dao.findAll();
    }
}
