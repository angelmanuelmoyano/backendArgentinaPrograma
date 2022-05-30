package com.porfolio.gabrielarojas.Interface;

import com.porfolio.gabrielarojas.Entity.Roles;

import java.util.List;

public interface IRolesService {

    public List<Roles> getRoles();

    public void saveRol(Roles rol);

    public void deleteRol(Long id);

    public Roles findRol(Long id);
}
