package com.paugonzalezmarti.www.oloralibro;

import android.os.Environment;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class JsonManage {

    public static Usuari[] recuperarUsuaris(){
        String state = Environment.getExternalStorageState();
        Gson general = new Gson();
        String json = null;
        Usuari[] user = new Usuari[0];
        if (!(state.equals(Environment.MEDIA_MOUNTED))) {
        } else {
            BufferedReader reader = null;
            try {
                File file = Environment.getExternalStorageDirectory();
                File textFile = new File(file.getAbsolutePath()+File.separator + "UsuariosRegistrados.json");
                reader = new BufferedReader(new FileReader(textFile));
                StringBuilder textBuilder = new StringBuilder();
                String line;
                while((line = reader.readLine()) != null) {
                    textBuilder.append(line);
                    textBuilder.append("\n");
                    json = textBuilder.toString();
                }
                user = general.fromJson(json, Usuari[].class);

            } catch (FileNotFoundException e) {
                // TODO: handle exception
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            finally{
                if(reader != null){
                    try {
                        reader.close();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }

        }

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
