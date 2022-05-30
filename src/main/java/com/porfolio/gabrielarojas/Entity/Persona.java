package com.porfolio.gabrielarojas.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
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





}
