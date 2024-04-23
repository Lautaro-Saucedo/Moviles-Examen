package com.laucha.examen.ui.detalle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.laucha.examen.R;
import com.laucha.examen.databinding.FragmentDetalleBinding;
import com.laucha.examen.ui.gallery.Configuracion;

public class DetalleFragment extends Fragment {

    private DetalleViewModel mViewModel;
    private FragmentDetalleBinding binding;
    public static DetalleFragment newInstance() {
        return new DetalleFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding=FragmentDetalleBinding.inflate(inflater,container,false);
        mViewModel = new ViewModelProvider(this).get(DetalleViewModel.class);
        idioma(Configuracion.getIdioma());
        mViewModel.getLugar().observe(getViewLifecycleOwner(),(lugar -> {
            binding.ivFoto.setImageResource(lugar.getFoto());
            binding.tvNombre.setText(lugar.getNombre());
            binding.tvDescripcion.setText(lugar.getDescripcion());
            binding.tvHorarios.setText(lugar.getHorarios());
            binding.tvCoord.setText(lugar.getCoord().toString());
        }));
        mViewModel.detalles(getArguments());
        return binding.getRoot();
    }

    private void idioma(int idioma){
        if(idioma==1){
            ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Detalles");
        } else {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Details");
        }
    }

}