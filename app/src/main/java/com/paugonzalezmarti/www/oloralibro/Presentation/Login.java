package com.paugonzalezmarti.www.oloralibro.Presentation;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.paugonzalezmarti.www.oloralibro.R;
import com.paugonzalezmarti.www.oloralibro.Utility.JsonManage;
import com.paugonzalezmarti.www.oloralibro.Utility.Usuari;

import java.util.ArrayList;

import static android.widget.Toast.LENGTH_SHORT;

public class Login extends Activity  {
    private final int REQUEST_ACCES_FINE = 0;

    @Override
    protected void onResume() {
        super.onResume();
        onCreate(null);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        //Instanciem els elements del login
        TextView registro = (TextView) findViewById(R.id.tvRegistro);
        final EditText usuario = findViewById(R.id.etCorreo);
        final EditText contrasenya = findViewById(R.id.etPassword);
        Button logearse = (Button) findViewById(R.id.btnLoguear);
        final ArrayList<Usuari> usuaris = JsonManage.recuperarUsuaris();
        //recuperem les dades de els usuaris per utilitzarlos despres

        //Forcem a demanar els permisos
        if (ActivityCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_ACCES_FINE);
        }
        if (ActivityCompat.checkSelfPermission(this,Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_ACCES_FINE);
        }
        if (ActivityCompat.checkSelfPermission(this,Manifest.permission.INTERNET)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.INTERNET}, REQUEST_ACCES_FINE);
        }
        if (ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_ACCES_FINE);
        }
        if (ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_NETWORK_STATE)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_NETWORK_STATE}, REQUEST_ACCES_FINE);
        }


        //Ens loguejarem
        logearse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = usuario.getText().toString();
                String pass = contrasenya.getText().toString();
                boolean correcto = false;
                boolean existe = false;
                boolean noexiste = false;
                int id = 0;

                if ((user.isEmpty() && (pass.isEmpty()))) {
                    Toast.makeText(Login.this, "Siusplau introdueix un usuari i una contrasenya", LENGTH_SHORT).show();

                } else if (user.isEmpty()) {
                    Toast.makeText(Login.this, "Siusplau introdueix un usuari", LENGTH_SHORT).show();

                } else if (pass.isEmpty()) {
                    Toast.makeText(Login.this, "Siusplau introdueix una contrasenya", LENGTH_SHORT).show();

                } else if((!pass.isEmpty())&&(!user.isEmpty())) {
                    int i = 0;
                    Usuari usuari= null;
                    for (Usuari item : usuaris) {
                        //mostrar que el usuari i o la contraseña es incorrecte
                        String iUsuari = item.getNomUsuari().toString();
                        String iContrasenya = item.getContrasenya().toString();
                        if ((user.equals(iUsuari)) && (pass.equals(iContrasenya))) {
                            correcto = true;
                            usuari = item;
                        }
                        if(user.equals(iUsuari)&&(!pass.equals(iContrasenya))){
                            existe=true;
                        }
                        if(!user.equals(iUsuari)&&(!pass.equals(iContrasenya))){
                            noexiste=true;
                        }
                        i++;
                    }

                    if (correcto==true) {
                        Intent menu = new Intent(Login.this, Menu.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("usuario",usuari);
                        menu.putExtras(bundle);
                        startActivity(menu);
                    }else if(existe==true) {
                        Toast.makeText(Login.this, "La contraseña es incorrecte", LENGTH_SHORT).show();
                    } else if(noexiste==true) {
                        Toast.makeText(Login.this, "El usuari no existex a la nostra base de dades", LENGTH_SHORT).show();
                    }
                }
            }
        });

        //Obrim la pagina de registre al polsar al text de registre.
        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registro = new Intent(Login.this,Registro.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("total",usuaris);
                registro.putExtras(bundle);
                startActivity(registro);
            }
        });
    }

    @Override //Metode per donar feedback de la request de permisos
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode,permissions, grantResults);
        if (requestCode == REQUEST_ACCES_FINE ) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this,"Permiso Concedido", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this,"Permiso Denegado", Toast.LENGTH_SHORT).show();

            }
        }
    }
}
