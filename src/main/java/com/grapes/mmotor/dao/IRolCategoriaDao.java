package com.grapes.mmotor.dao;

import com.grapes.mmotor.model.RolCategoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IRolCategoriaDao extends JpaRepository<RolCategoria, Integer> {
}
