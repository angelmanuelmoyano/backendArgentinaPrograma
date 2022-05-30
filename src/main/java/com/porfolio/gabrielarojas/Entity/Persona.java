package com.porfolio.gabrielarojas.Entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 1, max = 50, message = "El campo contiene demasiado caracteres")
    private String nombre;
    @NotNull
    @Size(min = 1, max = 50, message = "El campo contiene demasiado caracteres")
    private String apellido;
    @Column(name = "imagen_portada")
    private String imagen_portada;
    @Column(name = "logo_portada")
    private String logo_portada;

    private String email;

    private String password;

    private String acercade;

    private String facebook;

    private String instagram;

    private String linkedin;

    private String  twiter;

    private String numero_whasap;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="fk_domicilio")
    private Domicilio domicilio;


    @OneToOne(mappedBy = "persona")
    private Roles_Persona roles_persona;

    @OneToMany(mappedBy = "persona")
    private List<Educacion> educacion;

    @OneToMany(mappedBy = "persona")
    private List<Experiencia> experiencia;

    @OneToMany(mappedBy = "persona")
    private List<Habilidades> habilidades;

    @OneToMany(mappedBy = "persona")
    private List<Proyectos> proyectos;

    /*public Persona(Long id, String nombre, String apellido, String imagen_portada, String logo_portada, String email, String password, String acercade, String facebook, String instagram, String linkedin, String twiter, String numero_whasap, Domicilio domicilio) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.imagen_portada = imagen_portada;
        this.logo_portada = logo_portada;
        this.email = email;
        this.password = password;
        this.acercade = acercade;
        this.facebook = facebook;
        this.instagram = instagram;
        this.linkedin = linkedin;
        this.twiter = twiter;
        this.numero_whasap = numero_whasap;
        this.domicilio = domicilio;
    }*/
}
