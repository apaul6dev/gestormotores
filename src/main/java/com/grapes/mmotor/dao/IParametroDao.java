package com.grapes.mmotor.dao;

import com.grapes.mmotor.model.Parametro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IParametroDao extends JpaRepository<Parametro, Integer> {
}
