package com.paugonzalezmarti.www.oloralibro;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Perfil extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.perfil);
        TextView puntos = findViewById(R.id.tv_perfil_Puntos);
        TextView nombre = findViewById(R.id.tv_perfil_NameUser);
        TextView correu = findViewById(R.id.tv_perfil_Correo);

        Usuari user = null;
        final Bundle objetoEnviado = getIntent().getExtras();

        if (objetoEnviado!=null){
            user = (Usuari) objetoEnviado.getSerializable("usuario");
    //todo cal mirar perque no carega les dades i no deixa obrir la vista
        puntos.setText(user.getPunts());
        nombre.setText(user.getNomUsuari());
        correu.setText(user.getCorreu());
        }

    }
}
