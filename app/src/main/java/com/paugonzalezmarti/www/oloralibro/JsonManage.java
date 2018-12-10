package com.paugonzalezmarti.www.oloralibro;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;

public class JsonManage {

    public static Usuari[] recuperarUsuaris(String json){
        Gson general = new Gson();
        ArrayList<Usuari> usuarios;

        Usuari[] user = general.fromJson(json, Usuari[].class);
        return user;
    }
    public static String guardarUsuari(Usuari user){
        Gson general = new Gson();
        String resposta = general.toJson(user);
        return resposta;
    }
    public static Libreria[] recuperarLlibrerias(String json){
        Gson general = new Gson();
        Libreria[] libreria = general.fromJson(json, Libreria[].class);
        return libreria;
    }
    public static String guardarLlibreria(Libreria libreria){
        Gson general = new Gson();
        String resposta = general.toJson(libreria);
        return resposta;
    }
    public static Activitat[] recuperarActivitats(String json){
        Gson general = new Gson();
        Activitat[] activitat = general.fromJson(json, Activitat[].class);
        return activitat;
    }
    public static String guardarActivitat(Activitat activitat){
        Gson general = new Gson();
        String resposta = general.toJson(activitat);
        return resposta;
    }

}
