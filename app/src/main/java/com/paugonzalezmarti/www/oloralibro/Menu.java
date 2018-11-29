package com.paugonzalezmarti.www.oloralibro;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button btnperfil = (Button) findViewById(R.id.btnPerfil);
        Button btnlibrerias = (Button) findViewById(R.id.btnLibrerias);
        Button btnactividades = (Button) findViewById(R.id.btnActividades);

        btnperfil.setOnClickListener(this);
        btnlibrerias.setOnClickListener(this);
        btnactividades.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnPerfil:
                Intent perfil = new Intent(this,Registro.class);
                startActivity(perfil);
                break;
            case R.id.btnLibrerias:
                Intent librerira = new Intent(this, BuscadorLibreria.class);
                startActivity(librerira);
                break;
            case R.id.btnActividades:
                Intent actividad = new Intent(this, BuscadorActividad.class);
                startActivity(actividad);
                break;
            default:
                break;
        }
    }
}
