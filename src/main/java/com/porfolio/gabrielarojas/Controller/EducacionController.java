package com.porfolio.gabrielarojas.Controller;

import com.porfolio.gabrielarojas.Entity.Educacion;
import com.porfolio.gabrielarojas.Entity.Persona;
import com.porfolio.gabrielarojas.Service.EducacionService;
import com.porfolio.gabrielarojas.Service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:9000")
public class EducacionController {
@Autowired
        EducacionService educacionService;
        PersonaService personaService;

        @GetMapping("/educacion/traer")
        public List<Educacion> getEducacion(){
                return educacionService.getEducacion();
        }
        @PostMapping("/educacion/crear")
        public String createEducacion(@RequestBody Educacion educacion){
                educacionService.saveEducacion(educacion);
                return "Educacion Creada";
        }
        @DeleteMapping("/educacion/borrar/{id}")
        public String deleteEducacion(@PathVariable Long id){
                educacionService.deleteEducacion(id);
                return "Educacion eliminada";
        }
        @PutMapping("/educacion/editar/{id}")
        public Educacion editEducacion(@PathVariable Long id,
                                   @RequestParam("carrera") String carrera,
                                   @RequestParam("fecha_fin") String fecha_fin,
                                   @RequestParam("fecha_inicio") String fecha_inicio,
                                   @RequestParam("logo_institucion") String logo_institucion,
                                   @RequestParam ("nombre_institucion") String nombre_institucion,
                                   @RequestParam ("titulo") String titulo,
                                   @RequestParam ("fk_persona") long fk_persona    ) throws ParseException {

                Educacion educacion= educacionService.findEducacion(id);
                educacion.setCarrera(carrera);
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                Date fechaFin = formato.parse(fecha_fin);
                Date fechaInicio = formato.parse(fecha_inicio);
                educacion.setFecha_fin(fechaFin);
                educacion.setFecha_inicio(fechaInicio);
                educacion.setLogo_institucion(logo_institucion);
                educacion.setNombre_institucion(nombre_institucion);
                Persona persona= personaService.findPersona(fk_persona);
                educacion.setPersona(persona);
                educacionService.saveEducacion(educacion);
                return educacion;
        }

        }
