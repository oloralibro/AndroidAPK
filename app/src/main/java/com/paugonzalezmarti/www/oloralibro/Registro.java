package com.paugonzalezmarti.www.oloralibro;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Registro extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro);
        //Instanciem els elements del Registre
        EditText usuario = findViewById(R.id.etNombre);
        EditText correo = findViewById(R.id.etCorreo);
        EditText contrasenya = findViewById(R.id.etPassword);
        EditText recontrasenya = findViewById(R.id.etConfirmPassword);
        Button registro = findViewById(R.id.btnRegistrar);
        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        });

    }


}
