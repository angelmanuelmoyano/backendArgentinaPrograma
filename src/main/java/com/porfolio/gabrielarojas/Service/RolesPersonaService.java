package com.porfolio.gabrielarojas.Service;

import com.porfolio.gabrielarojas.Entity.Roles;
import com.porfolio.gabrielarojas.Entity.Roles_Persona;
import com.porfolio.gabrielarojas.Interface.IRoles_PersonaService;
import com.porfolio.gabrielarojas.Repository.RolesPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolesPersonaService  implements IRoles_PersonaService {
    @Autowired
    RolesPersonaRepository rolesPersonaRepository;
    @Override
    public List<Roles_Persona> getRolesPersona() {
         List<Roles_Persona> roles_personas= rolesPersonaRepository.findAll();
         return roles_personas;
    }

    @Override
    public void saveRolesPersona(Roles_Persona rolesPersona) {
        rolesPersonaRepository.save(rolesPersona);
    }

    @Override
    public void deleteRolesPersona(Long id) {
           rolesPersonaRepository.deleteById(id);
    }

    @Override
    public Roles_Persona findRolesPersona(Long id) {
        Roles_Persona rolesPersona = rolesPersonaRepository.findById(id).orElse(null);
        return rolesPersona;
    }
}
