package com.paugonzalezmarti.www.oloralibro.Presentation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.paugonzalezmarti.www.oloralibro.R;
import com.paugonzalezmarti.www.oloralibro.Utility.JsonManage;
import com.paugonzalezmarti.www.oloralibro.Utility.Usuari;

import java.util.ArrayList;

import static android.widget.Toast.LENGTH_SHORT;

public class Registro extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro);
        //Instanciem els elements del Registre
        final EditText usuario = findViewById(R.id.etNombre);
        final EditText correo = findViewById(R.id.etCorreo);
        final EditText contrasenya = findViewById(R.id.etPassword);
        final EditText recontrasenya = findViewById(R.id.etConfirmPassword);

        Button registro = findViewById(R.id.btnRegistrar);
        ArrayList<Usuari> total = null;
        final Bundle objetoEnviado = getIntent().getExtras();

        if (objetoEnviado != null) {
            total = (ArrayList<Usuari>) objetoEnviado.getSerializable("total");
        }

        final ArrayList<Usuari> finalTotal = total;
        //Validara les dades i crearà un usuari
        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Usuari user = null;
                Boolean existe = false;
                String nomusuari = usuario.getText().toString();
                String email = correo.getText().toString();
                String contra = contrasenya.getText().toString();
                String recontra = recontrasenya.getText().toString();

                //Control d'errors
                if ((nomusuari.isEmpty() && (contra.isEmpty()))) {
                    Toast.makeText(Registro.this, "Siusplau introdueix un usuari i una contrasenya", LENGTH_SHORT).show();
                } else if (email.isEmpty()) {
                    Toast.makeText(Registro.this, "Siusplau introdueix un correu", LENGTH_SHORT).show();

                } else if (nomusuari.isEmpty()) {
                    Toast.makeText(Registro.this, "Siusplau introdueix un usuari", LENGTH_SHORT).show();

                } else if (contra.isEmpty()) {
                    Toast.makeText(Registro.this, "Siusplau introdueix una contrasenya", LENGTH_SHORT).show();

                } else if (recontra.isEmpty()) {
                    Toast.makeText(Registro.this, "Siusplau introdueix la verificacio de la contrasenya", LENGTH_SHORT).show();

                } else if ((!contra.isEmpty()) && (!nomusuari.isEmpty())) {
                    if (contra.equals(recontra) == true) {
                        int id = finalTotal.size() + 1;//Si el id comença de 0 s'haura de treure el + 1
                        user = new Usuari(id, nomusuari, email, contra);
                        for (Usuari item : finalTotal) {
                            if (item.getNomUsuari().toString().equals(nomusuari.toString())) {
                                existe = true;
                                Toast.makeText(Registro.this, "El nom d'usuari ja existeix!", Toast.LENGTH_SHORT).show();
                            }
                            if (item.getCorreu().toString().equals(email.toString())) {
                                existe = true;
                                Toast.makeText(Registro.this, "El correu ja existeix!", Toast.LENGTH_SHORT).show();
                            }
                            if (item.getId()==id) {//Si el id ja existeix anem incrementant-lo fins que no ho sigui.
                                id++;
                            }
                        }
                        if (existe == false) {
                            finalTotal.add(user);
                            JsonManage.guardarUsuaris(finalTotal);
                            Toast.makeText(Registro.this, "El usuari s'ha creat amb exit!", Toast.LENGTH_LONG).show();
                            finish();
                        }

                    } else {
                        Toast.makeText(Registro.this, "Les contrasenyes no coincideixen", Toast.LENGTH_LONG).show();
                    }

                }
            }
        });

    }


}
