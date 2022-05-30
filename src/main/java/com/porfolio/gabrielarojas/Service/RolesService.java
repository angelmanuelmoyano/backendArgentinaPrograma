package com.porfolio.gabrielarojas.Service;

import com.porfolio.gabrielarojas.Entity.Roles;
import com.porfolio.gabrielarojas.Interface.IRolesService;
import com.porfolio.gabrielarojas.Repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolesService  implements IRolesService {
    @Autowired
    RolesRepository rolesRepository;
    @Override
    public List<Roles> getRoles() {
        List<Roles> roles=rolesRepository.findAll();
     return roles;
    }

    @Override
    public void saveRol(Roles rol) {
        rolesRepository.save(rol);
    }

    @Override
    public void deleteRol(Long id) {
         rolesRepository.deleteById(id);
    }

    @Override
    public Roles findRol(Long id) {
        Roles rol =rolesRepository.findById(id).orElse(null);
        return rol;
    }
}
