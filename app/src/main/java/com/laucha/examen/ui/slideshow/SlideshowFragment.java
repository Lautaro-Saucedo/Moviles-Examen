package com.laucha.examen.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.laucha.examen.databinding.FragmentSlideshowBinding;
import com.laucha.examen.ui.gallery.Configuracion;

public class SlideshowFragment extends Fragment {

    private FragmentSlideshowBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        SlideshowViewModel slideshowViewModel = new ViewModelProvider(this).get(SlideshowViewModel.class);
        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        idioma(Configuracion.getIdioma());
        View root = binding.getRoot();

        final TextView textView = binding.textSlideshow;
        slideshowViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        Dialogo.mostrardialogo(getActivity());
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void idioma(int idioma){
        if(idioma==1){
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Salir");
        } else {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Exit");
        }
    }
}