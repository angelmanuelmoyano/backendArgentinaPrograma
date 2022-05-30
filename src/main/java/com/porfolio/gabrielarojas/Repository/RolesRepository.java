package com.porfolio.gabrielarojas.Repository;

import com.porfolio.gabrielarojas.Entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository   extends JpaRepository<Roles,Long> {
}
