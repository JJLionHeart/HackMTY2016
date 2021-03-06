package com.example.guillermo.mapsprueba;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private CameraUpdate cupCamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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
        mMap = googleMap;

        // Crea variable que almacena la posición en "latitud" y "Longitud" de un punto en este caso
        // se puso Monterrey
        LatLng posMonterrey = new LatLng(25.648637, -100.289831);
        // Se añade un marcador y se le añade una descripción para cuando se le da un tap
        mMap.addMarker(new MarkerOptions().position(posMonterrey).title("Agresión"));

            // Método para cambiar el ícono a los marcadores
            //.icon(BitmapDescriptorFactory.fromResource(R.drawable.marcador_muerte)));

        // Centra la camara del googleMaps en la posición de Monterrey y hace un zoom de 20
        cupCamera = CameraUpdateFactory.newLatLngZoom(posMonterrey, 17);
        // Hace una animación para hacer un zoom a la posicón de Monterrey
        mMap.animateCamera(cupCamera);
    }
}
