package com.porfolio.gabrielarojas.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre_rol;
    @OneToOne(mappedBy = "rol")
    private Roles_Persona roles_persona;


}
