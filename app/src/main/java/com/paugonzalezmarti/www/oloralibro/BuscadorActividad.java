package com.paugonzalezmarti.www.oloralibro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class BuscadorActividad extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buscador_activitats);
        Button buscar = findViewById(R.id.btnBuscarActivitat);
        final EditText actividad = (EditText)findViewById(R.id.etBuscadorActivitat);
        //Identificamos los elementos del layout
        ListView listActividades = findViewById(R.id.lv_buscador_Actividad);

        //Cargamos las actividades en un ArrayList.
        final ArrayList<Activitat> arrayActividades = JsonManage.recuperarActivitats();
        ArrayList<String> nombreActividades = new ArrayList<>();

        for (Activitat activitat : arrayActividades){
            nombreActividades.add(activitat.getNom().toString());
        }
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this,R.layout.simple_listview_personalitzada, nombreActividades);
        listActividades.setAdapter(adaptador);

//Evento para que se muestren los datos de la actividad seleccionada en la lista
        listActividades.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {

                //todo Secondari Fer que la funcio de mostrar la activitat sigui una funció statica per evitar la redundancia
                Intent mostrarActivitat = new Intent(BuscadorActividad.this, ActivitatIndividual.class);
                Activitat activitatSeleccionada = arrayActividades.get(i);
                final Bundle objetoEnviado = getIntent().getExtras();
                Usuari user = null;
                if (objetoEnviado != null) {
                    objetoEnviado.putSerializable("activitat", activitatSeleccionada);
                    user = (Usuari) objetoEnviado.getSerializable("usuario");
                    objetoEnviado.putSerializable("usuario", user);
                }

                mostrarActivitat.putExtras(objetoEnviado);
                startActivity(mostrarActivitat);
            }
        });

        // editText buscador
        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent buscarActividad = new Intent(BuscadorActividad.this,ActivitatIndividual.class);
                String nombreActividad = actividad.getText().toString();
                buscarActividad.putExtra("actividad", nombreActividad);

                startActivity(buscarActividad);
            }
        });


    }
}
