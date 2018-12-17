package com.paugonzalezmarti.www.oloralibro;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ActivitatIndividual extends Activity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitat);

        //todo Cal modificar el text de afegir activitat i desactivar el botó en cas de que la activitat estigui feta
        final Bundle objetoEnviado = getIntent().getExtras();
        Usuari user = null;
        Activitat activitatSeleccionada = null;
        if (objetoEnviado != null) {
            activitatSeleccionada = (Activitat) objetoEnviado.getSerializable("activitat");
            user = (Usuari) objetoEnviado.getSerializable("usuario");
            objetoEnviado.putSerializable("usuario", user);
        }
        Button boto = findViewById(R.id.btn_Afegir_Activitat);
        if(user.getActivitats().contains(activitatSeleccionada)){
            boto.setText("Activitat Feta");
            boto.setEnabled(false);
        }

        TextView tvNombre = (TextView)findViewById(R.id.tv_Actividad_Nombre);
        TextView tvDescripcion = (TextView)findViewById(R.id.tv_Actividad_Descripcion);
        TextView tvUbicacion = (TextView)findViewById(R.id.tv_Actividad_Ubicacion);
        TextView tvPuntos = (TextView)findViewById(R.id.tv_Actividad_Puntos);

        tvNombre.setText(activitatSeleccionada.getNom());
        tvDescripcion.setText(activitatSeleccionada.getDescripcio());
        tvUbicacion.setText(activitatSeleccionada.getUbicacio());
        String puntitos = "" + activitatSeleccionada.getPunts();
        tvPuntos.setText(puntitos);
        final Activitat finalActivitatSeleccionada = activitatSeleccionada;
        final Usuari finalUser = user;
        
        boto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //todo Cal afegir el objecte al usuari i guardar al finalitzar-ho per evitar problemes
                ArrayList<Activitat> lol = new ArrayList<>();
                lol.add(finalActivitatSeleccionada);
                ArrayList<Usuari> users = JsonManage.recuperarUsuaris();

                for (Usuari item :users){
                    if (item.getActivitats().contains(lol)){

                    }else{
                        finalUser.setActivitats(lol);
                        //todo cal substituir el usuari a traves de el id i comprovar que sigui correcta la comprovacio de la activitat

                    }
                }
            }
        });



    }
}
