package com.paugonzalezmarti.www.oloralibro;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ActivitatIndividual extends Activity{
    @Override
    protected void onResume() {
        super.onResume();
        onCreate(null);
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitat);

        final Bundle objetoEnviado = getIntent().getExtras();
        Usuari user = null;
        Activitat activitatSeleccionada = null;
        if (objetoEnviado != null) {
            activitatSeleccionada = (Activitat) objetoEnviado.getSerializable("activitat");
            user = (Usuari) objetoEnviado.getSerializable("usuario");
            ArrayList<Usuari> usersUpdate = JsonManage.recuperarUsuaris();
            //Actualitzem al usuari per si tingués algun canvi
            for (Usuari usuari : usersUpdate){
                if (usuari.getId() == user.getId()){
                    user=usuari;
                }
            }
            objetoEnviado.putSerializable("usuario", user);
        }


        final Button boto = findViewById(R.id.btn_Afegir_Activitat);
        ArrayList<Activitat> tot = user.getActivitats();
        for (Activitat item : tot){
            if (item.getId() == activitatSeleccionada.getId()){
                boto.setText("Activitat Feta");
                boto.setEnabled(false);
            }
        }


        TextView tvNombre = (TextView)findViewById(R.id.tv_Actividad_Nombre);
        TextView tvDescripcion = (TextView)findViewById(R.id.tv_Actividad_Descripcion);
        TextView tvUbicacion = (TextView)findViewById(R.id.tv_Actividad_Ubicacion);
        TextView tvPuntos = (TextView)findViewById(R.id.tv_Actividad_Puntos);

        tvNombre.setText(activitatSeleccionada.getNom());
        tvDescripcion.setText(activitatSeleccionada.getDescripcio());
        tvUbicacion.setText(activitatSeleccionada.getUbicacio());
        //todo Secondari pasar de int a string
        String puntitos = "" + activitatSeleccionada.getPunts();
        tvPuntos.setText(puntitos);
        final Activitat finalActivitatSeleccionada = activitatSeleccionada;
        final Usuari finalUser = user;
        boto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Activitat> lol = new ArrayList<>();
                ArrayList<Usuari> users = JsonManage.recuperarUsuaris();
                //busquem el usuari del array i el substituim
                for (Usuari item :users){
                    if (item.getId()==finalUser.getId()){
                        lol = item.getActivitats();
                        lol.add(finalActivitatSeleccionada);
                        item.setActivitats(lol);
                        int puntuacio = item.getPunts() + finalActivitatSeleccionada.getPunts();
                        item.setPunts(puntuacio);
                        boto.setText("Activitat Feta");
                        boto.setEnabled(false);
                    }
                }
                JsonManage.guardarUsuaris(users);
                Toast.makeText(ActivitatIndividual.this,"S'han guardat els canvis",Toast.LENGTH_SHORT).show();
            }
        });



    }
}
