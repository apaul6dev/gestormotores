package com.grapes.mmotor.dao;

import com.grapes.mmotor.model.ParametroMantenimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IParametroMantenimientoDao extends JpaRepository<ParametroMantenimiento, Integer> {
}
