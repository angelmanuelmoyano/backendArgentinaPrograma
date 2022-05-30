package com.porfolio.gabrielarojas.Controller;

import com.porfolio.gabrielarojas.Entity.Domicilio;
import com.porfolio.gabrielarojas.Service.DomicilioService;
import com.porfolio.gabrielarojas.Service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.porfolio.gabrielarojas.Entity.Persona;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:9000")
public class PersonaController {
    @Autowired
    PersonaService personaService;
    DomicilioService domicilioService;


    @GetMapping("/personas/traer")
    public List<Persona> getPersona(){
        return personaService.getPersona();
    }
    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody  Persona persona){
        personaService.savePersona(persona);
        return "Persona Creada";
    }
    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        personaService.deletePersona(id);
        return "La persona fue eliminada";
    }
    @PutMapping("/personas/editar/{id}")
    public Persona editPersona(@PathVariable Long id,
                              @RequestParam("nombre") String nombre,
                              @RequestParam("apellido") String apellido,
                              @RequestParam("imagen_portada") String imagen_portada,
                              @RequestParam("email") String email,
                              @RequestParam("password") String password,
                              @RequestParam("logo_portada") String logo_portada,
                              @RequestParam("facebook") String facebook,
                              @RequestParam("linkedin") String linkedin,
                              @RequestParam("twiter") String twiter,
                              @RequestParam("instagram,") String instagram,
                              @RequestParam("acercade") String acercade,
                              @RequestParam("numero_whasap") String numero_whasap,
                              @RequestParam("fk_domicilio") long fk_domicilio){

        Persona persona= personaService.findPersona(id);
        persona.setNombre(nombre);
        persona.setApellido(apellido);
        persona.setImagen_portada(imagen_portada);
        persona.setAcercade(acercade);
        persona.setEmail(email);
        persona.setPassword(password);
        persona.setFacebook(facebook);
        persona.setInstagram(instagram);
        persona.setTwiter(twiter);
        persona.setLinkedin(linkedin);
        persona.setLogo_portada(logo_portada);
        persona.setNumero_whasap(numero_whasap);
        Domicilio domicilio= domicilioService.findDomicilio(fk_domicilio);
        persona.setDomicilio(domicilio);
        personaService.savePersona(persona);
        return persona;
    }

}
