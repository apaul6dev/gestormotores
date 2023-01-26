package com.grapes.mmotor.dao;

import com.grapes.mmotor.model.UsuarioTipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IUsuarioTipo extends JpaRepository<UsuarioTipo, Integer> {
}
