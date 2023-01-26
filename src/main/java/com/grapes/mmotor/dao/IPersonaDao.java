package com.grapes.mmotor.dao;

import com.grapes.mmotor.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IPersonaDao extends JpaRepository<Persona, Integer> {
}
