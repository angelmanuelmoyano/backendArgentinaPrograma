package com.porfolio.gabrielarojas.Interface;

import com.porfolio.gabrielarojas.Entity.Roles_Persona;

import java.util.List;

public interface IRoles_PersonaService {
    public List<Roles_Persona> getRolesPersona();

    public void saveRolesPersona(Roles_Persona rolesPersona);

    public void deleteRolesPersona(Long id);

    public Roles_Persona findRolesPersona(Long id);
}
