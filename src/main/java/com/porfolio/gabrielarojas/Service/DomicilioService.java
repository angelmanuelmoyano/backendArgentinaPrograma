package com.porfolio.gabrielarojas.Service;

import com.porfolio.gabrielarojas.Entity.Domicilio;
import com.porfolio.gabrielarojas.Entity.Persona;
import com.porfolio.gabrielarojas.Interface.IDomicilioService;
import com.porfolio.gabrielarojas.Repository.DomicilioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomicilioService  implements IDomicilioService {
    @Autowired
    DomicilioRepository domicilioRepository;


    @Override
    public List<Domicilio> getDomicilios() {
        List<Domicilio> domicilios =domicilioRepository.findAll();
        return domicilios;

    }

    @Override
    public void saveDomicilio(Domicilio domicilio) {
      domicilioRepository.save(domicilio);
    }

    @Override
    public void deleteDomicilio(Long id) {
     domicilioRepository.deleteById(id);
    }

    @Override
    public Domicilio findDomicilio(Long id) {
        Domicilio domicilio = domicilioRepository.findById(id).orElse(null);;
        return domicilio;
    }
}
