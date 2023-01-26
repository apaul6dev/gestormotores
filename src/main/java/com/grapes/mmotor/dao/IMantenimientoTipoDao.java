package com.grapes.mmotor.dao;

import com.grapes.mmotor.model.MantenimientoTipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IMantenimientoTipoDao extends JpaRepository<MantenimientoTipo, Integer> {
}
