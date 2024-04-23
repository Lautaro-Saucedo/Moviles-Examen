package com.laucha.examen.ui.gallery;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.gms.maps.GoogleMap;
import com.laucha.examen.MainActivity;
import com.laucha.examen.R;
import com.laucha.examen.databinding.FragmentGalleryBinding;

import java.util.Locale;

public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        idioma(Configuracion.getIdioma());
        binding.rgTipo.setOnCheckedChangeListener((group, checkedId) -> {
            if(checkedId==binding.rbNormal.getId()){
                Configuracion.setTipoMapa(GoogleMap.MAP_TYPE_NORMAL);
            }
            if(checkedId==binding.rbSatelite.getId()){
                Configuracion.setTipoMapa(GoogleMap.MAP_TYPE_SATELLITE);
            }
            if(checkedId==binding.rbTerreno.getId()){
                Configuracion.setTipoMapa(GoogleMap.MAP_TYPE_TERRAIN);
            }
            if(checkedId==binding.rbHibrido.getId()){
                Configuracion.setTipoMapa(GoogleMap.MAP_TYPE_HYBRID);
            }
        });
        binding.rgIdioma.setOnCheckedChangeListener((group, checkedId) -> {
            if(checkedId==binding.rbEspanol.getId()){
                Configuracion.setIdioma(1);
            }
            if(checkedId==binding.rbIngles.getId()){
                Configuracion.setIdioma(2);
            }
            idioma(Configuracion.getIdioma());
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void idioma(int idioma){
        if(idioma==1){
            ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Configuración");
            binding.tvTipo.setText("Tipo de Mapa:");
            binding.rbSatelite.setText("Satélite");
            binding.rbTerreno.setText("Terreno");
            binding.rbHibrido.setText("Híbrido");
            binding.tvIdioma.setText("Idioma");
            binding.rbEspanol.setText("Español");
            binding.rbIngles.setText("Inglés");
        } else {
            ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Configuration");
            binding.tvTipo.setText("Map Type:");
            binding.rbSatelite.setText("Satellite");
            binding.rbTerreno.setText("Terrain");
            binding.rbHibrido.setText("Hybrid");
            binding.tvIdioma.setText("Language");
            binding.rbEspanol.setText("Spanish");
            binding.rbIngles.setText("English");
        }


    }

}