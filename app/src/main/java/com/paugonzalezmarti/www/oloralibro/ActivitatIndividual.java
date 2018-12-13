package com.paugonzalezmarti.www.oloralibro;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class ActivitatIndividual extends Activity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitat);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitat);

        Bundle extras = this.getIntent().getExtras();
        String nombre = extras.getString("actividad");

        ArrayList<Activitat> actividades = JsonManage.recuperarActivitats();
        Activitat actividadActual = null;

        for (int i = 0; i < actividades.size(); i++){
            if (actividades.get(i).getNom().equals(nombre)){
                actividadActual = actividades.get(i);
            }
        }

        TextView tvNombre = (TextView)findViewById(R.id.tv_Actividad_Nombre);
        tvNombre.setText(actividadActual.getNom());
        TextView tvDescripcion = (TextView)findViewById(R.id.tv_Actividad_Descripcion);
        tvDescripcion.setText(actividadActual.getDescripcio());
        TextView tvUbicacion = (TextView)findViewById(R.id.tv_Actividad_Ubicacion);
        //tvUbicacion.setText(actividadActual.getUbicacio());
        TextView tvPuntos = (TextView)findViewById(R.id.tv_Actividad_Puntos);
        //tvPuntos.setText(actividadActual.getPunts());
    }
}
