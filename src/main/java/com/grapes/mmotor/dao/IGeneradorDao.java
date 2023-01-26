package com.grapes.mmotor.dao;

import com.grapes.mmotor.model.Generador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGeneradorDao extends JpaRepository<Generador, Integer> {
}
