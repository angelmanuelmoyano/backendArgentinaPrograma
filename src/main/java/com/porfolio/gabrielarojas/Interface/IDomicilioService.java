package com.porfolio.gabrielarojas.Interface;

import com.porfolio.gabrielarojas.Entity.Domicilio;

import java.util.List;

public interface IDomicilioService {

    public List<Domicilio> getDomicilios();

    public void saveDomicilio(Domicilio domicilio);

    public void deleteDomicilio(Long id);

    public Domicilio findDomicilio(Long id);

}
