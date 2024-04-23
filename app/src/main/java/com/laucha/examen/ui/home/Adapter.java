package com.laucha.examen.ui.home;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.RecyclerView;

import com.laucha.examen.Lugar;
import com.laucha.examen.R;
import com.laucha.examen.databinding.ItemBinding;
import com.laucha.examen.ui.detalle.DetalleFragment;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private Context context;
    private List<Lugar> lista;
    private NavController navController;

    public Adapter(Context context, List<Lugar> lista, NavController navController) {
        this.context = context;
        this.lista = lista;
        this.navController=navController;
    }

    public RecyclerView.ItemDecoration decoracion(int margendp){
        int margen = (int) context.getResources().getDisplayMetrics().density*margendp;
        RecyclerView.ItemDecoration id = new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                outRect.set(margen,margen,margen,margen);
            }
        };
        return id;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemBinding binding = ItemBinding.inflate(LayoutInflater.from(context));
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        Lugar l = lista.get(position);
        holder.binding.tvDescripcion.setText(l.getDescripcion());
        holder.binding.tvNombre.setText(l.getNombre());
        holder.binding.cardView.setOnClickListener(view->{
            Bundle bundle = new Bundle();
            bundle.putSerializable("lugar",l);
            navController.navigate(R.id.action_nav_home_to_nav_detalle,bundle);
        });

    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ItemBinding binding;

        public ViewHolder(ItemBinding binding){
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
