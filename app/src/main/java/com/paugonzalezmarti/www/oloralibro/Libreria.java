package com.paugonzalezmarti.www.oloralibro;

import java.util.ArrayList;

public class Libreria {
    private String nom;
    private String direccio;
    private String horais;
    private int telefon;
    private ArrayList<Activitat> activitats;

    public Libreria(String nom, String direccio, String horais, int telefon, ArrayList<Activitat> activitats) {
        this.nom = nom;
        this.direccio = direccio;
        this.horais = horais;
        this.telefon = telefon;
        this.activitats = activitats;
    }

    public String getNom() {
        return nom;
    }

    public String getDireccio() {
        return direccio;
    }

    public String getHorais() {
        return horais;
    }

    public int getTelefon() {
        return telefon;
    }

    public ArrayList<Activitat> getActivitats() {
        return activitats;
    }

    @Override
    public String toString() {
        return "Libreria{" +
                "nom='" + nom + '\'' +
                ", direccio='" + direccio + '\'' +
                ", horais='" + horais + '\'' +
                ", telefon=" + telefon +
                ", activitats=" + activitats +
                '}';
    }
}
