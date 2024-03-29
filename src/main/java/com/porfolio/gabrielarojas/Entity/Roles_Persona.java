package com.porfolio.gabrielarojas.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Roles_Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="fk_persona")
    private Persona persona;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="fk_rol")
    private Roles rol;




}
