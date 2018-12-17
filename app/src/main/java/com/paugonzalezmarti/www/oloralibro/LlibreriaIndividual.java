package com.paugonzalezmarti.www.oloralibro;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

public class LlibreriaIndividual extends Activity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.libreria);
        Bundle extras = this.getIntent().getExtras();
        Libreria llibreria = (Libreria) extras.get("libreria");

        //Referenciar los objetos.
        TextView tvNombre = (TextView)findViewById(R.id.tvNomLibreira);
        TextView tvDireccion = (TextView)findViewById(R.id.tvDireccio);
        TextView tvTelefono = (TextView)findViewById(R.id.tvTelefon);
        TextView tvHorario = (TextView)findViewById(R.id.tvHorarios);
        ListView lvActividadesLibreria = (ListView)findViewById(R.id.lvActividades);

        tvNombre.setText(llibreria.getNom());
        tvDireccion.setText(llibreria.getDireccio());
        tvHorario.setText(llibreria.getHorais());
        String telefono = "" + llibreria.getTelefon(); //   O esto o cambiar llibreria.telefon a String
        tvTelefono.setText(telefono);
        //todo Cal mostrar el mapa i fer que s'obri la aplicació de google map

    }
}
