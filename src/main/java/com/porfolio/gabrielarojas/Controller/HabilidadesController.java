package com.porfolio.gabrielarojas.Controller;

import com.porfolio.gabrielarojas.Entity.Habilidades;
import com.porfolio.gabrielarojas.Entity.Persona;
import com.porfolio.gabrielarojas.Interface.IHabilidadesService;
import com.porfolio.gabrielarojas.Service.HabilidadesService;
import com.porfolio.gabrielarojas.Service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:9000")
public class HabilidadesController {
    @Autowired
    HabilidadesService habilidadesService;
    @Autowired
    PersonaService personaService;

    @GetMapping("/habilidades/traer")
    public List<Habilidades> getHabilidades(){
        return habilidadesService.getHabilidades();
    }
    @PostMapping("/habilidades/crear")
    public String createHabilidad(@RequestBody Habilidades habilidad){
        habilidadesService.saveHabilidad(habilidad);
        return "Habilidad Creada";
    }
    @DeleteMapping("/habilidades/borrar/{id}")
    public String deleteHabilidad(@PathVariable Long id){
        habilidadesService.deleteHabilidad(id);
        return "La Habilidad fue eliminada";
    }
    @PutMapping("/habilidades/editar/{id}")
    public Habilidades editHabilidad(@PathVariable Long id,
                               @RequestParam("nombre_habilidad") String nombre_habilidad,
                               @RequestParam("porcentaje_adquirido") int porcentaje_adquirido,
                               @RequestParam("fk_persona") long fk_persona){

        Habilidades habilidad= habilidadesService.findHabilidad(id);
        habilidad.setNombre_habilidad(nombre_habilidad);
        habilidad.setPorcentaje_adquirido(porcentaje_adquirido);
        Persona persona= personaService.findPersona(fk_persona);
        habilidad.setPersona(persona);
        habilidadesService.saveHabilidad(habilidad);
        return habilidad;
    }

}
