package com.commandespringboot.models;

import lombok.*;

import javax.persistence.*;

@Entity
@DiscriminatorValue("LIVREUR")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Livreur extends User{

    private String etat;
}
