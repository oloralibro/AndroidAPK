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
        Button btnPerfil = (Button) findViewById(R.id.btnPerfil);
        Button btnLibrerias = (Button) findViewById(R.id.btnLibrerias);
        Button btnActividades = (Button) findViewById(R.id.btnActividades);

        btnPerfil.setOnClickListener(this);
        btnLibrerias.setOnClickListener(this);
        btnActividades.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        try{
            switch (view.getId()) {
                case R.id.btnPerfil:
                    Intent perfil = new Intent(this, Perfil.class);
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
        }catch(Exception e){

        }
    }
}
