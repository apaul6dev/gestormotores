package com.grapes.mmotor.dao;

import com.grapes.mmotor.model.MantenimientoDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IMantenimientoDetalleDao extends JpaRepository<MantenimientoDetalle, Long> {
}
