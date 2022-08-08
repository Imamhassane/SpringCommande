package com.commandespringboot.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Adresse {
    private String ville;
    private String quartier;

    @Override
    public String toString() {
        return "Adresse{" +
                "ville='" + ville + '\'' +
                ", quartier='" + quartier + '\'' +
                '}';
    }
}
