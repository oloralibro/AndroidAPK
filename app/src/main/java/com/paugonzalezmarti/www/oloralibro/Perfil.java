package com.paugonzalezmarti.www.oloralibro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
        final ArrayList<Usuari> usersUpdate = JsonManage.recuperarUsuaris();
        final ArrayList<Activitat> arrayActividades = JsonManage.recuperarActivitats();

        if (objetoEnviado!=null){
            user = (Usuari) objetoEnviado.getSerializable("usuario");
            //Actualitzem al usuari per si tingués algun canvi
            for (Usuari usuari : usersUpdate){
                if (usuari.getId()==user.getId()){
                    user=usuari;
                }
            }
        }
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

        llista.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                Intent mostrarActivitat = new Intent(Perfil.this, ActivitatIndividual.class);
                final Bundle objetoEnviado = getIntent().getExtras();
                Usuari user = null;
                if (objetoEnviado != null) {
                    user = (Usuari) objetoEnviado.getSerializable("usuario");
                    //Actualitzem al usuari per si tingués algun canvi
                    for (Usuari usuari : usersUpdate){
                        if (usuari.getId() == user.getId()){
                            user = usuari;
                        }
                    }
                    ArrayList<Activitat> mostrades = user.getActivitats();
                    Activitat activitatSeleccionada = mostrades.get(i);

                    objetoEnviado.putSerializable("activitat", activitatSeleccionada);
                    objetoEnviado.putSerializable("usuario", user);
                }

                mostrarActivitat.putExtras(objetoEnviado);
                startActivity(mostrarActivitat);
            }
        });
    }
}

