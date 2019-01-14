package com.paugonzalezmarti.www.oloralibro.Presentation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.paugonzalezmarti.www.oloralibro.R;
import com.paugonzalezmarti.www.oloralibro.Utility.JsonManage;
import com.paugonzalezmarti.www.oloralibro.Utility.Libreria;
import com.paugonzalezmarti.www.oloralibro.Utility.Usuari;

import java.util.ArrayList;

public class BuscadorLibreria extends Activity {
    private ArrayList<String> nombreLibreria;
    private Bundle objetoEnviado;
    private Usuari user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buscador_librerias);
        Button buscar = findViewById(R.id.btnBuscarLibreria);
        final ListView listLibrerias = findViewById(R.id.lvLibreria);
        final ArrayList<Libreria> llibreries = JsonManage.recuperarLlibreries();
        final ArrayList<Usuari> usersUpdate = JsonManage.recuperarUsuaris();
        objetoEnviado = getIntent().getExtras();

        if (objetoEnviado != null) {
            user = (Usuari) objetoEnviado.getSerializable("usuario");
            //Actualitzem al usuari per si tingués algun canvi
            for (Usuari usuari : usersUpdate) {
                if (usuari.getId() == user.getId()) {
                    user = usuari;
                }
            }
        }
        nombreLibreria = new ArrayList<>();
        for (Libreria libreria : llibreries){
            nombreLibreria.add(libreria.getNom().toString());
        }
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this,R.layout.simple_listview_personalitzada, nombreLibreria);
        listLibrerias.setAdapter(adaptador);

        //Evento para que se muestren los datos de la actividad seleccionada en la lista
        listLibrerias.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                Intent mostrarActivitat = new Intent(BuscadorLibreria.this, LlibreriaIndividual.class);
                String nomseleccionat = nombreLibreria.get(i);
                Libreria llibreriaSeleccionada = null;
                for (Libreria item : llibreries){
                    if (item.getNom().equals(nomseleccionat)){
                         llibreriaSeleccionada = item;
                    }
                }
                objetoEnviado.putSerializable("libreria", llibreriaSeleccionada);
                mostrarActivitat.putExtras(objetoEnviado);

                startActivity(mostrarActivitat);
            }
        });
        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText buscador = findViewById(R.id.etBuscadorLibreria);
                ListView libreias = findViewById(R.id.lvLibreria);
                ArrayList<Libreria> llibreries = JsonManage.recuperarLlibreries();
                nombreLibreria = new ArrayList<>();
                String nom = buscador.getText().toString();


                for (Libreria libreria : llibreries){
                    if (libreria.getNom().toString().contains(nom))
                        nombreLibreria.add(libreria.getNom());
                }

                ArrayAdapter<String> adaptador = new ArrayAdapter<>(BuscadorLibreria.this, R.layout.simple_listview_personalitzada,nombreLibreria);
                libreias.setAdapter(adaptador);
                Toast.makeText(BuscadorLibreria.this,"se han recargado las librerias",Toast.LENGTH_SHORT);
            }
        });

    }
}
