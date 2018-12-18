package com.paugonzalezmarti.www.oloralibro;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class Libreria implements Serializable {
    @SerializedName("latitud")
    private float latitud;
    @SerializedName("longitud")
    private float longitud;
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

    public Libreria(int id, String nom, float latitud, float longitud, String direccio, String horariApertura, String horariCierre, int telefon, ArrayList<Activitat> activitats) {
        this.id = id;
        this.nom = nom;
        this.latitud = latitud;
        this.longitud = longitud;
        this.direccio = direccio;
        this.horariApertura = horariApertura;
        this.horariCierre = horariCierre;
        this.telefon = telefon;
        this.activitats = activitats;
    }

    public float getLatitud() {
        return latitud;
    }

    public float getLongitud() {
        return longitud;
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
                ", latitud=" + latitud +
                ", longitud=" + longitud +
                ", direccio='" + direccio + '\'' +
                ", horariApertura='" + horariApertura + '\'' +
                ", horariCierre='" + horariCierre + '\'' +
                ", telefon=" + telefon +
                ", activitats=" + activitats +
                '}';
    }
}
