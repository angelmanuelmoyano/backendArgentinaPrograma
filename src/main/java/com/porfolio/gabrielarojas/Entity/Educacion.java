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
public class Educacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre_institucion;
    private String carrera;
    private Date fecha_inicio;
    private Date fecha_fin;
    private String logo_institucion;
    private String titulo;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_persona", nullable = false)
    private Persona persona;
}
