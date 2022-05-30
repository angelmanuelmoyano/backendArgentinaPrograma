package com.porfolio.gabrielarojas.Repository;

import com.porfolio.gabrielarojas.Entity.Habilidades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabilidadesRepository  extends JpaRepository<Habilidades,Long> {
}
