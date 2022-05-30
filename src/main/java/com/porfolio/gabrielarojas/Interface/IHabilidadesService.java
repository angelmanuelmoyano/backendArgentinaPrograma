package com.porfolio.gabrielarojas.Interface;

import com.porfolio.gabrielarojas.Entity.Habilidades;

import java.util.List;

public interface IHabilidadesService {
    public List<Habilidades> getHabilidades();

    public void saveHabilidad(Habilidades habilidad);

    public void deleteHabilidad(Long id);

    public Habilidades findHabilidad(Long id);
}
