package com.porfolio.gabrielarojas.Service;

import com.porfolio.gabrielarojas.Entity.Experiencia;
import com.porfolio.gabrielarojas.Interface.IExperienciaService;
import com.porfolio.gabrielarojas.Repository.ExperienciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienciaService implements IExperienciaService {
    @Autowired
    ExperienciaRepository experienciaRepository;


    @Override
    public List<Experiencia> getExperiencia() {
        List<Experiencia> experiencias = experienciaRepository.findAll();
        return experiencias;
    }

    @Override
    public void saveExperiencia(Experiencia experiencia) {
            experienciaRepository.save(experiencia);
    }

    @Override
    public void deleteExperiencia(Long id) {
           experienciaRepository.deleteById(id);
    }

    @Override
    public Experiencia findExperiencia(Long id) {
        Experiencia experiencia= experienciaRepository.findById(id).orElse(null);
        return experiencia;
    }
}
