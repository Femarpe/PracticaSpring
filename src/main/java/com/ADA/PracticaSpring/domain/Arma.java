package com.ADA.PracticaSpring.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "arma")
public class Arma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idArma;

    private String nombreArma;
    private String danyo;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "arma")
    private Aventurero aventurero;

    public Arma() {
    }

    public Arma(long idArma, String nombreArma, String danyo, Aventurero aventurero) {
        this.idArma = idArma;
        this.nombreArma = nombreArma;
        this.danyo = danyo;
        this.aventurero = aventurero;
    }

    public Arma(String nombreArma, String danyo) {
        this.nombreArma = nombreArma;
        this.danyo = danyo;
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

    public String getDanyo() {
        return danyo;
    }

    public void setDanyo(String danyo) {
        this.danyo = danyo;
    }

    public Aventurero getAventurero() {
        return aventurero;
    }

    public void setAventurero(Aventurero aventurero) {
        this.aventurero = aventurero;
    }

    @Override
    public String toString() {
        return "Arma [idArma= " + idArma + ", nombreArma= " + nombreArma + ", daño=" + danyo + "]";
    }
}
