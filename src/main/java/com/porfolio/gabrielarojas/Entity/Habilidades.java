package com.porfolio.gabrielarojas.Entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Habilidades {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String nombre_habilidad;
    private int porcentaje_adquirido;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_persona", nullable = false)
    private Persona persona;

}
