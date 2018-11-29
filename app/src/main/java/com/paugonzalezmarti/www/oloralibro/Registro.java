package com.paugonzalezmarti.www.oloralibro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Registro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro);
        //Instanciem els elements del Registre
        EditText usuario = findViewById(R.id.etNombre);
        EditText correo = findViewById(R.id.etCorreo);
        EditText contrasenya = findViewById(R.id.etPassword);
        EditText recontrasenya = findViewById(R.id.etConfirmPassword);
        Intent intent = getIntent();

    }


}
