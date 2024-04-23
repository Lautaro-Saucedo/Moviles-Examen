package com.laucha.examen.ui.mapa;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.laucha.examen.Lugar;
import com.laucha.examen.R;
import com.laucha.examen.ui.gallery.Configuracion;

public class MapsFragment extends Fragment {
    private MapsViewModel vm;
    private OnMapReadyCallback callback = new OnMapReadyCallback() {
        @Override
        public void onMapReady(@NonNull GoogleMap googleMap) {
            if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            googleMap.setMapType(Configuracion.getTipoMapa());
            googleMap.setMyLocationEnabled(true);
            for(Lugar ubicacion : Lugar.lista()){
                googleMap.addMarker(new MarkerOptions().position(ubicacion.getCoord()));
            }
            vm.getLocation().observe(getViewLifecycleOwner(), location->{
                LatLng ll = new LatLng(location.getLatitude(),location.getLongitude());

                //googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ll,15));
            });
            vm.ubicacionActual();
            idioma(Configuracion.getIdioma());
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        vm = new ViewModelProvider(this).get(MapsViewModel.class);
        return inflater.inflate(R.layout.fragment_maps, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        vm.borrarCallback();
    }

    private void idioma(int idioma){
        if(idioma==1){
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Mapa");
        } else {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Map");
        }
    }
}