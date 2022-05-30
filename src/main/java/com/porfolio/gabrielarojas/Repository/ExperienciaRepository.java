package com.porfolio.gabrielarojas.Repository;


import com.porfolio.gabrielarojas.Entity.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienciaRepository   extends JpaRepository<Experiencia,Long> {
}
