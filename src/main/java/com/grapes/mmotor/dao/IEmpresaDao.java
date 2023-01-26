package com.grapes.mmotor.dao;

import com.grapes.mmotor.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmpresaDao extends JpaRepository<Empresa, Integer> {
}
