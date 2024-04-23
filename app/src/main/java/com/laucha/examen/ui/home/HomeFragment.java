package com.laucha.examen.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;

import com.laucha.examen.databinding.FragmentHomeBinding;
import com.laucha.examen.ui.gallery.Configuracion;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        idioma(Configuracion.getIdioma());
        homeViewModel.getLista().observe(getViewLifecycleOwner(),lista->{
            Adapter adapter =new Adapter(getContext(),lista, Navigation.findNavController(binding.getRoot()));
            binding.rvLista.setAdapter(adapter);
            binding.rvLista.setLayoutManager(new GridLayoutManager(getContext(),2,GridLayoutManager.VERTICAL,false));
            binding.rvLista.addItemDecoration(adapter.decoracion(8));
        });
        homeViewModel.lugares();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void idioma(int idioma){
        if(idioma==1) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Lugares Turísticos");
        } else {
            ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Points of Interest");
        }
    }
}