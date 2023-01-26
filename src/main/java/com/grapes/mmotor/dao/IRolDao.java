package com.grapes.mmotor.dao;

import com.grapes.mmotor.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IRolDao extends JpaRepository<Rol, Integer> {
}
