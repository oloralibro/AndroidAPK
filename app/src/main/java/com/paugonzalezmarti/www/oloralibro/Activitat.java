package com.paugonzalezmarti.www.oloralibro;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Activitat implements Serializable{
    @SerializedName("id")
    private int id;
    @SerializedName("nombre")
    private String nom;

    @SerializedName("direccion")
    private String ubicacio;
    @SerializedName("descripcion")
    private String descripcio;
    @SerializedName("puntos")
    private int punts;

    public Activitat(int id, String nom, String ubicacio, String descripcio, int punts) {
        this.id = id;
        this.nom = nom;
        this.ubicacio = ubicacio;
        this.descripcio = descripcio;
        this.punts = punts;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
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
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", ubicacio='" + ubicacio + '\'' +
                ", descripcio='" + descripcio + '\'' +
                ", punts=" + punts +
                '}';
    }
}
