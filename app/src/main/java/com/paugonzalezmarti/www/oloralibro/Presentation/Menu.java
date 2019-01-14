package com.paugonzalezmarti.www.oloralibro.Presentation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.paugonzalezmarti.www.oloralibro.R;
import com.paugonzalezmarti.www.oloralibro.Utility.Usuari;

public class Menu extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Usuari user = null;
        Button btnPerfil = (Button) findViewById(R.id.btnPerfil);
        Button btnLibrerias = (Button) findViewById(R.id.btnLibrerias);
        Button btnActividades = (Button) findViewById(R.id.btnActividades);

        final Bundle objetoEnviado = getIntent().getExtras();
        if (objetoEnviado != null) {
            user = (Usuari) objetoEnviado.getSerializable("usuario");
            objetoEnviado.putSerializable("usuario", user);
        }

        btnPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent perfil = new Intent(Menu.this, Perfil.class);
                perfil.putExtras(objetoEnviado);
                startActivity(perfil);
            }
        });

        btnLibrerias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent librerira = new Intent(Menu.this, BuscadorLibreria.class);
                librerira.putExtras(objetoEnviado);
                startActivity(librerira);
            }
        });

        btnActividades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent actividad = new Intent(Menu.this, BuscadorActividad.class);
                actividad.putExtras(objetoEnviado);
                startActivity(actividad);
            }
        });

    }
}
