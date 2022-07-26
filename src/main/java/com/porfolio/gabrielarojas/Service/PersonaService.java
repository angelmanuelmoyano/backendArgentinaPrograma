package com.porfolio.gabrielarojas.Service;

import com.porfolio.gabrielarojas.Entity.Persona;
import com.porfolio.gabrielarojas.Interface.IPersonaService;
import com.porfolio.gabrielarojas.Repository.IPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService implements IPersonaService {
     @Autowired
     IPersonaRepository ipersonarepository;
    @Override
    public List<Persona> getPersona() {
        List<Persona> persona =ipersonarepository.findAll();
        return persona;
    }

    @Override
    public void savePersona(Persona persona) {
       ipersonarepository.save(persona);
    }

    @Override
    public void deletePersona(Long id) {
        ipersonarepository.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        Persona persona = ipersonarepository.findById(id).orElse(null);

        return persona;
    }
    public Optional<Persona> getUserByEmail(String email){
        return ipersonarepository.findByEmail(email);

    }
    public Persona loadUser(String usuario){
        Persona persona = getUserByEmail(usuario).get();
        return persona;
    }
}
