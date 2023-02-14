package com.grapes.mmotor.security.service.impl;

import com.grapes.mmotor.security.dao.RoleDao;
import com.grapes.mmotor.security.model.Role;
import com.grapes.mmotor.security.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private RoleDao dao;

    @Override
    public Role getRole(String id) {
        Optional<Role> opt = dao.findById(id);
        return opt.isPresent() ? opt.get() : new Role();
    }

}
