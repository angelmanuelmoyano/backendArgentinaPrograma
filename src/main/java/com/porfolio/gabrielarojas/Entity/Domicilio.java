package com.porfolio.gabrielarojas.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Domicilio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre_calle")
    private String nombre_calle;
    private int numero;
    private String localidad;
    private String provincia;
    private String pais;
    @OneToOne(mappedBy = "fk_domicilio")
    private Persona persona;


}
