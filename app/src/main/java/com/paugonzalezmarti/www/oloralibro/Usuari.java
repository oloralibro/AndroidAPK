package com.paugonzalezmarti.www.oloralibro;

import java.util.ArrayList;

public class Usuari {
    private String nomUsuari;
    private String correu;
    private String contrasenya;
    private int punts;
    private ArrayList<Activitat> activitats;
    private boolean administrador;

    public Usuari(String nomUsuari, String correu, String contrasenya, int punts, ArrayList<Activitat> activitats, boolean administrador) {
        this.nomUsuari = nomUsuari;
        this.correu = correu;
        this.contrasenya = contrasenya;
        this.punts = punts;
        this.activitats = activitats;
        this.administrador = administrador;
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
    public String toString() {
        return "Usuari{" +
                "nomUsuari='" + nomUsuari + '\'' +
                ", correu='" + correu + '\'' +
                ", contrasenya='" + contrasenya + '\'' +
                ", punts=" + punts +
                ", activitats=" + activitats +
                ", administrador=" + administrador +
                '}';
    }
}
