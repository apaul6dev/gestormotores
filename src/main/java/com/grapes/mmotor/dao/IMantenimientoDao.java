package com.grapes.mmotor.dao;

import com.grapes.mmotor.model.Mantenimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMantenimientoDao extends JpaRepository<Mantenimiento,Integer> {
}

