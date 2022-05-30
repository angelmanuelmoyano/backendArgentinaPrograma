package com.porfolio.gabrielarojas.Repository;

import com.porfolio.gabrielarojas.Entity.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface   DomicilioRepository extends JpaRepository<Domicilio,Long> {
}
