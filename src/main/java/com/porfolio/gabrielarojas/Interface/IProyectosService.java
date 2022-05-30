package com.porfolio.gabrielarojas.Interface;

import com.porfolio.gabrielarojas.Entity.Proyectos;

import java.util.List;

public interface IProyectosService {
    public List<Proyectos> getProyectos();

    public void saveProyecto(Proyectos proyecto);

    public void deleteProyecto(Long id);

    public Proyectos findProyecto(Long id);
}
