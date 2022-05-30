package com.porfolio.gabrielarojas.Controller;

import com.porfolio.gabrielarojas.Entity.Persona;
import com.porfolio.gabrielarojas.Entity.Proyectos;
import com.porfolio.gabrielarojas.Entity.Roles;
import com.porfolio.gabrielarojas.Service.PersonaService;
import com.porfolio.gabrielarojas.Service.ProyectosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:9000")
public class ProyectosController {
    @Autowired
    ProyectosService proyectosService;
    PersonaService personaService;

    @GetMapping("/proyectos/traer")
    public List<Proyectos> getProyectos(){
        return proyectosService.getProyectos();
    }
    @PostMapping("/proyectos/crear")
    public String createProyecto(@RequestBody Proyectos proyecto){
        proyectosService.saveProyecto(proyecto);
        return "Proyecto Creado";
    }
    @DeleteMapping("/proyectos/borrar/{id}")
    public String deleteProyecto(@PathVariable Long id){
        proyectosService.deleteProyecto(id);
        return "El Proyefto fue eliminado";
    }
    @PutMapping("/proyectos/editar/{id}")
    public Proyectos editProyecto(@PathVariable Long id,
                         @RequestParam("descripcion") String descripcion,
                         @RequestParam("fecha_realizacion") String fecha_realizacion,
                         @RequestParam("imagen_1") String imagen_1,
                         @RequestParam("imagen_2") String imagen_2,
                         @RequestParam("imagen_3") String imagen_3,
                         @RequestParam("link") String link,
                         @RequestParam("link_repositorio") String links_repositorio,
                         @RequestParam("nombre_proyecto") String nombre_proyecto,
                         @RequestParam("fk_persona") long fk_persona
    ) throws ParseException {

        Proyectos proyecto= proyectosService.findProyecto(id);
        proyecto.setDescripcion(descripcion);
        proyecto.setNombre_proyecto(nombre_proyecto);
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaRealizacion = formato.parse(fecha_realizacion);
        proyecto.setFecha_realizacion(fechaRealizacion);
        proyecto.setImagen_1(imagen_1);
        proyecto.setImagen_2(imagen_2);
        proyecto.setImagen_3(imagen_3);
        proyecto.setLink(link);
        proyecto.setLink_repositorio(links_repositorio);
        Persona persona= personaService.findPersona(fk_persona);
         proyecto.setPersona(persona);
         proyectosService.saveProyecto(proyecto);
        return proyecto;
    }
}
