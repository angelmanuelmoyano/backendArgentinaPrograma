package com.porfolio.gabrielarojas.Repository;

import com.porfolio.gabrielarojas.Entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

@Repository
public interface IPersonaRepository extends JpaRepository<Persona,Long> {
    Optional<Persona> findByEmail(String email);
    @Query(value = "SELECT * FROM persona  WHERE persona.email = :email AND persona.password = :password", nativeQuery = true)
    Optional<Persona> findByEmailPassword(@Param("email") String email,@Param("password") String password);

}
