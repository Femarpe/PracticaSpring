package com.ADA.PracticaSpring.domain;

import javax.persistence.*;

@Entity
public class Aventurero {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idAdv;

    private String nombreAventurero;

    @OneToOne
    @JoinColumn(name = "idArma")
    private Arma arma;

    public Aventurero() {
    }

    public Aventurero(long idAdv, String nombreAventurero, Arma arma) {
        this.idAdv = idAdv;
        this.nombreAventurero = nombreAventurero;
        this.arma = arma;
    }

    public Aventurero(String nombreAventurero) {
        this.nombreAventurero = nombreAventurero;
    }

    public long getIdAdv() {
        return idAdv;
    }

    public void setIdAdv(long idAdv) {
        this.idAdv = idAdv;
    }

    public String getNombreAventurero() {
        return nombreAventurero;
    }

    public void setNombreAventurero(String nombreAventurero) {
        this.nombreAventurero = nombreAventurero;
    }

    public Arma getArma() {
        return arma;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }

    @Override
    public String toString() {
        return "Aventurero [idAventurero= " + idAdv + ", nombreAventurero= " + nombreAventurero + "]";
    }
}
