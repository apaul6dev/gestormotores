package com.grapes.mmotor.dao;

import com.grapes.mmotor.model.MaterialCategoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IMaterialCategoriaDao extends JpaRepository<MaterialCategoria, Integer> {
}
