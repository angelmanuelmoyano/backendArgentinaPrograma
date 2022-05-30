package com.porfolio.gabrielarojas.Entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
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
    @OneToOne(mappedBy = "domicilio")
    private Persona persona;


}
