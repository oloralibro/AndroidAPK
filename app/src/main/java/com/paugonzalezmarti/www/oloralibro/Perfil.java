package com.paugonzalezmarti.www.oloralibro;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Perfil extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.perfil);
        TextView puntos = findViewById(R.id.tv_perfil_Puntos);
        TextView nombre = findViewById(R.id.tv_perfil_NameUser);
        TextView correu = findViewById(R.id.tv_perfil_Correo);
        TextView contra = findViewById(R.id.tv_perfil_Password);
        ArrayList<String> nombreActividades = new ArrayList<>();
        ListView llista = findViewById(R.id.lv_perfil_Actividades);
        CheckBox tick = findViewById(R.id.cb_perfil_SuperUser);

        Usuari user = null;
        final Bundle objetoEnviado = getIntent().getExtras();

        if (objetoEnviado!=null){
            user = (Usuari) objetoEnviado.getSerializable("usuario");
            puntos.setText(""+ user.getPunts());
            nombre.setText(user.getNomUsuari().toUpperCase());
            correu.setText(user.getCorreu());
            String paswd = user.getContrasenya();
            char[] nice = paswd.toCharArray();
            if (user.isAdministrador()== true){
                tick.setChecked(true);
            }
            for (int i=0; i < (user.getContrasenya().length() - 3); i++){
                nice[i]='*';
            }
            paswd = String.valueOf(nice);
            contra.setText(paswd);
            for (Activitat activitat : user.getActivitats()){
                nombreActividades.add(activitat.getNom().toString());
            }
            ArrayAdapter<String> adaptador = new ArrayAdapter<>(this,R.layout.simple_listview_personalitzada, nombreActividades);
            llista.setAdapter(adaptador);
            //todo Cal fer que al polsar la activitat te la mostri

        }

    }
}
