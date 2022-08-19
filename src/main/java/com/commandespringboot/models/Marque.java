package com.commandespringboot.models;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Marque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(nullable = false)
    private String  nom;

    @OneToMany(mappedBy = "marque")
    private List<Boisson> boissons = new ArrayList<>();

    public Marque(String nom){
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Marque{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }
}
