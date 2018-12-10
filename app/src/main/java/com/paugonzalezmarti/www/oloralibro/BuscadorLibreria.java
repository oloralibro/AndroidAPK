package com.paugonzalezmarti.www.oloralibro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class BuscadorLibreria extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buscador_librerias);

        Button buscar = findViewById(R.id.btnBuscarLibreria);
        //ListView librerias = findViewById(R.id.lvLibreria);
        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent buscarLibreria = new Intent(BuscadorLibreria.this,LlibreriaIndividual.class);
                startActivity(buscarLibreria);
            }
        });

    }
}
