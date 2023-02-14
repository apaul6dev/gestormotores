package com.grapes.mmotor.security.dao;

import com.grapes.mmotor.security.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuDao extends JpaRepository<Menu, Integer> {
    @Query(value="select m.* from _user u, _role r, _menu m, _menu_role mr where mr.role = r.role and mr.id_menu = m.id_menu and u.role = r.role and u.username = :username",nativeQuery = true)
    List<Menu>listMenuByUsername(@Param("username") String username);

}
