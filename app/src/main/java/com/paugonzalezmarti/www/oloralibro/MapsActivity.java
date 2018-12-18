package com.paugonzalezmarti.www.oloralibro;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(getApplicationContext());
        if ( status == ConnectionResult.SUCCESS){
            // Obtain the SupportMapFragment and get notified when the map is ready to be used.
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);
        }else{
            Dialog dialog = GooglePlayServicesUtil.getErrorDialog(status,(Activity)getApplicationContext(),10);
            dialog.show();
        }
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        final Bundle objetoEnviado = getIntent().getExtras();
        Libreria libreria = null;
        if (objetoEnviado != null) {
            libreria = (Libreria) objetoEnviado.getSerializable("libreria");
        }
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        // Add a marker in Sydney and move the camera
        //todo cal recuperar les coordenades desde la llibreria o activitat.
        LatLng sydney = new LatLng(38.8951100, -77.0363700);
        LatLng eu = new LatLng(-25.2743988, 133.7751312);
        LatLng spain = new LatLng(41.3818, 2.1685);
        float zoomlevel = 16;

        //cargamos los datos de la libreria i los comprovamos
        switch (libreria.getId()){
            case 1:
                mMap.addMarker(new MarkerOptions().position(sydney).title(libreria.getNom()));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,zoomlevel));
                break;
            case 2:
                mMap.addMarker(new MarkerOptions().position(eu).title(libreria.getNom()));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(eu,zoomlevel));
                break;
            case 3:
                mMap.addMarker(new MarkerOptions().position(spain).title(libreria.getNom()));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(spain,zoomlevel));
                break;
        }


        UiSettings uiSettings = mMap.getUiSettings();
        uiSettings.setMyLocationButtonEnabled(true);
        uiSettings.isMyLocationButtonEnabled();
        uiSettings.setZoomControlsEnabled(true);



    }
}
