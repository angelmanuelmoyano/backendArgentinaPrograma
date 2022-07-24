package com.porfolio.gabrielarojas.Controller;

import com.porfolio.gabrielarojas.Entity.Experiencia;
import com.porfolio.gabrielarojas.Entity.Persona;
import com.porfolio.gabrielarojas.Service.ExperienciaService;
import com.porfolio.gabrielarojas.Service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:9000")
public class ExperienciaController {
    @Autowired
    ExperienciaService experienciaService;
    @Autowired
    PersonaService personaService;
    @GetMapping("/experiencia/traer")
    public List<Experiencia> getExperiencias(){
        return experienciaService.getExperiencia();
    }
    @PostMapping("/experiencia/crear")
    public String createExperiencia(@RequestBody Experiencia experiencia){
        experienciaService.saveExperiencia(experiencia);
        return "Experiencia Creada";
    }
    @DeleteMapping("/experiencia/borrar/{id}")
    public String deleteExperiencia(@PathVariable Long id){
        experienciaService.deleteExperiencia(id);
        return "La Experiencia fue eliminada";
    }
    @PutMapping("/experiencia/editar/{id}")
    public Experiencia editExperiencia(@PathVariable Long id,
                         @RequestParam("fecha_fin") String fecha_fin,
                         @RequestParam("fecha_inicio") String fecha_inicio,
                         @RequestParam("nombre_empresa") String nombre_empresa,
                         @RequestParam("puesto") String puesto,
                         @RequestParam("telefono") int telefono,
                         @RequestParam("fk_persona") int fk_persona
    ) throws ParseException {

        Experiencia experiencia= experienciaService.findExperiencia(id);
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaFin = formato.parse(fecha_fin);
        Date fechaInicio = formato.parse(fecha_inicio);
        experiencia.setFecha_fin(fechaFin);
        experiencia.setFecha_inicio(fechaInicio);
        experiencia.setNombre_empresa(nombre_empresa);
        experiencia.setPuesto(puesto);
        experiencia.setTelefono(telefono);
       /* Persona persona =  personaService.findPersona((long) fk_persona);
        experiencia.setPersona(persona);*/
        experienciaService.saveExperiencia(experiencia);

        return experiencia;
    }
}
