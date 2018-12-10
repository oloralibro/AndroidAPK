package com.paugonzalezmarti.www.oloralibro;

import android.app.Activity;
import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends Activity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        //Instanciem els elements del login
        TextView registro = (TextView) findViewById(R.id.tvRegistro);
        final EditText usuario = findViewById(R.id.etCorreo);
        final EditText contrasenya = findViewById(R.id.etPassword);
        Button logearse = (Button) findViewById(R.id.btnLoguear);

        //recuperem les dades de els usuaris per utilitzarlos despres
        //todo hay que leer el los datos del fichero

        final Usuari[] usuaris = JsonManage.recuperarUsuaris();
        //Obrim la pagina de registre al polsar al text de registre.
       // registro.setOnClickListener(this);

        //Ens loguejarem
        logearse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = usuario.getText().toString();
                String pass = contrasenya.getText().toString();
                boolean correcto = false;
                boolean existe = false;
                boolean noexiste = false;
                if ((user.isEmpty() && (pass.isEmpty()))){
                    Toast.makeText(MainActivity.this, "Siusplau introdueix un usuari i una contrasenya", LENGTH_SHORT).show();

                }
                else if (user.isEmpty()){
                    Toast.makeText(MainActivity.this, "Siusplau introdueix un usuari", LENGTH_SHORT).show();

                }else if (pass.isEmpty()){
                    Toast.makeText(MainActivity.this, "Siusplau introdueix una contrasenya", LENGTH_SHORT).show();

                }else if((!pass.isEmpty())&&(!user.isEmpty())){
                    for (Usuari item : usuaris) {
                        //mostrar que el usuari i o la contraseña es incorrecte
                        String iUsuari = item.getNomUsuari().toString();
                        String iContrasenya = item.getContrasenya().toString();
                        if ((user.equals(iUsuari)) && (pass.equals(iContrasenya))) {
                            correcto = true;

                        }
                        if(user.equals(iUsuari)&&(!pass.equals(iContrasenya))){
                            existe=true;
                        }
                        if(!user.equals(iUsuari)&&(!pass.equals(iContrasenya))){
                            noexiste=true;
                        }
                    }

                    if (correcto==true){
                        Intent menu = new Intent(MainActivity.this, Menu.class);
                        startActivity(menu);
                    }else if(existe==true){
                        Toast.makeText(MainActivity.this, "La contraseña es incorrecte", LENGTH_SHORT).show();
                    } else if(noexiste==true){
                        Toast.makeText(MainActivity.this, "El usuari no existex a la nostra base de dades", LENGTH_SHORT).show();
                    }
                }

            }
        });
    }


   /* @Override
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
    }*/

}
