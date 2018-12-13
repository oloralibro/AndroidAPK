package com.paugonzalezmarti.www.oloralibro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class BuscadorLibreria extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buscador_librerias);
        ArrayList<Libreria> llibreries = JsonManage.recuperarLlibreries();
        Button buscar = findViewById(R.id.btnBuscarLibreria);
        ListView librerias = findViewById(R.id.lvLibreria);
        ArrayList<String> nombreLibreria = new ArrayList<>();
        for (Libreria libreria : llibreries){
            nombreLibreria.add(libreria.getNom().toString());
        }
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this,R.layout.simple_listview_personalitzada, nombreLibreria);
        librerias.setAdapter(adaptador);
        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent buscarLibreria = new Intent(BuscadorLibreria.this, LlibreriaIndividual.class);
                startActivity(buscarLibreria);
            }
        });

    }
}
