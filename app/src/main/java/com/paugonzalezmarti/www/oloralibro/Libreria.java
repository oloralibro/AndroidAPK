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
    @SerializedName("horaApertura")
    private String horariApertura;
    @SerializedName("horaCierre")
    private String horariCierre;
    @SerializedName("numeroTelefono")
    private int telefon;
    @SerializedName("listaActividades")
    private ArrayList<Activitat> activitats;

    public Libreria(int id, String nom, String direccio, String horariApertura, String horariCierre, int telefon, ArrayList<Activitat> activitats) {
        this.id = id;
        this.nom = nom;
        this.direccio = direccio;
        this.horariApertura = horariApertura;
        this.horariCierre = horariCierre;
        this.telefon = telefon;
        this.activitats = activitats;
    }

    public String getHorariApertura() {
        return horariApertura;
    }

    public String getHorariCierre() {
        return horariCierre;
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
                ", horariApertura='" + horariApertura + '\'' +
                ", horariCierre='" + horariCierre + '\'' +
                ", telefon=" + telefon +
                ", activitats=" + activitats +
                '}';
    }
}
