package com.porfolio.gabrielarojas.Repository;

import com.porfolio.gabrielarojas.Entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPersonaRepository extends JpaRepository<Persona,Long> {
    Optional<Persona> findByEmail(String email);
}
