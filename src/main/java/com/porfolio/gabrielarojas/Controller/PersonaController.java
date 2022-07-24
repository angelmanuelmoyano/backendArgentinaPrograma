package com.porfolio.gabrielarojas.Controller;

import com.porfolio.gabrielarojas.Entity.*;
import com.porfolio.gabrielarojas.Service.DomicilioService;
import com.porfolio.gabrielarojas.Service.HabilidadesService;
import com.porfolio.gabrielarojas.Service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:9000")
public class PersonaController {
    @Autowired
    PersonaService personaService;
    @Autowired
    DomicilioService domicilioService;

    @Autowired
    HabilidadesService habilidadesService;


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
                              @RequestParam("instagram") String instagram,
                              @RequestParam("acercade") String acercade,
                              @RequestParam("numero_whasap") String numero_whasap,
                              @RequestParam("fk_domicilio") int fk_domicilio){

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
        Domicilio domicilio= domicilioService.findDomicilio((long) fk_domicilio);
        //Habilidades habilidades= habilidadesService.
        persona.setDomicilio(domicilio);

        personaService.savePersona(persona);


        return persona;
    }

    @PutMapping("/personas/editar_persona/{id}")
    public Persona editPersona_hab(@PathVariable Long id,
                                   @RequestBody  Persona persona){
                                  // @RequestBody  Habilidades habilidad){

        Persona persona2= personaService.findPersona(id);
        persona2.setNombre(persona.getNombre());
        persona2.setApellido(persona.getApellido());
        persona2.setImagen_portada(persona.getImagen_portada());
        persona2.setAcercade(persona.getAcercade());
        persona2.setEmail(persona.getEmail());
        persona2.setPassword(persona.getPassword());
        persona2.setFacebook(persona.getFacebook());
        persona2.setInstagram(persona.getInstagram());
        persona2.setTwiter(persona.getTwiter());
        persona2.setLinkedin(persona.getLinkedin());
        persona2.setLogo_portada(persona.getImagen_portada());
        persona2.setNumero_whasap(persona.getNumero_whasap());
        Domicilio domicilio= domicilioService.findDomicilio((long) persona.getDomicilio().getId());
        domicilio.setNombre_calle(persona.getDomicilio().getNombre_calle());
        List<Habilidades> habilidades= persona.getHabilidades();
        List<Experiencia> experiencias = persona.getExperiencia();
        List<Educacion> educacion = persona.getEducacion();
        List<Proyectos> proyectos= persona.getProyectos();
        persona2.setHabilidades(habilidades);
        persona2.setExperiencia(experiencias);
        persona2.setProyectos(proyectos);
        persona2.setEducacion(educacion);

        personaService.savePersona(persona2);


        return persona2;
    }

}
