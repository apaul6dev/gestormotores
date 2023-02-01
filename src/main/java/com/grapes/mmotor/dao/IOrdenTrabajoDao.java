package com.grapes.mmotor.dao;

import com.grapes.mmotor.model.OrdenTrabajo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrdenTrabajoDao extends JpaRepository<OrdenTrabajo,Integer> {
}
