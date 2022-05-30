package com.porfolio.gabrielarojas.Controller;

import com.porfolio.gabrielarojas.Entity.Domicilio;

import com.porfolio.gabrielarojas.Service.DomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:9000")
public class DomicilioController {
    @Autowired
    DomicilioService domicilioService;

    @GetMapping("/domicilio/traer")
    public List<Domicilio> getDomicilio(){
        return domicilioService.getDomicilios();
    }
    @PostMapping("/domicilio/crear")
    public String createDomicilio(@RequestBody Domicilio domicilio){
        domicilioService.saveDomicilio(domicilio);
        return "Domicilio Creado";
    }
    @DeleteMapping("/domicilio/borrar/{id}")
    public String deleteDomicilio(@PathVariable Long id){
        domicilioService.deleteDomicilio(id);
        return "El Domicilio fue eliminado";
    }
    @PutMapping("/domicilio/editar/{id}")
    public Domicilio editDomicilio(@PathVariable Long id,
                                  @RequestParam("localidad") String localidad,
                                  @RequestParam("nombre_calle") String nombre_calle,
                                  @RequestParam("numero") int numero,
                                  @RequestParam("pais") String pais,
                                  @RequestParam("provincia") String provincia
    ) {
        Domicilio domicilio= domicilioService.findDomicilio(id);
        domicilio.setLocalidad(localidad);
        domicilio.setNombre_calle(nombre_calle);
        domicilio.setNumero(numero);
        domicilio.setProvincia(provincia);
        domicilio.setPais(pais);
        domicilioService.saveDomicilio(domicilio);
        return domicilio;
    }
}
