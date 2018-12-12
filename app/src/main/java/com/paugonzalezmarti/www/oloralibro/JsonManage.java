package com.paugonzalezmarti.www.oloralibro;

import android.Manifest;
import android.app.Activity;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class JsonManage {

    public static ArrayList<Usuari> recuperarUsuaris() {
        String state = Environment.getExternalStorageState();
        Gson general = new Gson();
        String json = null;
        ArrayList<Usuari> user = new ArrayList<Usuari>();
        if (!(state.equals(Environment.MEDIA_MOUNTED))) {
        } else {
            BufferedReader reader = null;
            try {
                File file = Environment.getExternalStorageDirectory();
                File textFile = new File(file.getAbsolutePath() + File.separator + "UsuariosRegistrados.json");
                reader = new BufferedReader(new FileReader(textFile));
                StringBuilder textBuilder = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    textBuilder.append(line);
                    textBuilder.append("\n");
                    json = textBuilder.toString();
                }
               Usuari[] usuaris = general.fromJson(json, Usuari[].class);
                for(Usuari u : usuaris){
                    user.add(u);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        }

        return user;
    }

    public static void guardarUsuaris(ArrayList<Usuari> users) {
        Gson general = new Gson();
        String resposta = general.toJson(users);
        String state = Environment.getExternalStorageState();
        String json = null;
        Usuari[] user = new Usuari[0];
        if (!(state.equals(Environment.MEDIA_MOUNTED))) {
        } else {
            BufferedWriter writer = null;
            try {
                File file = Environment.getExternalStorageDirectory();
                File textFile = new File(file.getAbsolutePath() + File.separator + "UsuariosRegistrados.json");
                writer = new BufferedWriter(new FileWriter(textFile));
                writer.write(resposta);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (writer != null) {
                    try {
                        writer.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
  /*  public static Libreria[] recuperarLlibrerias(String json){
        String state = Environment.getExternalStorageState();
        Gson recuperarllibreria = new Gson();
        String jason = null;
        Libreria[] libreria = new Libreria[0];
        if (!(state.equals(Environment.MEDIA_MOUNTED))) {
        } else {
            BufferedReader reader = null;
            try {
                File file = Environment.getExternalStorageDirectory();
                File textFile = new File(file.getAbsolutePath()+File.separator + "LibreriasRegistrados.json");
                reader = new BufferedReader(new FileReader(textFile));
                StringBuilder textBuilder = new StringBuilder();
                String line;
                while((line = reader.readLine()) != null) {
                    textBuilder.append(line);
                    textBuilder.append("\n");
                    json = textBuilder.toString();
                }
                libreria = recuperarllibreria.fromJson(jason, Libreria[].class);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            finally{
                if(reader != null){
                    try {
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
        return libreria;
    }
    public static String guardarLlibreria(Libreria libreria){
        Gson general = new Gson();
        String resposta = general.toJson(libreria);
        return resposta;
    }
    public static Activitat[] recuperarActivitats(String json){
        String state = Environment.getExternalStorageState();
        Gson general = new Gson();
        String jason = null;
        Activitat[] activitat = new Activitat[0];
        if (!(state.equals(Environment.MEDIA_MOUNTED))) {
        } else {
            BufferedReader reader = null;
            try {
                File file = Environment.getExternalStorageDirectory();
                File textFile = new File(file.getAbsolutePath()+File.separator + "ActividadesRegistrados.json");
                reader = new BufferedReader(new FileReader(textFile));
                StringBuilder textBuilder = new StringBuilder();
                String line;
                while((line = reader.readLine()) != null) {
                    textBuilder.append(line);
                    textBuilder.append("\n");
                    json = textBuilder.toString();
                }
                activitat = general.fromJson(jason, Activitat[].class);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            finally{
                if(reader != null){
                    try {
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
        return activitat;
    }
    public static String guardarActivitat(Activitat activitat){
        Gson general = new Gson();
        String resposta = general.toJson(activitat);
        return resposta;
    }
    */

}
