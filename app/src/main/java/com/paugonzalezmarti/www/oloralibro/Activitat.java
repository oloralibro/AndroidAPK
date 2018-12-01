package com.paugonzalezmarti.www.oloralibro;

public class Activitat {
    private String nom;
    private String tipus;
    private String ubicacio;
    private String descripcio;
    private int punts;

    public Activitat(String nom, String tipus, String ubicacio, String descripcio, int punts) {
        this.nom = nom;
        this.tipus = tipus;
        this.ubicacio = ubicacio;
        this.descripcio = descripcio;
        this.punts = punts;
    }

    public String getNom() {
        return nom;
    }

    public String getTipus() {
        return tipus;
    }

    public String getUbicacio() {
        return ubicacio;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public int getPunts() {
        return punts;
    }

    @Override
    public String toString() {
        return "Activitat{" +
                "nom='" + nom + '\'' +
                ", tipus='" + tipus + '\'' +
                ", ubicacio='" + ubicacio + '\'' +
                ", descripcio='" + descripcio + '\'' +
                ", punts=" + punts +
                '}';
    }
}
