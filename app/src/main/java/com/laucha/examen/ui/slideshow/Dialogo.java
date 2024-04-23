package com.laucha.examen.ui.slideshow;

import android.app.AlertDialog;
import android.content.DialogInterface;

import androidx.fragment.app.FragmentActivity;

import com.laucha.examen.ui.gallery.Configuracion;

public class Dialogo {
    private static String texto;
    private static String si;
    public static void mostrardialogo(FragmentActivity activity){
        idioma(Configuracion.getIdioma());
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(texto);
        builder.setPositiveButton(si, (dialog, which) -> {
            activity.finish();
            System.exit(0);
        });
        builder.setNegativeButton("NO", (dialog, which) -> {
            activity.getSupportFragmentManager().popBackStack();
        });
        AlertDialog ad = builder.create();
        ad.show();
    }

    private static void idioma (int idioma){
        if(idioma==1){
            texto="¿Desea salir?";
            si="SI";
        } else {
            texto="Do you wish to exit?";
            si="YES";
        }
    }

}
