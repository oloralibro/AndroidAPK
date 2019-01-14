package com.paugonzalezmarti.www.oloralibro.Presentation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.paugonzalezmarti.www.oloralibro.Utility.Activitat;
import com.paugonzalezmarti.www.oloralibro.Utility.JsonManage;
import com.paugonzalezmarti.www.oloralibro.Utility.Libreria;
import com.paugonzalezmarti.www.oloralibro.R;
import com.paugonzalezmarti.www.oloralibro.Utility.Usuari;

import java.util.ArrayList;

public class LlibreriaIndividual extends Activity{
    private ArrayList<String> nombreActivitat;
    private Bundle objetoEnviado;
    private Usuari user;
    private Libreria llibreria;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.libreria);

        //Capturem les dades
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

        //Referencies dels objectes.
        TextView tvNombre = (TextView)findViewById(R.id.tvNomLibreira);
        TextView tvDireccion = (TextView)findViewById(R.id.tvDireccio);
        TextView tvTelefono = (TextView)findViewById(R.id.tvTelefon);
        TextView tvHorario = (TextView)findViewById(R.id.tvHorarios);
        ListView lvActividadesLibreria = (ListView)findViewById(R.id.lvActividades);
        Button btnMapa = findViewById(R.id.btn_libreria_mapa);

        //Injeccio de les dades
        tvNombre.setText(llibreria.getNom().toUpperCase());
        tvDireccion.setText(llibreria.getDireccio());
        tvHorario.setText("Horari: " + llibreria.getHorari());
        String telefono = "Telefon: " + llibreria.getTelefon();
        tvTelefono.setText(telefono);

        //Aqui busquem les activitats fetes per el usuari
        nombreActivitat = new ArrayList<>();
        for (Activitat libreria : llibreria.getActivitats()){
            nombreActivitat.add(libreria.getNom());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.simple_listview_personalitzada,nombreActivitat);
        lvActividadesLibreria.setAdapter(adapter);

        //Esdeveniments
        //Aquest mostra els detalls de la activitat seleccionada
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

        //Aquesta mostra la ubicació de la llibreria en un mapa
        btnMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
