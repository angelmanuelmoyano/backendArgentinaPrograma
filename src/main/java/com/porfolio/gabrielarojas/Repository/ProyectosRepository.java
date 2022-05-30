package com.porfolio.gabrielarojas.Repository;

import com.porfolio.gabrielarojas.Entity.Proyectos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectosRepository  extends JpaRepository<Proyectos,Long> {
}
