package com.paugonzalezmarti.www.oloralibro;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class Libreria implements Serializable {
    @SerializedName("id")
    private int id;
    @SerializedName("nombre")
    private String nom;
    @SerializedName("direccion")
    private String direccio;
    @SerializedName("horario")
    private String horais;
    @SerializedName("numeroTelefono")
    private int telefon;
    @SerializedName("listaActividades")
    private ArrayList<Activitat> activitats;

    public Libreria(int id, String nom, String direccio, String horais, int telefon, ArrayList<Activitat> activitats) {
        this.id = id;
        this.nom = nom;
        this.direccio = direccio;
        this.horais = horais;
        this.telefon = telefon;
        this.activitats = activitats;
    }

    public int getId() {
        return id;
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
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", direccio='" + direccio + '\'' +
                ", horais='" + horais + '\'' +
                ", telefon=" + telefon +
                ", activitats=" + activitats +
                '}';
    }
}
