package com.paugonzalezmarti.www.oloralibro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class LlibreriaIndividual extends Activity{
    private ArrayList<String> nombreActivitat;
    private Bundle objetoEnviado;
    private Usuari user;
    private Libreria llibreria;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.libreria);
        final ArrayList<Usuari> usersUpdate = JsonManage.recuperarUsuaris();
        objetoEnviado = getIntent().getExtras();

        if (objetoEnviado != null) {
            llibreria = (Libreria) objetoEnviado.getSerializable("libreria");
            user = (Usuari) objetoEnviado.getSerializable("usuario");
            //Actualitzem al usuari per si tingués algun canvi
            for (Usuari usuari : usersUpdate) {
                if (usuari.getId() == user.getId()) {
                    user = usuari;
                }
            }
        }
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
        nombreActivitat = new ArrayList<>();

        for (Activitat libreria : llibreria.getActivitats()){
            nombreActivitat.add(libreria.getNom());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.simple_listview_personalitzada,nombreActivitat);
        lvActividadesLibreria.setAdapter(adapter);
        lvActividadesLibreria.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent mostrarActivitat = new Intent(LlibreriaIndividual.this, ActivitatIndividual.class);
                ArrayList<Activitat> mostrades = llibreria.getActivitats();
                Activitat activitatSeleccionada = mostrades.get(i);
                objetoEnviado.putSerializable("activitat", activitatSeleccionada);
                objetoEnviado.putSerializable("usuario", user);
                mostrarActivitat.putExtras(objetoEnviado);
                startActivity(mostrarActivitat);
            }
        });

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
