package com.porfolio.gabrielarojas.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Proyectos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre_proyecto;
    private Date fecha_realizacion;
    private String link;
    private String link_repositorio;
    private String descripcion;
    private String imagen_1;
    private String imagen_2;
    private String imagen_3;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_persona", nullable = false)
    private Persona persona;


}
