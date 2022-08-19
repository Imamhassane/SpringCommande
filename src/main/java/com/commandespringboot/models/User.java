package com.commandespringboot.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="user_type")
@DiscriminatorValue("ADMIN")
@AllArgsConstructor
@Getter
@Setter
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id ;

    @Column(nullable = false)
    protected String nom;

    @Column(nullable = false)
    protected  String prenom;

    @Column(nullable = false , unique = true)
    protected  String email;

    @Column(nullable = false)
    protected String password;

    @Column(nullable = false)
    protected String roles;

    public User() {
        this.roles =  "ROLE_ADMIN";
    }
}
