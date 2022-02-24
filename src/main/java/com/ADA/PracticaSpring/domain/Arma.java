package com.ADA.PracticaSpring.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Arma {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idArma;

    private String nombreArma;
    private String daño;

    @OneToOne
    @JoinColumn(name = "idAdv")
    private Aventurero aventurero;

    public Arma() {
    }

    public Arma(long idArma, String nombreArma, String daño, Aventurero aventurero) {
        this.idArma = idArma;
        this.nombreArma = nombreArma;
        this.daño = daño;
        this.aventurero = aventurero;
    }

    public Arma(String nombreArma, String daño) {
        this.nombreArma = nombreArma;
        this.daño = daño;
    }

    public long getIdArma() {
        return idArma;
    }

    public void setIdArma(long idArma) {
        this.idArma = idArma;
    }

    public String getNombreArma() {
        return nombreArma;
    }

    public void setNombreArma(String nombreArma) {
        this.nombreArma = nombreArma;
    }

    public String getDaño() {
        return daño;
    }

    public void setDaño(String daño) {
        this.daño = daño;
    }

    public Aventurero getAventurero() {
        return aventurero;
    }

    public void setAventurero(Aventurero aventurero) {
        this.aventurero = aventurero;
    }

    @Override
    public String toString() {
        return "Arma [idArma= " + idArma + ", nombreArma= " + nombreArma + ", daño=" + daño + "]";
    }
}
