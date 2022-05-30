package com.porfolio.gabrielarojas.Service;

import com.porfolio.gabrielarojas.Entity.Proyectos;
import com.porfolio.gabrielarojas.Interface.IProyectosService;
import com.porfolio.gabrielarojas.Repository.ProyectosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProyectosService implements IProyectosService {
    @Autowired
    ProyectosRepository proyectosRepository;

    @Override
    public List<Proyectos> getProyectos() {
        List<Proyectos> proyectos= proyectosRepository.findAll();
        return proyectos;
    }

    @Override
    public void saveProyecto(Proyectos proyecto) {
      proyectosRepository.save(proyecto);
    }

    @Override
    public void deleteProyecto(Long id) {
       proyectosRepository.deleteById(id);
    }

    @Override
    public Proyectos findProyecto(Long id) {
        Proyectos proyecto= proyectosRepository.findById(id).orElse(null);
        return  proyecto;
    }
}
