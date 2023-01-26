package com.grapes.mmotor.dao;

import com.grapes.mmotor.model.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IMaterialDao extends JpaRepository<Material, Integer> {
}
