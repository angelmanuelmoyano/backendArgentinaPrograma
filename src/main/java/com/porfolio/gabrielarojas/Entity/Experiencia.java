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
public class Experiencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre_empresa;
    private String puesto;
    private Date fecha_inicio;
    private Date fecha_fin;
    private int telefono;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_persona", nullable = false)
    private Persona persona;

}
