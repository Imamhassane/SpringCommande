package com.commandespringboot.models;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("CLIENT")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Client extends User {

    @Column(nullable = true)
    private int numero;

    @Embedded
    private Adresse adresse;

    @OneToMany
    @JoinColumn(name = "client")
    private List<Commande> commandes = new ArrayList<>();

    @Override
    public String toString() {
        return "Client{" +
                "numero=" + numero +
                ", adresse=" + adresse +
                ", commandes=" + commandes +
                ", id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", roles='" + roles + '\'' +
                '}';
    }
}
