package com.paugonzalezmarti.www.oloralibro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class LlibreriaIndividual extends Activity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.libreria);
        Bundle extras = this.getIntent().getExtras();
        final Libreria llibreria = (Libreria) extras.get("libreria");

        //Referenciar los objetos.
        TextView tvNombre = (TextView)findViewById(R.id.tvNomLibreira);
        TextView tvDireccion = (TextView)findViewById(R.id.tvDireccio);
        TextView tvTelefono = (TextView)findViewById(R.id.tvTelefon);
        TextView tvHorario = (TextView)findViewById(R.id.tvHorarios);
        ListView lvActividadesLibreria = (ListView)findViewById(R.id.lvActividades);
        Button btnMapa = findViewById(R.id.btn_libreria_mapa);

        tvNombre.setText(llibreria.getNom().toUpperCase());
        tvDireccion.setText(llibreria.getDireccio());
        tvHorario.setText(llibreria.getHorariApertura() + " - " + llibreria.getHorariCierre());
        String telefono = "" + llibreria.getTelefon(); //   O esto o cambiar llibreria.telefon a String
        tvTelefono.setText(telefono);
        btnMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //todo Cal mostrar la activitat individual que fa aquesta llibreria.
                //todo Secondary Cal mostrar el mapa com a fragment
                Intent intent = new Intent(LlibreriaIndividual.this,MapsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("libreria", llibreria);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }
}
