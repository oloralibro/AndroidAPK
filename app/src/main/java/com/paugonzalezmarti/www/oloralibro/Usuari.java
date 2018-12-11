package com.paugonzalezmarti.www.oloralibro;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class Usuari implements Serializable{
    @SerializedName("id")
    private int id;
    @SerializedName("nombre")
    private String nomUsuari;
    @SerializedName("correoElectronico")
    private String correu;
    @SerializedName("contraseña")
    private String contrasenya;
    @SerializedName("puntuacionTotal")
    private int punts;
    @SerializedName("listaActividades")
    private ArrayList<Activitat> activitats;
    @SerializedName("superUsuario")
    private boolean administrador;

    public Usuari(int id, String nomUsuari, String correu, String contrasenya, int punts, ArrayList<Activitat> activitats, boolean administrador) {
        this.id = id;
        this.nomUsuari = nomUsuari;
        this.correu = correu;
        this.contrasenya = contrasenya;
        this.punts = punts;
        this.activitats = activitats;
        this.administrador = administrador;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomUsuari() {
        return nomUsuari;
    }

    public void setNomUsuari(String nomUsuari) {
        this.nomUsuari = nomUsuari;
    }

    public String getCorreu() {
        return correu;
    }

    public void setCorreu(String correu) {
        this.correu = correu;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public int getPunts() {
        return punts;
    }

    public void setPunts(int punts) {
        this.punts = punts;
    }

    public ArrayList<Activitat> getActivitats() {
        return activitats;
    }

    public void setActivitats(ArrayList<Activitat> activitats) {
        this.activitats = activitats;
    }

    public boolean isAdministrador() {
        return administrador;
    }

    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Usuari{" +
                "id='" + id +
                ", nomUsuari='" + nomUsuari + '\'' +
                ", correu='" + correu + '\'' +
                ", contrasenya='" + contrasenya + '\'' +
                ", punts=" + punts +
                ", activitats=" + activitats +
                ", administrador=" + administrador +
                '}';
    }
}
