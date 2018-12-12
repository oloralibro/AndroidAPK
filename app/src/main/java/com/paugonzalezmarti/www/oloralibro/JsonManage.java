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

    //<editor-fold desc="Usuaris">
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
    //</editor-fold>

    //<editor-fold desc="Librerias">
    public static ArrayList<Libreria> recuperarLlibreries() {
        String state = Environment.getExternalStorageState();
        Gson general = new Gson();
        String json = null;
        ArrayList<Libreria> libreria = new ArrayList<Libreria>();
        if (!(state.equals(Environment.MEDIA_MOUNTED))) {
        } else {
            BufferedReader reader = null;
            try {
                File file = Environment.getExternalStorageDirectory();
                File textFile = new File(file.getAbsolutePath() + File.separator + "LibreriasRegistradas.json");
                reader = new BufferedReader(new FileReader(textFile));
                StringBuilder textBuilder = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    textBuilder.append(line);
                    textBuilder.append("\n");
                    json = textBuilder.toString();
                }
                Libreria[] usuaris = general.fromJson(json, Libreria[].class);
                for(Libreria u : usuaris){
                    libreria.add(u);
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

        return libreria;
    }

    public static void guardarLlibreries(ArrayList<Libreria> users) {
        Gson general = new Gson();
        String resposta = general.toJson(users);
        String state = Environment.getExternalStorageState();
        String json = null;
        if (!(state.equals(Environment.MEDIA_MOUNTED))) {
        } else {
            BufferedWriter writer = null;
            try {
                File file = Environment.getExternalStorageDirectory();
                File textFile = new File(file.getAbsolutePath() + File.separator + "LibreriasRegistradas.json");
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
    //</editor-fold>

    //<editor-fold desc="Activitats" >
    public static ArrayList<Activitat> recuperarActivitats() {
        String state = Environment.getExternalStorageState();
        Gson general = new Gson();
        String json = null;
        ArrayList<Activitat> user = new ArrayList<Activitat>();
        if (!(state.equals(Environment.MEDIA_MOUNTED))) {
        } else {
            BufferedReader reader = null;
            try {
                File file = Environment.getExternalStorageDirectory();
                File textFile = new File(file.getAbsolutePath() + File.separator + "ActividadesRegistradas.json");
                reader = new BufferedReader(new FileReader(textFile));
                StringBuilder textBuilder = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    textBuilder.append(line);
                    textBuilder.append("\n");
                    json = textBuilder.toString();
                }
                Activitat[] usuaris = general.fromJson(json, Activitat[].class);
                for(Activitat u : usuaris){
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

    public static void guardarActivitats(ArrayList<Activitat> users) {
        Gson general = new Gson();
        String resposta = general.toJson(users);
        String state = Environment.getExternalStorageState();
        String json = null;
        if (!(state.equals(Environment.MEDIA_MOUNTED))) {
        } else {
            BufferedWriter writer = null;
            try {
                File file = Environment.getExternalStorageDirectory();
                File textFile = new File(file.getAbsolutePath() + File.separator + "ActividadesRegistradas.json");
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
    //</editor-fold>

}
