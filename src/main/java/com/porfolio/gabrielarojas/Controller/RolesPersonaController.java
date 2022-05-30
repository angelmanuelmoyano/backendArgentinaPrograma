package com.porfolio.gabrielarojas.Controller;

import com.porfolio.gabrielarojas.Entity.Persona;
import com.porfolio.gabrielarojas.Entity.Roles;
import com.porfolio.gabrielarojas.Entity.Roles_Persona;
import com.porfolio.gabrielarojas.Service.PersonaService;
import com.porfolio.gabrielarojas.Service.RolesPersonaService;
import com.porfolio.gabrielarojas.Service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:9000")
public class RolesPersonaController {
    @Autowired
    RolesPersonaService rolesPersonaService;
    @Autowired
    RolesService rolesService;
    @Autowired
    PersonaService personaService;

    @GetMapping("/rolespersonas/traer")
    public List<Roles_Persona> getRolesPersona(){
        return rolesPersonaService.getRolesPersona();
    }
    @PostMapping("/rolespersonas/crear")
    public String createRolPersona(@RequestBody Roles_Persona rolesPersona){
        rolesPersonaService.saveRolesPersona(rolesPersona);
        return "Rol Asociado a persona";
    }
    @DeleteMapping("/rolespersona/borrar/{id}")
    public String deleteRolesPersona(@PathVariable Long id){
        rolesPersonaService.deleteRolesPersona(id);
        return "El rol fue eliminado a la persona";
    }
    @PutMapping("/rolespersona/editar/{id}")
    public Roles_Persona editRol(@PathVariable Long id,
                         @RequestParam("fk_persona") long fk_persona,
                         @RequestParam("fk_rol") long fk_rol)
    {

        Roles_Persona rolesPersona= rolesPersonaService.findRolesPersona(id);
        Roles rol= rolesService.findRol(fk_rol);
        Persona persona= personaService.findPersona(fk_persona);
        rolesPersona.setPersona(persona);
        rolesPersona.setRol(rol);
        rolesPersonaService.saveRolesPersona(rolesPersona);

        return rolesPersona;
    }

}
