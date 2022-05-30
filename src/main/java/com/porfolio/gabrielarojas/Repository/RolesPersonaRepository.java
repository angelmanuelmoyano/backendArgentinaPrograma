package com.porfolio.gabrielarojas.Repository;

import com.porfolio.gabrielarojas.Entity.Roles_Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesPersonaRepository   extends JpaRepository<Roles_Persona,Long> {
}
