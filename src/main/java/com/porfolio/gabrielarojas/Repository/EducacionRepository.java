package com.porfolio.gabrielarojas.Repository;

import com.porfolio.gabrielarojas.Entity.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducacionRepository  extends JpaRepository<Educacion,Long>{


}
