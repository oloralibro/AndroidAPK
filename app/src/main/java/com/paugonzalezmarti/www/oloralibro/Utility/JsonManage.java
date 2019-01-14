package com.paugonzalezmarti.www.oloralibro.Utility;

import android.os.Environment;

import com.google.gson.Gson;

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
    //Capturem els usuaris que hi ha al respectiu arxiu JSON
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
                //Tot i que no hauria, pot ser que el JSON vingui amb més d'una linea i ho controlem aqui
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

    //Guardem el llistat amb tots els usuaris al fitxer JSON
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
    //Capturem les llibreries que hi ha al respectiu arxiu JSON
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
                //Tot i que no hauria, pot ser que el JSON vingui amb més d'una linea i ho controlem aqui
                while ((line = reader.readLine()) != null) {
                    textBuilder.append(line);
                    textBuilder.append("\n");
                    json = textBuilder.toString();
                }
                Libreria[] llibreries = general.fromJson(json, Libreria[].class);
                for(Libreria u : llibreries){
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

    //Guardem el llistat amb totes les llibreries al fitxer JSON
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
    //Capturem les activitats que hi ha al respectiu arxiu JSON
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
                //Tot i que no hauria, pot ser que el JSON vingui amb més d'una linea i ho controlem aqui
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

    //Guardem el llistat amb totes les activitats al fitxer JSON
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
