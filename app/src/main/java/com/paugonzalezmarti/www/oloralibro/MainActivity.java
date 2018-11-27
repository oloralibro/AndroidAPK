package com.paugonzalezmarti.www.oloralibro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        TextView registro = findViewById(R.id.tvRegistro);
        EditText usuario = findViewById(R.id.etCorreo);
        EditText contrasenya = findViewById(R.id.etPassword);
        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.registro);
            }
        });
    }

}
