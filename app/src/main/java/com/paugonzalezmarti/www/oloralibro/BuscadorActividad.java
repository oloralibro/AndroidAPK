package com.paugonzalezmarti.www.oloralibro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class BuscadorActividad extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buscador_activitats);

        Button buscar = findViewById(R.id.btnBuscarActivitat);
        //ListView actividades = findViewById(R.id.lvActividades);
        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent buscarLibreria = new Intent(BuscadorActividad.this,LlibreriaIndividual.class);
                startActivity(buscarLibreria);
            }
        });

    }
}
