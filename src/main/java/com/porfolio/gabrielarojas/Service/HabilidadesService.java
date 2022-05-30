package com.porfolio.gabrielarojas.Service;

import com.porfolio.gabrielarojas.Entity.Habilidades;
import com.porfolio.gabrielarojas.Interface.IHabilidadesService;
import com.porfolio.gabrielarojas.Repository.HabilidadesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Access;
import java.util.List;

@Service
public class HabilidadesService implements IHabilidadesService {
    @Autowired
    HabilidadesRepository habilidadesRepository;
    @Override
    public List<Habilidades> getHabilidades() {
        List<Habilidades> habilidades= habilidadesRepository.findAll();
       return  habilidades;
    }

    @Override
    public void saveHabilidad(Habilidades habilidad) {
       habilidadesRepository.save(habilidad);
    }

    @Override
    public void deleteHabilidad(Long id) {
       habilidadesRepository.deleteById(id);
    }

    @Override
    public Habilidades findHabilidad(Long id) {
        Habilidades habilidad = habilidadesRepository.findById(id).orElse(null);
        return  habilidad;
    }
}
