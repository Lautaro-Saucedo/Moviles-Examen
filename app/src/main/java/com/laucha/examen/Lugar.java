package com.laucha.examen;

import com.google.android.gms.maps.model.LatLng;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Lugar implements Serializable {
    private int foto;
    private String nombre;
    private String descripcion;
    private String horarios;
    private LatLng coord;

    public Lugar(int foto, String nombre, String descripcion, String horarios,LatLng coord) {
        this.foto = foto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.horarios = horarios;
        this.coord=coord;
    }

    public static List<Lugar> lista(){
        List<Lugar> lista = new ArrayList<>();
        String s = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";
        int[] fotos={R.drawable.f1,R.drawable.f2,R.drawable.f3,R.drawable.f4,R.drawable.f5,
                R.drawable.f6,R.drawable.f7,R.drawable.f8,R.drawable.f9,R.drawable.f10,
                R.drawable.f11,R.drawable.f12,R.drawable.f13,R.drawable.f14};
        LatLng[] coords = {
                new LatLng(-32.915725460650975, -65.36457104288526),
                new LatLng(-32.91586935837491, -65.36312754859321),
                new LatLng(-32.9185734966367, -65.36616230727377),
                new LatLng(-32.91715970424222, -65.36616230727377),
                new LatLng(-32.91819776122181, -65.36724716708848),
                new LatLng(-32.919758008011875, -65.36370430321807),
                new LatLng(-32.91626174326131, -65.3728687137853),
                new LatLng(-32.91527461252991, -65.37580466326786),
                new LatLng(-32.92063107793314, -65.37634055317767),
                new LatLng(-32.92331843244669, -65.37896545875623),
                new LatLng(-32.91598214404429, -65.37700815929873),
                new LatLng(-32.918911637691366, -65.38010342371587),
                new LatLng(-32.91081071421411, -65.37652262748104),
                new LatLng(-32.92189197959795, -65.37198594079042)
        };
        for (int i = 0; i < 14; i++) {
            if(i==0){
                lista.add(new Lugar(fotos[i],"Lugar "+i,"Descripcion "+i,"8:00 a 19:00",coords[i]));
            } else {
                lista.add(new Lugar(fotos[i],"Lugar "+i,"Descripcion "+i+""+s,"8:00 a 19:00",coords[i]));
            }

        }
        return lista;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getHorarios() {
        return horarios;
    }

    public void setHorarios(String horarios) {
        this.horarios = horarios;
    }

    public LatLng getCoord() {
        return coord;
    }

    public void setCoord(LatLng coord) {
        this.coord = coord;
    }
}
