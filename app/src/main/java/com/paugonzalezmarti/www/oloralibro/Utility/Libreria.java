package com.paugonzalezmarti.www.oloralibro.Utility;

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
    @SerializedName("horario")
    private String horari;
    @SerializedName("numeroTelefono")
    private int telefon;
    @SerializedName("listaActividades")
    private ArrayList<Activitat> activitats;

    public Libreria(float latitud, float longitud, int id, String nom, String direccio, String horari, int telefon, ArrayList<Activitat> activitats) {
        this.latitud = latitud;
        this.longitud = longitud;
        this.id = id;
        this.nom = nom;
        this.direccio = direccio;
        this.horari = horari;
        this.telefon = telefon;
        this.activitats = activitats;
    }

    public float getLatitud() {
        return latitud;
    }

    public void setLatitud(float latitud) {
        this.latitud = latitud;
    }

    public float getLongitud() {
        return longitud;
    }

    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDireccio() {
        return direccio;
    }

    public void setDireccio(String direccio) {
        this.direccio = direccio;
    }

    public String getHorari() {
        return horari;
    }

    public void setHorari(String horari) {
        this.horari = horari;
    }

    public int getTelefon() {
        return telefon;
    }

    public void setTelefon(int telefon) {
        this.telefon = telefon;
    }

    public ArrayList<Activitat> getActivitats() {
        return activitats;
    }

    public void setActivitats(ArrayList<Activitat> activitats) {
        this.activitats = activitats;
    }
}
