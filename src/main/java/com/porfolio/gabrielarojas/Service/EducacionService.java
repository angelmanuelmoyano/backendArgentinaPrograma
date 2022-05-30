package com.porfolio.gabrielarojas.Service;

import com.porfolio.gabrielarojas.Entity.Educacion;
import com.porfolio.gabrielarojas.Interface.IEducacionService;
import com.porfolio.gabrielarojas.Repository.EducacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducacionService  implements IEducacionService {
    @Autowired
    EducacionRepository educacionRepository;

    @Override
    public List<Educacion> getEducacion() {
         List<Educacion> educacion=  educacionRepository.findAll();
        return educacion;
    }

    @Override
    public void saveEducacion(Educacion educacion) {
            educacionRepository.save(educacion);
    }

    @Override
    public void deleteEducacion(Long id) {
        educacionRepository.deleteById(id);
    }

    @Override
    public Educacion findEducacion(Long id) {
        Educacion educacion= educacionRepository.findById(id).orElse(null);
       return educacion;
    }
}
