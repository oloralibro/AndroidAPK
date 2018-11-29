package com.paugonzalezmarti.www.oloralibro;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        //Instanciem els elements del login
        TextView registro = (TextView) findViewById(R.id.tvRegistro);
        EditText usuario = findViewById(R.id.etCorreo);
        EditText contrasenya = findViewById(R.id.etPassword);
        Button logearse = (Button) findViewById(R.id.btnLoguear);

        //Obrim la pagina de registre al polsar al text de registre.
        registro.setOnClickListener(this);

        //Ens loguejarem
        logearse.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
           case R.id.tvRegistro:
                Intent registro = new Intent(this,Registro.class);
                startActivity(registro);
                break;
           case R.id.btnLoguear:
                Intent menu = new Intent(this, Menu.class);
                startActivity(menu);
                break;
            default:
                break;
        }
    }
}
