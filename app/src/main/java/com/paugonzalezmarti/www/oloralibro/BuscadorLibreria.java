package com.paugonzalezmarti.www.oloralibro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BuscadorLibreria extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buscador_librerias);
        Button buscar = findViewById(R.id.btnBuscarLibreria);
        final ListView listLibrerias = findViewById(R.id.lvLibreria);
        final ArrayList<Libreria> llibreries = JsonManage.recuperarLlibreries();
        ArrayList<String> nombreLibreria = new ArrayList<>();
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
                Libreria llibreriaSeleccionada = llibreries.get(i);
                Bundle bundle = new Bundle();
                bundle.putSerializable("libreria", llibreriaSeleccionada);
                mostrarActivitat.putExtras(bundle);

                startActivity(mostrarActivitat);
            }
        });
        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText buscador = findViewById(R.id.etBuscadorLibreria);
                ListView libreias = findViewById(R.id.lvLibreria);
                ArrayList<Libreria> llibreries = JsonManage.recuperarLlibreries();
                ArrayList<String> nombreLibreria = new ArrayList<>();
                String nom = buscador.getText().toString();

                for (Libreria libreria : llibreries){
                    if (libreria.getNom().toString().contains(nom))
                        nombreLibreria.add(libreria.getNom().toString());
                }

                ArrayAdapter<String> adaptador = new ArrayAdapter<>(BuscadorLibreria.this, R.layout.simple_listview_personalitzada,nombreLibreria);
                libreias.setAdapter(adaptador);
                Toast.makeText(BuscadorLibreria.this,"se han recargado las librerias",Toast.LENGTH_SHORT);
            }
        });

    }
}
