package com.commandespringboot.models;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("CLIENT")
@AllArgsConstructor
@Getter
@Setter
public class Client extends User {

    @Column(nullable = true)
    private int numero;

    @Embedded
    private Adresse adresse;

    @OneToMany(mappedBy = "client")
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
                ", userName='" + email + '\'' +
                ", password='" + password + '\'' +
                ", roles='" + roles + '\'' +
                '}';
    }
    public Client() {
        this.roles =  "ROLE_CLIENT";
    }
}
